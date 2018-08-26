package com.example.android.culearn.ui.grade;

import com.example.android.culearn.model.Grade;

import java.util.List;

public interface GradeContract {
    interface Presenter {
        void getGrades(int courseID);
    }

    interface View {
        void displayGrades(List<Grade> gradeList);
    }
}
