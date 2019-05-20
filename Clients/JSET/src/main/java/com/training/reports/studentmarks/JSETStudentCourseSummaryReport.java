package com.training.reports.studentmarks;

import com.trainging.reports.studentmarks.StudentCourseSummaryReport;

public class JSETStudentCourseSummaryReport extends StudentCourseSummaryReport {

    public JSETStudentCourseSummaryReport() {
        studentCourseDataFormatter = new JSETStudentCourseDataFormatter();
    }

    @Override
    public String generateReport(String courseId) {
        return super.generateReport(courseId);
    }
}
