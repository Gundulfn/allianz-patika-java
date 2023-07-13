package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class DanceCourseService {

    public static final int INSTRUCTOR_AGE_LIMIT = 53;
    public static final int STUDENT_AGE_LIMIT = 18;

    public static DanceCourse createDanceCourse(String name, String address,
                                                String founder, String taxNumber, String taxOffice, int capacity) {
        return new DanceCourse(name, address, founder, taxNumber, taxOffice, capacity);
    }

    public static void addBankAccountToDanceCourse(DanceCourse danceCourse, BankAccount bankAccount) {
        // List.of(bankAccount); // alternative of null list setting
        if (danceCourse.getBankAccountList() == null) {
            danceCourse.setBankAccountList(new ArrayList<>());
        }

        int matchedIbanNoIndex = getMatchedBankAccountIndexByIbanNo(danceCourse, bankAccount);
        if (matchedIbanNoIndex == -1) {
            danceCourse.getBankAccountList().add(bankAccount);
        } else {
            addAmountToExistBankAccount(danceCourse, matchedIbanNoIndex, bankAccount.getAmount());
        }

        calculateTotalMoney(danceCourse);
    }

    private static void calculateTotalMoney(DanceCourse danceCourse) {
        BigDecimal value = BigDecimal.ZERO;
        for (BankAccount bankAccount : danceCourse.getBankAccountList()) {
            value = value.add(bankAccount.getAmount());
        }

        danceCourse.setTotalMoney(value);
    }

    /**
     * @param danceCourse
     * @param bankAccount
     * @return BankAccount index of DanceCourse's BankAccountList or -1 for no matches
     */
    private static int getMatchedBankAccountIndexByIbanNo(DanceCourse danceCourse, BankAccount bankAccount) {

        for (BankAccount _bankAccount : danceCourse.getBankAccountList()) {
            if (_bankAccount.getIbanNo().equals(bankAccount.getIbanNo())) { //
                return danceCourse.getBankAccountList().indexOf(_bankAccount);
            }
        }

        return -1;
    }

    private static void addAmountToExistBankAccount(DanceCourse danceCourse, int bankAccountIndex,
                                                    BigDecimal amount) {
        BigDecimal newAmount = danceCourse.getBankAccountList().get(bankAccountIndex).getAmount().add(amount);
        danceCourse.getBankAccountList().get(bankAccountIndex).setAmount(newAmount);
    }

    public static void addPaymentMovementToDanceCourse(DanceCourse danceCourse, PaymentMovement paymentMovement) {
        if (danceCourse.getPaymentMovementList() == null) {
            danceCourse.setPaymentMovementList(new ArrayList<>());
        }

        danceCourse.getPaymentMovementList().add(paymentMovement);
        calculateTotalMoney(danceCourse);
    }

    public static void addInstructorToDanceCourse(DanceCourse danceCourse, Instructor instructor) {
        // BankAccountList null check
        if (danceCourse.getBankAccountList() == null) {
            System.err.println("There is no bank account added");
            return;
        }

        // Instructor age check
        if (instructor.getAge() > INSTRUCTOR_AGE_LIMIT) {
            System.err.println("Cannot add instructor " + instructor.getName() +
                    " who is older than age limit " + INSTRUCTOR_AGE_LIMIT);
            return;
        }

        BankAccount bankAccount = BankAccountService.
                getBankAccountWithEnoughMoney(danceCourse, instructor.getSalary());

        if (bankAccount != null) {

            // Payment Part
            bankAccount.setAmount(bankAccount.getAmount().subtract(instructor.getSalary()));

            PaymentMovement paymentMovement = PaymentMovementService.createPaymentMovement(bankAccount,
                    instructor.getName() + " salary", MovementType.OUTCOME, instructor.getSalary());
            addPaymentMovementToDanceCourse(danceCourse, paymentMovement);

            // Hiring Instructor Part
            if (danceCourse.getInstructorList() == null) {
                danceCourse.setInstructorList(new ArrayList<>());
            }

            danceCourse.getInstructorList().add(instructor);
        } else {
            System.err.println("There is no enough money, cannot hire instructor " + instructor.getName());
        }
    }

    public static void addStudentToDanceCourse(DanceCourse danceCourse, Student student) {
        if (student.getAge() < STUDENT_AGE_LIMIT) {
            System.err.println("Cannot add student " + student.getName() +
                    " is younger than age limit " + STUDENT_AGE_LIMIT);
            return;
        }

        if (danceCourse.getStudentList() == null) {
            danceCourse.setStudentList(new ArrayList<>());
        }

        if (danceCourse.getStudentList().size() >= danceCourse.getCapacity()) {
            System.err.println("Cannot add student " + student.getName() +
                    ", " + danceCourse.getName() + " has reached its capacity");
            return;
        }

        danceCourse.getStudentList().add(student);
    }

    public static void addLectureToDanceCourse(DanceCourse danceCourse, Lecture lecture) {
        if (danceCourse.getLectureList() == null) {
            danceCourse.setLectureList(new ArrayList<>());
        }

        danceCourse.getLectureList().add(lecture);
    }
}