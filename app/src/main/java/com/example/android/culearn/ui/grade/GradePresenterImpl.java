package com.example.android.culearn.ui.grade;

import android.util.Log;

import com.example.android.culearn.model.Course;
import com.example.android.culearn.model.Grade;
import com.example.android.culearn.network.NetworkManager;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class GradePresenterImpl implements GradeContract.Presenter {
    private GradeContract.View view;
    private NetworkManager networkManager;

    public GradePresenterImpl(GradeContract.View view, NetworkManager networkManager) {
        this.view = view;
        this.networkManager = networkManager;
    }

    @Override
    public void getGrades(final int courseID) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Grade> gradeList = new ArrayList<>();
                Document doc = networkManager.getGrades(courseID);
                Elements rows = doc.select("tbody").select("tr");
                rows.remove(0);

                String name;
                String value;
                for (Element row : rows) {
                    if(row.children().size()!=0) {
                       // Log.d("ID: ", row.id());
                        name = row.select("span").text();
                        if(name.equals("")){
                            name = row.select("a").text();
                        }
                        value = row.select("td[class*=column-grade]").text();
                        if(value.equals("")){
                            continue;
                        }
                        gradeList.add(new Grade(name,value));
                    }
                }
                view.displayGrades(gradeList);
            }
        }).start();
    }
}
