import model.*;
import service.*;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceService insuranceService = new InsuranceService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        ProposalService proposalService = new ProposalService();

        // Agency settings
        Agency agency = agencyService.createAgency("MOM Acenta");

        BankAccount agencyBankAccount1 = bankAccountService.createBankAccount("Ziraat", "TR123",
                new BigDecimal(50));
        agencyService.addBankAccountToAgency(agency, agencyBankAccount1);

        // Insurance Company settings
        InsuranceCompany insuranceCompany = insuranceCompanyService
                .createInsuranceCompany("Allianz", "Noter",
                        "1243", "Ankara", new BigDecimal(10));

        BankAccount allianzBankAccount1 = bankAccountService.createBankAccount("Halkbank", "TR2342",
                new BigDecimal(1000000));

        Insurance compulsoryTrafficInsurance = insuranceService.createInsurance(InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE,
                "Zorunlu Trafik Sigortası");

        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany, compulsoryTrafficInsurance);
        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany, allianzBankAccount1);

        agencyService.addInsuranceCompanyToAgency(agency, insuranceCompany);

        // Customer settings
        Customer customerBurak = customerService.createCustomer("Burak", CustomerTypeEnum.INDIVIDUAL);

        BankAccount customerBurakBankAccount1 = bankAccountService
                .createBankAccount("Yapıkredi", "TR9821", new BigDecimal(7000));

        Vehicle customerBurakVehicle = vehicleService.createVehicle("Toyota", "Corolla",
                "34 HI 3434", "WVWZZZ6RZHU095472", 1995, ColorTypeEnum.WHITE);

        customerService.addBankAccountToCustomer(customerBurak, customerBurakBankAccount1);
        customerService.addVehicleToCustomer(customerBurak, customerBurakVehicle);

        agencyService.addCustomerToAgency(agency, customerBurak);

        // Creating insurance request for vehicle
        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(customerBurakVehicle);
        customerService.addInsuranceRequestToCustomer(customerBurak, insuranceRequest);

        Proposal proposal1 = proposalService.createProposal();
        proposalService.addVehicleToProposal(proposal1, customerBurakVehicle);
        proposalService.addInsuranceCompanyToProposal(proposal1, insuranceCompany);
        proposalService.addOfferPriceToProposal(proposal1, new BigDecimal(1000));
        proposalService.addDiscountPriceToProposal(proposal1, new BigDecimal(100));

        LocalDate startDate = LocalDate.of(2023, Month.FEBRUARY.getValue(), DayOfWeek.MONDAY.getValue());
        LocalDate endDate = LocalDate.of(2023, Month.MARCH.getValue(), DayOfWeek.MONDAY.getValue());

        //startDate.plusDays(3);
        LocalDate expireDate = LocalDate.of(2023, Month.FEBRUARY.getValue(), DayOfWeek.THURSDAY.getValue());
        proposalService.addDatesToProposal(proposal1, startDate, endDate, expireDate);

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest, proposal1);
        customerService.acceptProposal(customerBurak, insuranceRequest, proposal1, agency);

        System.out.println(agency.getBankAccountList());
        System.out.println(insuranceCompany.getBankAccountList());
        System.out.println(customerBurak.getBankAccountList() + " " + customerBurak.getPolicyList());
    }
}