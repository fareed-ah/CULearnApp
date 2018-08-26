package com.example.android.culearn.ui.course;

import android.support.v7.widget.RecyclerView;

import com.example.android.culearn.databinding.ItemCourseBinding;
import com.example.android.culearn.model.Course;

import java.util.prefs.PreferenceChangeEvent;

public class CourseViewHolder extends RecyclerView.ViewHolder {

    private ItemCourseBinding binding;
    private CourseContract.Presenter presenter;

    public CourseViewHolder(ItemCourseBinding binding, CourseContract.Presenter presenter) {
        super(binding.getRoot());
        this.binding = binding;
        this.presenter = presenter;
    }

    public void onBind(Course course) {
        binding.setCourse(course);
        binding.setPresenter(presenter);
        binding.executePendingBindings();
    }
}
