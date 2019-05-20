package com.trainging;

import com.trainging.reports.studentmarks.StudentCourseSummaryReport;

public class Main {
    

    public static void main(String[] args) {
        StudentCourseSummaryReport studentCourseSummaryReport = new StudentCourseSummaryReport();
        System.out.println(studentCourseSummaryReport.generateReport("javaProgramming"));
    }
}
