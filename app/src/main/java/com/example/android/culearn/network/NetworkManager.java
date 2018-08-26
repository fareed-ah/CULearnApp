package com.example.android.culearn.network;

import android.util.Log;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class NetworkManager {

    private final String BASE_URL = "https://culearn.carleton.ca/moodle";
    private String username;
    private String password;

    public NetworkManager(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Connection.Response login() {
        Connection.Response response = null;
        try {
            response = Jsoup.connect(BASE_URL + "/login/index.php")
                    .data("username", username,
                            "password", password, "Submit", "login")
                    .method(Connection.Method.POST)
                    .followRedirects(true)
                    .execute();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("tag", "Unable to login: " + e.getMessage());
        }
        return response;
    }

    public Document getCourses() {
        Document doc = null;
        try {
            doc = Jsoup.connect(BASE_URL + "/login/index.php").data("username", username,
                    "password", password, "Submit", "login").post();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("tag", "Unable to retrieve course data: " + e.getMessage());
        }
        return doc;
    }

    public Document getGrades(int courseID) {
        Document doc = null;
        try {
            Connection.Response response = login();
            doc = Jsoup.connect(BASE_URL + "/grade/report/user/index.php?id="+courseID).cookies(response.cookies()).get();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("tag", "Unable to retrieve grades data: " + e.getMessage());
        }
        return doc;
    }
}
