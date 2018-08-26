package com.example.android.culearn.model;

public class Course {
    private String courseCode, courseName;
    private String url;
    private int courseID;

    public Course(String courseCode, String courseName, String url) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.url = url;
        this.courseID = Integer.parseInt((url.substring(url.indexOf("=")+1)));
    }

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

}
