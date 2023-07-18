package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AgencyService {

    PaymentMovementService paymentMovementService = new PaymentMovementService();

    public Agency createAgency(String name){
        return new Agency(name);
    }

    public void addBankAccountToAgency(Agency agency, BankAccount bankAccount){
        if(agency.getBankAccountList() == null)
            agency.setBankAccountList(new ArrayList<>());

        agency.getBankAccountList().add(bankAccount);
    }

    public void addPaymentMovementToAgency(Agency agency, PaymentMovement paymentMovement){
        if(agency.getPaymentMovementList() == null)
            agency.setPaymentMovementList(new ArrayList<>());

        agency.getPaymentMovementList().add(paymentMovement);
    }

    public void addCustomerToAgency(Agency agency, Customer customer){
        if(agency.getCustomerList() == null)
            agency.setCustomerList(new ArrayList<>());

        agency.getCustomerList().add(customer);
    }

    public void addInsuranceCompanyToAgency(Agency agency, InsuranceCompany insuranceCompany){
        if(agency.getInsuranceCompanyList() == null)
            agency.setInsuranceCompanyList(new ArrayList<>());

        agency.getInsuranceCompanyList().add(insuranceCompany);
    }

    public void addMoneyToBankAccount(Agency agency, BigDecimal amount){
        if(agency.getBankAccountList() == null)
        {
            System.out.println("Cannot take money, agency has no bank account");
            return;
        }

        BankAccount bankAccount = agency.getBankAccountList().get(0);
        bankAccount.setAmount(bankAccount.getAmount().add(amount));

        PaymentMovement paymentMovement = paymentMovementService
                .createPaymentMovement(bankAccount, "Proposal Selection Pay",
                        MovementTypeEnum.INCOME, amount);

        addPaymentMovementToAgency(agency, paymentMovement);
    }
}