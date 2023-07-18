package service;

import model.InsuranceCompany;
import model.Policy;
import model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class PolicyService {
    public Policy createPolicy(InsuranceCompany insuranceCompany, Vehicle vehicle,
                               BigDecimal price, LocalDate startDate, LocalDate endDate) {
        Policy policy = new Policy(insuranceCompany, vehicle, price, startDate, endDate);
        return policy;
    }
}
