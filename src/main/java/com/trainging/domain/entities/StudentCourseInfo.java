package com.trainging.domain.entities;

import java.math.BigDecimal;

public class StudentCourseInfo {

    private String studentId;
    private String courseId;

    // Student Mark Out of 100
    private BigDecimal finalStudentMark;
    //... Other useless info 

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public BigDecimal getFinalStudentMark() {
        return finalStudentMark;
    }

    public void setFinalStudentMark(BigDecimal finalStudentMark) {
        this.finalStudentMark = finalStudentMark;
    }
}