package com.example.android.culearn;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.android.culearn.model.Course;
import com.example.android.culearn.model.Grade;
import com.example.android.culearn.network.NetworkManager;
import com.example.android.culearn.ui.course.CourseAdapter;
import com.example.android.culearn.ui.course.CourseContract;
import com.example.android.culearn.ui.course.CoursePresenterImpl;
import com.example.android.culearn.ui.grade.GradeActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity implements CourseContract.View {
    private RecyclerView courseRecyclerView;
    private CoursePresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Courses");
        courseRecyclerView = findViewById(R.id.courseRecyclerView);
        courseRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        presenter = new CoursePresenterImpl(this,new NetworkManager("fareedahmad", "AcuWd48296"));
        presenter.getCourses();
    }

    @Override
    public void displayCourses(List<Course> courses) {
        final List<Course> courseList = courses;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                courseRecyclerView.setAdapter(new CourseAdapter(courseList,presenter));
            }
        });
    }

    @Override
    public void navigateToGrades(int courseID) {
        startActivity(new Intent(this, GradeActivity.class).putExtra(GradeActivity.EXTRA_COURSE_ID,courseID));
    }
}
