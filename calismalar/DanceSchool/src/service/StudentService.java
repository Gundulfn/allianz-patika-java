package service;

import model.Sex;
import model.Student;

import java.math.BigDecimal;
import java.util.Date;

public class StudentService {

    public static Student createStudent(String name, int age, Sex sex, BigDecimal contractAmount,
                                        Date startDate, Date endDate){
        return new Student(name, age, sex, contractAmount, startDate, endDate);
    }
}
