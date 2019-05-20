package com.trainging.domain.datasource;

import com.trainging.domain.entities.StudentCourseInfo;
import com.trainging.util.Constants;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseInfoDataSource {
    
    public List<StudentCourseInfo> getStudentInfoByCourseId(String courseId) {
        //NOTE: Don't implement Database logic we don't test how your knowledge with DB
        
        List<StudentCourseInfo> studentCourseInfos = new ArrayList<StudentCourseInfo>();

        for (int i = 0; i < Constants.NUMBER_OF_STUDENTS; ++i) {
            double randomStudentMark = Math.random() * 100;

            StudentCourseInfo studentCourseInfo = new StudentCourseInfo();
            studentCourseInfo.setCourseId("javaProgramming");
            studentCourseInfo.setFinalStudentMark(BigDecimal.valueOf(randomStudentMark));
            studentCourseInfo.setStudentId(i + "");
            studentCourseInfos.add(studentCourseInfo);
        }
        return studentCourseInfos;
    }
}