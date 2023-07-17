package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {
    public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber,
                                                   String address, BigDecimal commission){
        InsuranceCompany insuranceCompany = new InsuranceCompany(name, taxOffice, taxNumber, address, commission);
        return insuranceCompany;
    }

    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance){
        if(insuranceCompany.getInsuranceList() == null)
            insuranceCompany.setInsuranceList(new ArrayList<>());

        insuranceCompany.getInsuranceList().add(insurance);
    }

    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount){
        if(insuranceCompany.getBankAccountList() == null)
            insuranceCompany.setBankAccountList(new ArrayList<>());

        insuranceCompany.getBankAccountList().add(bankAccount);
    }

    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement){
        if(insuranceCompany.getPaymentMovementList() == null)
            insuranceCompany.setPaymentMovementList(new ArrayList<>());

        insuranceCompany.getPaymentMovementList().add(paymentMovement);
    }
}