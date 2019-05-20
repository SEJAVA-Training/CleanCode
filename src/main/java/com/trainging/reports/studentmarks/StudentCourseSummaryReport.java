package com.trainging.reports.studentmarks;

import com.trainging.reports.common.Report;

public class StudentCourseSummaryReport implements Report<String> {

    protected StudentCourseDataCollector studentCourseDataCollector;
    protected StudentCourseDataFormatter studentCourseDataFormatter;

    public StudentCourseSummaryReport() {
        studentCourseDataCollector = new StudentCourseDataCollector();
        studentCourseDataFormatter = new StudentCourseDataFormatter();
    }

    public String generateReport(String courseId) {
        StudentCourseParams studentCourseParams = studentCourseDataCollector.collect(courseId);
        return studentCourseDataFormatter.format(studentCourseParams);
    }
}
