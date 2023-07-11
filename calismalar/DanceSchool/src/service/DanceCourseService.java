package service;

import model.*;

import java.util.ArrayList;
import java.util.List;

public class DanceCourseService {

    public static DanceCourse createDanceCourse(String name, String address,
                                                String founder, String taxNumber, String taxOffice){
        return new DanceCourse(name, address, founder, taxNumber, taxOffice);
    }


    private List<Student> studentList;
    public static void addBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount){
        if(danceCourse.getBankAccountList() == null){
            danceCourse.setBankAccountList(new ArrayList<>());
        }

        danceCourse.getBankAccountList().add(bankAccount);
    }

    public static void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement){
        if(danceCourse.getPaymentMovementList() == null){
            danceCourse.setPaymentMovementList(new ArrayList<>());
        }

        danceCourse.getPaymentMovementList().add(paymentMovement);
    }

    public static void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor){
        if(danceCourse.getInstructorList() == null){
            danceCourse.setInstructorList(new ArrayList<>());
        }

        danceCourse.getInstructorList().add(instructor);
    }

    public static void addStudentToDanceCourse(DanceCourse danceCourse, Student student){
        if(danceCourse.getStudentList() == null){
            danceCourse.setStudentList(new ArrayList<>());
        }

        danceCourse.getStudentList().add(student);
    }
}