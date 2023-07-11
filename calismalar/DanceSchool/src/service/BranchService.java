package service;

import model.Branch;

public class BranchService {

    public static Branch createBranch(String name){
        return new Branch(name);
    }
}