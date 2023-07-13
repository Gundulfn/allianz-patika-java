package service;

import model.Branch;

import java.util.ArrayList;
import java.util.List;

public class InitialDataService {
    public static List<Branch> loadInitialDataForBranches(){
        Branch branch1 = BranchService.createBranch("Zeybek");
        Branch branch2 = BranchService.createBranch("Horon");

        return new ArrayList<>(){{
            add(branch1);
            add(branch2);
        }};
    }
}
