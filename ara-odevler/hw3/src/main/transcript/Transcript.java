package main.transcript;

import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private int studentID;
    private List<CourseGrade> courseGradeList;
    private double GPA;

    // Constructors
    public Transcript(int studentID) {
        this.studentID = studentID;

        GPA = 0.0;
        courseGradeList = new ArrayList<>();
    }

    // Class methods
    public void addCourseTaken(CourseGrade courseGrade) {
        if (courseGrade == null) {
            System.out.println("ERROR: Null entered course");
            return;
        }

        courseGradeList.add(courseGrade);
        calculateGPA();
    }

    private void calculateGPA() {
        double gradeSum = 0;
        for (CourseGrade courseGrade : courseGradeList) {
            gradeSum += courseGrade.getGradeTaken().numericValue;
        }

        GPA = gradeSum / courseGradeList.size();
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    // toString method
    @Override
    public String toString() {
        String str = "Student ID: " + this.studentID + "\n";

        for (CourseGrade courseGrade : courseGradeList) {
            str += courseGrade + "\n";
        }

        return str + "GPA: " + this.GPA;
    }
}