package com.example.android.culearn.ui.course;

import com.example.android.culearn.model.Course;
import com.example.android.culearn.network.NetworkManager;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CoursePresenterImpl implements CourseContract.Presenter {
    private CourseContract.View view;
    private NetworkManager networkManager;

    public CoursePresenterImpl(CourseContract.View view,NetworkManager networkManager) {
        this.view = view;
        this.networkManager =networkManager;
    }

    @Override
    public void getCourses() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Course> courses = new ArrayList<>();
                Document doc = networkManager.getCourses();
                Elements links = doc.getElementsByClass("course_link");

                for (Element link : links) {
                    if (link.text().contains("[")) {

                        courses.add(new Course(link.text().substring(0, link.text().indexOf("[")-1), link.text().substring(link.text().indexOf("]") + 2,
                                link.text().indexOf("(")-1), link.attr("abs:href")));
                    }
                }
                view.displayCourses(courses);
            }
        }).start();
    }

    @Override
    public void onCourseClicked(Course selectedCourse) {
        //if(view != null){
            view.navigateToGrades(selectedCourse.getCourseID());
       // }
    }
}
