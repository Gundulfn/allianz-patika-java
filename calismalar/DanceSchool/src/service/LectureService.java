package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class LectureService {
    private List<LectureScheduleTime> lectureScheduleTimeList;

    private List<Student> studentList;
    public static Lecture createLecture(String name, Instructor instructor, Branch branch, int capacity){
        return new Lecture(name, instructor, branch, capacity);
    }

    public static void addLectureScheduleTimeToLecture(Lecture lecture, LectureScheduleTime lectureScheduleTime){
        if(lecture.getLectureScheduleTimeList() == null){
            lecture.setLectureScheduleTimeList(new ArrayList<>());
        }

        lecture.getLectureScheduleTimeList().add(lectureScheduleTime);
    }

    public static void addStudentToLecture(Lecture lecture, Student student){
        if(lecture.getStudentList() == null){
            lecture.setStudentList(new ArrayList<>());
        }

        lecture.getStudentList().add(student);
    }
}
