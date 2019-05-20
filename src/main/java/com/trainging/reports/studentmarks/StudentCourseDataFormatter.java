package com.trainging.reports.studentmarks;

import com.trainging.domain.datasource.StudentInfoDataSource;
import com.trainging.domain.entities.StudentCourseInfo;
import com.trainging.reports.common.Formatter;

public class StudentCourseDataFormatter implements Formatter<StudentCourseParams> {

    private StudentInfoDataSource studentInfoDataSource;
    private StudentCourseParams studentCourseParams;

    public StudentCourseDataFormatter() {
        this.studentInfoDataSource = new StudentInfoDataSource();
    }

    public String format(StudentCourseParams params) {
        this.studentCourseParams = params;
        
        StringBuilder sb = new StringBuilder();
        sb.append(prepareReportHeader());
        sb.append("Number Of Students: " + params.getCourseInfo().getNumberOfStudents() + "\n");
        sb.append(preparePassedStudents());
        sb.append(prepareFailedStudents());
        sb.append(prepareHighestMarkStudent());
        sb.append(prepareLowestMark());
        sb.append("Course Average: " + params.getAverageCourseMarks());
        return sb.toString();
    }

    protected String prepareReportHeader() {
        StringBuilder header = new StringBuilder();
        header.append("Course Name: " + studentCourseParams.getCourseInfo().getCourseName() + "\n");
        header.append("Instructor Name: " + studentCourseParams.getCourseInfo().getInstructorName() + "\n");
        header.append("From: " + studentCourseParams.getCourseInfo().getStartingDate() + " - ");
        header.append("To: " + studentCourseParams.getCourseInfo().getFinishDate() + "\n");
        header.append("---------------------------------------------------------------------\n");
        return header.toString();
    }

    private String preparePassedStudents() {
        long numberOfPassedStudents = studentCourseParams.countPassedStudents();
        long passedStudentsPercentage = numberOfPassedStudents * 100 / studentCourseParams.getCourseInfo().getNumberOfStudents();
        return "Passed Students: " + numberOfPassedStudents + " ( " + passedStudentsPercentage + " %)\n";
    }
    
    private String prepareFailedStudents() {
        long numberOfFailedStudents = studentCourseParams.countFailedStudents();
        long failedStudentsPercentage = numberOfFailedStudents * 100 / studentCourseParams.getCourseInfo().getNumberOfStudents();
        return "Failed Students: " + numberOfFailedStudents + " ( " + failedStudentsPercentage + " %)\n";
    }

    private String prepareHighestMarkStudent() {
        StudentCourseInfo highestMarkStudentInfo = studentCourseParams.getHighestMarkStudent();
        String highestMarkStudentName = studentInfoDataSource.getStudentInfoById(
                highestMarkStudentInfo.getStudentId()).getStudentName();
        return "Highest Mark: " + highestMarkStudentInfo.getFinalStudentMark().toString() +
                " By Student: " + highestMarkStudentName + "\n";
    }

    private String prepareLowestMark() {
        StudentCourseInfo lowestMark = studentCourseParams.getLowestMarkStudent();
        return "Lowest Mark: " + lowestMark.getFinalStudentMark().toString() + "\n";
    }
}