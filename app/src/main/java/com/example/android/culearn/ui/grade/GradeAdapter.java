package com.example.android.culearn.ui.grade;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.culearn.R;
import com.example.android.culearn.model.Grade;

import java.util.List;

public class GradeAdapter extends RecyclerView.Adapter<GradeViewHolder> {
    private List<Grade> gradeList;

    public GradeAdapter(List<Grade> gradeList) {
        this.gradeList = gradeList;
    }

    @Override
    public GradeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new GradeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grade,parent,false));
    }

    @Override
    public void onBindViewHolder(GradeViewHolder holder, int position) {
        holder.onBind(gradeList.get(position));
    }

    @Override
    public int getItemCount() {
        return gradeList.size();
    }
}
