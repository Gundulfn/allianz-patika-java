package service;

import model.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class LectureService {
    private List<LectureScheduleTime> lectureScheduleTimeList;

    private List<Student> studentList;

    public static Lecture createLecture(String name, Instructor instructor,
                                        Branch branch, int capacity, LectureType lectureType) {
        return new Lecture(name, instructor, branch, capacity, lectureType);
    }

    public static void addInstructorFromDanceCourseToLecture(Lecture lecture, DanceCourse danceCourse,
                                                             Instructor instructor){
        if(danceCourse.getInstructorList().contains(instructor)){
            lecture.setInstructor(instructor);
        }else{
            System.err.println("Cannot add instructor " + instructor.getName() + " who is not from " + danceCourse.getName());
        }
    }

    public static void addLectureScheduleTimeToLecture(Lecture lecture, LectureScheduleTime lectureScheduleTime) {
        if (lecture.getLectureScheduleTimeSet() == null) {
            lecture.setLectureScheduleTimeSet(new HashSet<>());
        }

        lecture.getLectureScheduleTimeSet().add(lectureScheduleTime);
    }

    public static void autoGenerateScheduleTimeForLecture(Lecture lecture, RepeatedTime repeatedTime, String time) {
        int startIndex = 0, limit = 0, loopIncreasement = 1;
        if (repeatedTime == RepeatedTime.EVERY_DAY) {
            startIndex = Day.MONDAY.id;
            limit = Day.values().length;
        } else if (repeatedTime == RepeatedTime.EVERY_WEEKDAY) {
            startIndex = Day.MONDAY.id;
            limit = Day.values().length - 2; // Subtracting weekends
        } else if (repeatedTime == RepeatedTime.EVERY_WEEKEND) {
            startIndex = Day.SATURDAY.id;
            limit = Day.values().length;
        }

        for (int i = startIndex; i < limit; i += loopIncreasement) {
            LectureScheduleTime lectureScheduleTime =
                    LectureScheduleTimeService.createLectureScheduleTime(Day.valueOf(i).get(), time);

            addLectureScheduleTimeToLecture(lecture, lectureScheduleTime);
        }

    }

    public static void addStudentFromDanceCourseToLecture(Lecture lecture, DanceCourse danceCourse, Student student) {
        if(!danceCourse.getStudentList().contains(student)){
            System.err.println("Cannot add student " + student.getName() + " who is not from " + danceCourse.getName());
            return;
        }

        if (lecture.getStudentList() == null) {
            lecture.setStudentList(new ArrayList<>());
        }

        if (lecture.getStudentList().size() < lecture.getCapacity()) {
            if(isMaleAndFemaleStudentsInBalance(lecture, student)){
                lecture.getStudentList().add(student);
            }else{
                System.err.println("Cannot add student " + student.getName() +
                        ", male and female students are in imbalance");
            }
        } else {
            System.err.println(lecture.getName() + " capacity is full, cannot add student " + student.getName());
        }
    }

    private static boolean isMaleAndFemaleStudentsInBalance(Lecture lecture, Student newStudent){
        // There is no student registered at lecture, so it's balanced
        if(lecture.getStudentList() == null || lecture.getStudentList().size() == 0){
            return true;
        }

        int maleStudentCount = 0, femaleStudentCount = 0;
        if(newStudent.getSex().equals(Sex.FEMALE)){
            femaleStudentCount++;
        }else if(newStudent.getSex().equals(Sex.MALE)){
            maleStudentCount++;
        }

        for (Student student : lecture.getStudentList()){
            if(student.getSex().equals(Sex.FEMALE)){
                femaleStudentCount++;
            }else if(student.getSex().equals(Sex.MALE)){
                maleStudentCount++;
            }
        }

        if(lecture.getLectureType() == LectureType.COUPLE){
            return maleStudentCount == femaleStudentCount;
        }

        return Math.abs(maleStudentCount - femaleStudentCount) < 2;
    }
}