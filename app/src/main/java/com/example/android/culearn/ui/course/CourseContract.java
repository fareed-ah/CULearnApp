package com.example.android.culearn.ui.course;

import com.example.android.culearn.model.Course;
import com.example.android.culearn.model.Grade;

import java.util.ArrayList;
import java.util.List;

public interface CourseContract {

    interface View {
        void displayCourses(List<Course> course);
        void navigateToGrades(int courseID);
    }

    interface Presenter {
        void getCourses();
        void onCourseClicked(Course selectedCourse);
    }
}
