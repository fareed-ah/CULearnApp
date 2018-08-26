package com.example.android.culearn.ui.course;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.culearn.databinding.ItemCourseBinding;
import com.example.android.culearn.model.Course;

import java.util.List;

public class CourseAdapter extends RecyclerView.Adapter<CourseViewHolder> {

    private List<Course> courseList;
    private CourseContract.Presenter presenter;

    public CourseAdapter(List<Course> courseList, CourseContract.Presenter presenter) {
        this.courseList = courseList;
        this.presenter = presenter;
    }

    @Override
    public CourseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemCourseBinding binding = ItemCourseBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CourseViewHolder(binding,presenter);
    }

    @Override
    public void onBindViewHolder(CourseViewHolder holder, int position) {
        holder.onBind(courseList.get(position));
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }
}
