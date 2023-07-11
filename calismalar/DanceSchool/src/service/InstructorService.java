package service;

import model.Branch;
import model.Instructor;
import model.Sex;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InstructorService {

    //... VarArgs
    public static Instructor createInstructor(String name, int age, Sex sex, BigDecimal salary, Branch... branches){
        Instructor instructor = new Instructor(name, age, sex, salary);

        for(Branch branch : branches){
            addBranchToInstructor(instructor, branch);
        }

        return instructor;
    }

    public static void addBranchToInstructor(Instructor instructor, Branch branch){
        if(instructor.getBranchList() == null){
            instructor.setBranchList(new ArrayList<>());
        }

        instructor.getBranchList().add(branch);
    }
}
