package com.example.android.culearn.ui.grade;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.android.culearn.R;
import com.example.android.culearn.model.Grade;

public class GradeViewHolder extends RecyclerView.ViewHolder {
    private TextView gradeName, gradeValue;

    public GradeViewHolder(View itemView) {
        super(itemView);
        this.gradeName = itemView.findViewById(R.id.gradeName);
        this.gradeValue = itemView.findViewById(R.id.gradeValue);
    }

    public void onBind(Grade grade) {
        gradeName.setText(grade.getName());
        gradeValue.setText(grade.getValue());
    }
}
