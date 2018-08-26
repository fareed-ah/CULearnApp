package com.example.android.culearn.ui.grade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.culearn.R;
import com.example.android.culearn.model.Grade;
import com.example.android.culearn.network.NetworkManager;

import java.util.List;

public class GradeActivity extends AppCompatActivity implements GradeContract.View {
    public static final String EXTRA_COURSE_ID = "courseID";
    private int courseID;
    private GradeContract.Presenter presenter;
    private TextView result;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        setTitle("Grades");
        courseID = getIntent().getIntExtra(EXTRA_COURSE_ID,0);
        recyclerView = findViewById(R.id.gradeRecyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        presenter = new GradePresenterImpl(this,new NetworkManager("fareedahmad","AcuWd48296"));
        presenter.getGrades(courseID);
    }

    @Override
    public void displayGrades(List<Grade> gradeList) {
        final List<Grade> displayList = gradeList;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
               recyclerView.setAdapter(new GradeAdapter(displayList));
            }
        });

    }
}
