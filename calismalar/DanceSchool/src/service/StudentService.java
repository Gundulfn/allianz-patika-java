package service;

import model.*;

import java.math.BigDecimal;
import java.util.Date;

public class StudentService {

    public static Student createStudent(String name, int age, Sex sex, BigDecimal contractAmount,
                                        Date startDate, Date endDate){
        return new Student(name, age, sex, contractAmount, startDate, endDate);
    }

    public static void payContractAmount(DanceCourse danceCourse, Student student){
        // If there is at least one bank account, pay
        if(danceCourse.getBankAccountList() != null && danceCourse.getBankAccountList().size() > 0){
            BankAccount bankAccount = danceCourse.getBankAccountList().get(0);
            bankAccount.setAmount(bankAccount.getAmount().add(student.getContractAmount()));

            PaymentMovement paymentMovement = PaymentMovementService.createPaymentMovement(bankAccount,
                    student.getName() + " contract pay", MovementType.INCOME, student.getContractAmount());
            DanceCourseService.addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

            student.setPaid(true);
        }else{
            System.err.println("There is no bank account of dance course, student " + student.getName() + " cannot pay");
        }
    }
}
