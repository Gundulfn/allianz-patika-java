package service;

import model.*;

import java.util.ArrayList;

public class CustomerService {
    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum){
        return new Customer(name, customerTypeEnum);
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount){
        if(customer.getBankAccountList() == null)
            customer.setBankAccountList(new ArrayList<>());

        customer.getBankAccountList().add(bankAccount);
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest){
        if(customer.getInsuranceRequestList() == null)
            customer.setInsuranceRequestList(new ArrayList<>());

        customer.getInsuranceRequestList().add(insuranceRequest);
    }

    public void addPolicyToCustomer(Customer customer, Policy policy){
        if(customer.getPolicyList() == null)
            customer.setPolicyList(new ArrayList<>());

        customer.getPolicyList().add(policy);
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement){
        if(customer.getPaymentMovementList() == null)
            customer.setPaymentMovementList(new ArrayList<>());

        customer.getPaymentMovementList().add(paymentMovement);
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle){
        if(customer.getVehicleList() == null)
            customer.setVehicleList(new ArrayList<>());

        customer.getVehicleList().add(vehicle);
    }
}
