package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class InsuranceCompanyService {

    PaymentMovementService paymentMovementService = new PaymentMovementService();
    AgencyService agencyService = new AgencyService();

    public InsuranceCompany createInsuranceCompany(String name, String taxOffice, String taxNumber,
                                                   String address, BigDecimal commission) {
        InsuranceCompany insuranceCompany = new InsuranceCompany(name, taxOffice, taxNumber, address, commission);
        return insuranceCompany;
    }

    public void addInsuranceToInsuranceCompany(InsuranceCompany insuranceCompany, Insurance insurance) {
        if (insuranceCompany.getInsuranceList() == null)
            insuranceCompany.setInsuranceList(new ArrayList<>());

        insuranceCompany.getInsuranceList().add(insurance);
    }

    public void addBankAccountToInsuranceCompany(InsuranceCompany insuranceCompany, BankAccount bankAccount) {
        if (insuranceCompany.getBankAccountList() == null)
            insuranceCompany.setBankAccountList(new ArrayList<>());

        insuranceCompany.getBankAccountList().add(bankAccount);
    }

    public void addPaymentMovementToInsuranceCompany(InsuranceCompany insuranceCompany, PaymentMovement paymentMovement) {
        if (insuranceCompany.getPaymentMovementList() == null)
            insuranceCompany.setPaymentMovementList(new ArrayList<>());

        insuranceCompany.getPaymentMovementList().add(paymentMovement);
    }

    public void addPolicyMoney(InsuranceCompany insuranceCompany, Agency agency, BigDecimal amount) {
        if(insuranceCompany.getBankAccountList() == null){
            System.out.println("Cannot take policy money, no bank account added to insurance company");
            return;
        }

        BankAccount bankAccount = insuranceCompany.getBankAccountList().get(0);
        BigDecimal commissionPay = amount.divide(insuranceCompany.getCommission());

        amount = amount.subtract(commissionPay);
        bankAccount.setAmount(bankAccount.getAmount().add(amount));

        PaymentMovement companyIncomePaymentMovement = paymentMovementService.createPaymentMovement(bankAccount,
                "Policy Pay Taken", MovementTypeEnum.INCOME, amount);

        addPaymentMovementToInsuranceCompany(insuranceCompany, companyIncomePaymentMovement);


        agencyService.addMoneyToBankAccount(agency, commissionPay);
    }
}