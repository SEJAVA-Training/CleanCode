package com.trainging.reports.studentmarks;

import com.trainging.domain.entities.CourseInfo;
import com.trainging.domain.entities.StudentCourseInfo;
import com.trainging.domain.entities.StudentInfo;

import java.math.BigDecimal;
import java.util.List;

public class StudentCourseParams {

    private List<StudentInfo> studentInfos;
    private List<StudentCourseInfo> studentCourseInfos;
    private CourseInfo courseInfo;

    public StudentCourseParams(List<StudentInfo> studentInfos, List<StudentCourseInfo> studentCourseInfos, CourseInfo courseInfo) {
        this.studentInfos = studentInfos;
        this.studentCourseInfos = studentCourseInfos;
        this.courseInfo = courseInfo;
    }

    public List<StudentInfo> getStudentInfos() {
        return studentInfos;
    }

    public List<StudentCourseInfo> getStudentCourseInfos() {
        return studentCourseInfos;
    }

    public CourseInfo getCourseInfo() {
        return courseInfo;
    }

    public StudentCourseInfo getHighestMarkStudent() {
        StudentCourseInfo highestMarkStudentInfo = null;
        for (StudentCourseInfo studentCourseInfo : getStudentCourseInfos()) {
            if (highestMarkStudentInfo == null ||
                    studentCourseInfo.getFinalStudentMark().compareTo(highestMarkStudentInfo.getFinalStudentMark()) > 0) {
                highestMarkStudentInfo = studentCourseInfo;
            }
        }
        return highestMarkStudentInfo;
    }

    public StudentCourseInfo getLowestMarkStudent() {
        StudentCourseInfo lowestMarkStudentInfo = null;
        for (StudentCourseInfo studentCourseInfo : getStudentCourseInfos()) {
            if (lowestMarkStudentInfo == null ||
                    studentCourseInfo.getFinalStudentMark().compareTo(lowestMarkStudentInfo.getFinalStudentMark()) < 0) {
                lowestMarkStudentInfo = studentCourseInfo;
            }
        }
        return lowestMarkStudentInfo;
    }

    public BigDecimal getAverageCourseMarks() {
        BigDecimal markSummation = BigDecimal.ZERO;
        for (StudentCourseInfo studentCourseInfo : getStudentCourseInfos()) {
            markSummation = markSummation.add(studentCourseInfo.getFinalStudentMark());
        }
        return markSummation.divide(BigDecimal.valueOf(courseInfo.getNumberOfStudents()));
    }

    public long countFailedStudents() {
        long failedStudentCount = 0;
        for (StudentCourseInfo studentCourseInfo : getStudentCourseInfos()) {
            if (studentCourseInfo.getFinalStudentMark().compareTo(BigDecimal.valueOf(50)) < 0) {
                failedStudentCount++;
            }
        }
        return failedStudentCount;
    }

    public long countPassedStudents() {
        long passedStudentCount = 0;
        for (StudentCourseInfo studentCourseInfo : getStudentCourseInfos()) {
            if (studentCourseInfo.getFinalStudentMark().compareTo(BigDecimal.valueOf(50)) >= 0) {
                passedStudentCount++;
            }
        }
        return passedStudentCount;
    }

}