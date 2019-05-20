package com.trainging.domain.datasource;

import com.trainging.domain.entities.StudentInfo;
import com.trainging.util.Constants;

public class StudentInfoDataSource {
    
    public StudentInfo getStudentInfoById(String studentId) {
        StudentInfo studentInfo = new StudentInfo();
        studentInfo.setStudentId(studentId);
        studentInfo.setStudentName(Constants.STUDENT_NAME_PREFIX + studentId);
        return studentInfo;
    }
}