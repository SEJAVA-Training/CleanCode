package com.trainging.domain.datasource;

import com.trainging.domain.entities.CourseInfo;
import com.trainging.util.Constants;

import java.time.LocalDate;

public class CourseInfoDataSource {
    
    public CourseInfo getCourseById(String courseId) {
        //NOTE: Don't implement Database logic we don't test how your knowledge with DB
        
        CourseInfo courseInfo = new CourseInfo();

        courseInfo.setCourseId("javaProgramming");
        courseInfo.setCourseName("Java Programming Course");
        courseInfo.setStartingDate(LocalDate.of(2019, 3, 9));
        courseInfo.setFinishDate(LocalDate.now());
        courseInfo.setInstructorName("Java Programming Instructor");
        courseInfo.setNumberOfStudents(Constants.NUMBER_OF_STUDENTS);

        return courseInfo;
    }
}
