import model.Agency;
import model.Customer;
import model.CustomerTypeEnum;
import service.AgencyService;
import service.CustomerService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        AgencyService agencyService = new AgencyService();
        CustomerService customerService = new CustomerService();

        Agency momAgency = agencyService.createAgency("MOM Acenta");
        Customer customer1 = customerService.createCustomer("Burak", CustomerTypeEnum.INDIVIDUAL);

        agencyService.addCustomerToAgency(momAgency, customer1);

        System.out.println(momAgency);
    }
}