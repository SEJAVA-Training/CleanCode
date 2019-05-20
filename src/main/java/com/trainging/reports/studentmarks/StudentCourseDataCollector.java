package com.trainging.reports.studentmarks;

import com.trainging.domain.datasource.CourseInfoDataSource;
import com.trainging.domain.datasource.StudentCourseInfoDataSource;
import com.trainging.domain.datasource.StudentInfoDataSource;
import com.trainging.domain.entities.CourseInfo;
import com.trainging.domain.entities.StudentCourseInfo;
import com.trainging.domain.entities.StudentInfo;
import com.trainging.reports.common.Collector;

import java.util.ArrayList;
import java.util.List;

public class StudentCourseDataCollector implements Collector<StudentCourseParams, String> {

    private CourseInfoDataSource courseInfoDataSource;
    private StudentInfoDataSource studentInfoDataSource;
    private StudentCourseInfoDataSource studentCourseInfoDataSource;

    public StudentCourseDataCollector() {
        courseInfoDataSource = new CourseInfoDataSource();
        studentInfoDataSource = new StudentInfoDataSource();
        studentCourseInfoDataSource = new StudentCourseInfoDataSource();
    }

    @Override
    public StudentCourseParams collect(String courseId) {
        CourseInfo courseInfo = courseInfoDataSource.getCourseById(courseId);
        List<StudentCourseInfo> studentCourseInfos = studentCourseInfoDataSource.getStudentInfoByCourseId(courseId);

        List<StudentInfo> studentInfos = new ArrayList<>();
        for (StudentCourseInfo studentCourseInfo : studentCourseInfos) {
            studentInfos.add(studentInfoDataSource.getStudentInfoById(studentCourseInfo.getStudentId()));
        }

        return new StudentCourseParams(studentInfos, studentCourseInfos, courseInfo);
    }
}