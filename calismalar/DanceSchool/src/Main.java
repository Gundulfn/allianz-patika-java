import model.*;
import service.*;

import java.math.BigDecimal;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws Exception {
        Branch branch1 = BranchService.createBranch("Zeybek");
        Branch branch2 = BranchService.createBranch("Horon");

        Instructor instructor1 = InstructorService.createInstructor("Semih", 25, Sex.MALE,
                                    new BigDecimal(10000), branch1, branch2);

        Lecture lecture1 = LectureService.createLecture("Zeybek 101", instructor1, branch1, 30);

        LectureScheduleTime lectureScheduleTime1 = LectureScheduleTimeService.createLectureScheduleTime(
                                                    Day.FRIDAY, "10.00");

        Student student1 = StudentService.createStudent("Ayşe", 17, Sex.FEMALE,
                            new BigDecimal(1200), new Date(2023, 3, 12), new Date(2023, 4, 12));

        DanceCourse danceCourse = DanceCourseService.createDanceCourse("Patika Dans", "Patika",
                            "MFÖ", "123654", "51. Noter");

        BankAccount bankAccount1 = BankAccountService.createBankAccount("Halkbank", "TR4321",
                                    danceCourse.getName(), new BigDecimal(150000));

        LectureService.addLectureScheduleTimeToLecture(lecture1, lectureScheduleTime1);
        LectureService.addStudentToLecture(lecture1, student1);

        DanceCourseService.addBankAccountToDanceCourse(danceCourse, bankAccount1);
        DanceCourseService.addInstructorToDanceCourse(danceCourse, instructor1);
        DanceCourseService.addStudentToDanceCourse(danceCourse, student1);

        System.out.println(danceCourse);
    }
}