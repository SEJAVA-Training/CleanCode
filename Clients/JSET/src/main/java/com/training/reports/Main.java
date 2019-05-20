package com.training.reports;

import com.training.reports.studentmarks.JSETStudentCourseSummaryReport;

public class Main {

    public static void main(String[] args) {
        JSETStudentCourseSummaryReport jsetStudentCourseSummaryReport = new JSETStudentCourseSummaryReport();
        System.out.println(jsetStudentCourseSummaryReport.generateReport("javaProgramming"));
    }
}