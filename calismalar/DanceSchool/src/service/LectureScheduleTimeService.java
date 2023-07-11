package service;

import model.LectureScheduleTime;
import model.Day;

public class LectureScheduleTimeService {

    public static LectureScheduleTime createLectureScheduleTime(Day day, String time){
        return new LectureScheduleTime(day, time);
    }
}
