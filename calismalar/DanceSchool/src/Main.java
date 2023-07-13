import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        List<Branch> branchList = InitialDataService.loadInitialDataForBranches();
        BranchService.createBranchToBranchList(branchList, "Tango");
        BranchService.createBranchToBranchList(branchList, "Zeybek");
        BranchService.createBranchToBranchList(branchList, "ZEYbek");

        Instructor instructor1 = InstructorService.createInstructor("Semih", 25, Sex.MALE,
                new BigDecimal(400000), branchList.get(0), branchList.get(2));

        Instructor instructor2 = InstructorService.createInstructor("Hülya", 28, Sex.FEMALE,
                new BigDecimal(20000), branchList.get(1));

        Instructor instructor3 = InstructorService.createInstructor("Zeynep", 90, Sex.FEMALE,
                new BigDecimal(15000), branchList.get(2));

        Lecture lecture1 = LectureService.createLecture("Zeybek 101", instructor1,
                branchList.get(0), 30, LectureType.COUPLE);

        LectureScheduleTime lectureScheduleTime1 = LectureScheduleTimeService.createLectureScheduleTime(
                Day.FRIDAY, "10.00");

        Student student1 = StudentService.createStudent("Ayşe", 18, Sex.FEMALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        Student student2 = StudentService.createStudent("Burak", 19, Sex.MALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        Student student3 = StudentService.createStudent("Mülayim", 21, Sex.MALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        Student student4 = StudentService.createStudent("Hayrettin", 21, Sex.MALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        Student student5 = StudentService.createStudent("Asaf", 15, Sex.MALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        Student student6 = StudentService.createStudent("Muhittin", 35, Sex.MALE, new BigDecimal(1200),
                new Date(2023, 3, 12), new Date(2023, 4, 12));

        DanceCourse danceCourse = DanceCourseService.createDanceCourse("Patika Dans Okulu", "İstanbul",
                "MFÖ", "123654", "51. Noter", 30);

        BankAccount bankAccount1 = BankAccountService.createBankAccount("Halkbank", "TR4321",
                danceCourse.getName(), new BigDecimal(150000));
        BankAccount bankAccount2 = BankAccountService.createBankAccount("Denizbank", "TR4321",
                danceCourse.getName(), new BigDecimal(250000));
        BankAccount bankAccount3 = BankAccountService.createBankAccount("Denizbank", "TR1233",
                danceCourse.getName(), new BigDecimal(20000));

        DanceCourseService.addLectureToDanceCourse(danceCourse, lecture1);

        DanceCourseService.addBankAccountToDanceCourse(danceCourse, bankAccount1);
        DanceCourseService.addBankAccountToDanceCourse(danceCourse, bankAccount2);
        DanceCourseService.addBankAccountToDanceCourse(danceCourse, bankAccount3);

        DanceCourseService.addInstructorToDanceCourse(danceCourse, instructor1);
        DanceCourseService.addInstructorToDanceCourse(danceCourse, instructor2);
        DanceCourseService.addInstructorToDanceCourse(danceCourse, instructor3);

        DanceCourseService.addStudentToDanceCourse(danceCourse, student1);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student2);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student3);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student4);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student5);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student6);

        LectureService.addInstructorFromDanceCourseToLecture(lecture1, danceCourse, instructor2);
        LectureService.addInstructorFromDanceCourseToLecture(lecture1, danceCourse, instructor3);
        //LectureService.addLectureScheduleTimeToLecture(lecture1, lectureScheduleTime1);
        LectureService.autoGenerateScheduleTimeForLecture(lecture1, RepeatedTime.EVERY_DAY, "10.00");
        LectureService.autoGenerateScheduleTimeForLecture(lecture1, RepeatedTime.EVERY_WEEKEND, "05.00");
        LectureService.autoGenerateScheduleTimeForLecture(lecture1, RepeatedTime.EVERY_WEEKDAY, "23.00");

        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student1);
        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student2);
        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student3);
        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student4);
        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student5);
        LectureService.addStudentFromDanceCourseToLecture(lecture1, danceCourse, student6);

        StudentService.payContractAmount(danceCourse, student1);

        System.out.println(branchList);
        System.out.println(danceCourse);
        System.out.println(lecture1.getLectureScheduleTimeSet());
    }
}