package main;

import main.transcript.*;
import util.*;

public class Main {
    public static void main(String[] args) {
        GradeTest gradeTest = new GradeTest();
        gradeTest.printGradeValues();

        transcriptTest();

        GenerateTranscript generateTranscript = new GenerateTranscript();

        generateTranscript.takeInputFromUser();
        generateTranscript.takeInputFromFile();
    }

    private static void transcriptTest(){
        // Custom course grades
        // non-valid setGradeTaken parameter
        CourseGrade courseGrade1 = new CourseGrade(CourseDepartment.ME);
        courseGrade1.setGradeTaken(9);

        // non-valid courseCode
        CourseGrade courseGrade2 = new CourseGrade(CourseDepartment.COMP, 742);
        courseGrade2.setGradeTaken(1.1);

        // non-valid courseCredit
        CourseGrade courseGrade3 = new CourseGrade(CourseDepartment.ME, 211, 23);
        courseGrade3.setGradeTaken(2.49);

        // non-valid gradeTaken
        CourseGrade courseGrade4 = new CourseGrade(CourseDepartment.ECE, 401, 3, null);
        CourseGrade courseGrade5 = new CourseGrade(CourseDepartment.ECE, 401, 3, Grade.A);

        Transcript transcript = new Transcript(17042098);
        System.out.println(transcript.toString());

        transcript.addCourseTaken(courseGrade1);
        transcript.addCourseTaken(courseGrade2);
        transcript.addCourseTaken(courseGrade3);
        transcript.addCourseTaken(courseGrade4);
        transcript.addCourseTaken(courseGrade5);
        transcript.addCourseTaken(null);

        System.out.println(transcript.toString());
    }
}