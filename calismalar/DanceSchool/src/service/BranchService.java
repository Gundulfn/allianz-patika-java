package service;

import model.Branch;

import java.util.List;

public class BranchService {

    public static Branch createBranch(String name){
        return new Branch(name);
    }

    public static void createBranchToBranchList(List<Branch> branchList, String branchName){
        for(Branch branch : branchList){
            if(branch.getName().equalsIgnoreCase(branchName)){
                System.err.println("Branch " + branchName + " is already exists as " + branch.getName()); // Red text :D
                return;
            }
        }

        branchList.add(new Branch(branchName));
    }
}