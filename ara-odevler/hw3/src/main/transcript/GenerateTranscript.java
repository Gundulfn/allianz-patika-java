package main.transcript;

import util.Grade;

import java.io.FileReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GenerateTranscript {
    private static final Scanner input = new Scanner(System.in);

    public Transcript takeInputFromUser() {

        int studentId = -1;
        while (studentId < 0) {
            System.out.println("Enter Student Id:");

            try {
                studentId = input.nextInt();
                if (studentId < 0)
                    System.out.println("ID must be higher than zero");
            } catch (InputMismatchException e) {
                System.out.println("Please enter a positive integer number for ID");
            } finally {
                input.nextLine();
            }
        }

        Transcript transcript = new Transcript(studentId);

        String strInput = "y";
        // Dummy values to set attributes of course grades
        String strDepartment;
        CourseDepartment courseDepartment;
        int courseCode, credit;
        double gradeTakenNo;
        while (strInput.equalsIgnoreCase("y")) {
            strDepartment = "";
            courseDepartment = null;
            courseCode = 0;
            credit = 0;
            gradeTakenNo = 0;

            // Department input
            System.out.print("Enter Department: ");
            strDepartment = input.nextLine();

            try {
                courseDepartment = CourseDepartment.valueOf(strDepartment);
            } catch (IllegalArgumentException e) {
                strDepartment = "";
            }

            // Creating course
            CourseGrade courseGrade = new CourseGrade(courseDepartment);

            // Course code input
            System.out.print("Enter Course Code: ");

            try {
                courseCode = input.nextInt();
            } catch (InputMismatchException e) {
                // Do nothing
            } finally {
                input.nextLine();
            }

            courseGrade.setCourseCode(courseCode);

            // Credit input
            System.out.print("Enter Credit: ");

            try {
                credit = input.nextInt();
            } catch (InputMismatchException e) {
                // Do nothing
            } finally {
                input.nextLine();
            }

            courseGrade.setCourseCredit(credit);

            // Grade taken input
            System.out.print("Enter Grade: ");

            try {
                gradeTakenNo = input.nextInt();
            } catch (InputMismatchException e) {
                // Do nothing
            } finally {
                input.nextLine();
            }
            courseGrade.setGradeTaken(gradeTakenNo);

            // End of course grade addition to transcript
            transcript.addCourseTaken(courseGrade);

            System.out.print("Do you want to add another course(y/n): ");
            strInput = input.nextLine();
        }

        System.out.println(transcript);
        return transcript;
    }

    public Transcript takeInputFromFile() {
        System.out.print("Enter filename: ");
        String fileName = input.nextLine();
        String transcriptText = "";

        try {
            FileReader input = new FileReader(fileName + ".txt");

            int data = input.read();
            while (data != -1) {
                transcriptText += (char) data;
                data = input.read();
            }

            input.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

        try {
            String[] transcriptTextParts = transcriptText.split("\n");
            Transcript transcript = new Transcript(Integer.parseInt(transcriptTextParts[0]));

            CourseDepartment courseDepartment;
            int courseCode, credit;
            double gradeTakenVal;
            String[] courseGradeParts;
            for (int i = 1; i < transcriptTextParts.length; i++) {
                courseGradeParts = transcriptTextParts[i].split(" ");
                courseDepartment = CourseDepartment.valueOf(courseGradeParts[0]);
                courseCode = Integer.parseInt(courseGradeParts[1]);
                credit = Integer.parseInt(courseGradeParts[2]);
                gradeTakenVal = Double.parseDouble(courseGradeParts[3]);

                CourseGrade courseGrade = new CourseGrade(courseDepartment, courseCode, credit);
                courseGrade.setGradeTaken(gradeTakenVal);

                transcript.addCourseTaken(courseGrade);
            }

            System.out.println(transcript);
            return transcript;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.println("Text file:\n" + transcriptText);
        }

        return null;
    }
}