package com.training.reports.studentmarks;

import com.trainging.reports.studentmarks.StudentCourseDataFormatter;
import com.trainging.reports.studentmarks.StudentCourseParams;

import java.time.LocalDateTime;

public class JSETStudentCourseDataFormatter extends StudentCourseDataFormatter {

    @Override
    public String format(StudentCourseParams params) {
        StringBuilder sb = new StringBuilder();
        sb.append("Report Creation Date: " + LocalDateTime.now() + "\n");
        sb.append(super.format(params));
        return sb.toString();
    }
}