package service;

import model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();
    PolicyService policyService = new PolicyService();
    InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum) {
        return new Customer(name, customerTypeEnum);
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount) {
        if (customer.getBankAccountList() == null)
            customer.setBankAccountList(new ArrayList<>());

        customer.getBankAccountList().add(bankAccount);
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest) {
        if (customer.getInsuranceRequestList() == null)
            customer.setInsuranceRequestList(new ArrayList<>());

        customer.getInsuranceRequestList().add(insuranceRequest);
    }

    public void addPolicyToCustomer(Customer customer, Policy policy) {
        if (customer.getPolicyList() == null)
            customer.setPolicyList(new ArrayList<>());

        customer.getPolicyList().add(policy);
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement) {
        if (customer.getPaymentMovementList() == null)
            customer.setPaymentMovementList(new ArrayList<>());

        customer.getPaymentMovementList().add(paymentMovement);
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle) {
        if (customer.getVehicleList() == null)
            customer.setVehicleList(new ArrayList<>());

        customer.getVehicleList().add(vehicle);
    }

    public void acceptProposal(Customer customer, InsuranceRequest insuranceRequest,
                                  Proposal proposal, Agency agency) {
        if (insuranceRequest.getProposalList() == null) {
            System.out.println("This insurance request does not have any proposal");
            return;
        }

        if (customer.getInsuranceRequestList().contains(insuranceRequest)) {
            for (InsuranceRequest _insuranceRequest : customer.getInsuranceRequestList()) {
                if (_insuranceRequest.equals(insuranceRequest)) {
                    for (Proposal _proposal : _insuranceRequest.getProposalList()) {
                        if (_proposal.equals(proposal)) {

                            BigDecimal discountedPrice = proposalService.getDiscountedPrice(proposal);
                            BankAccount bankAccount = getBankAccountAvailable(customer, discountedPrice);

                            if (bankAccount != null) {

                                // Subtracting money from customer
                                bankAccount.setAmount(bankAccount.getAmount().subtract(discountedPrice));

                                PaymentMovement paymentMovement = paymentMovementService
                                        .createPaymentMovement(bankAccount, "Proposal Selection Pay",
                                                MovementTypeEnum.OUTCOME, discountedPrice);

                                addPaymentMovementToCustomer(customer, paymentMovement);

                                // Adding money to insurance company
                                insuranceCompanyService.addPolicyMoney(_proposal.getCompany(), agency, discountedPrice);

                                // Creating policy
                                _proposal.setApproved(true);
                                Policy policy = policyService
                                        .createPolicy(_proposal.getCompany(), _insuranceRequest.getVehicle(),
                                                discountedPrice, _proposal.getStartDate(), _proposal.getEndDate());

                                addPolicyToCustomer(customer, policy);
                                System.out.println("Policy succesful");
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Customer" + customer.getName() + "does not have this insurance request");
        }
    }

    private BankAccount getBankAccountAvailable(Customer customer, BigDecimal amount) {
        if (customer.getBankAccountList() != null) {
            for (BankAccount bankAccount : customer.getBankAccountList()) {
                if (bankAccount.getAmount().compareTo(amount) >= 0) {
                    return bankAccount;
                }
            }
        }

        return null;
    }
}
