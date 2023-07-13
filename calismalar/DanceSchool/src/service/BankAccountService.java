package service;

import model.BankAccount;
import model.DanceCourse;
import model.MovementType;
import model.PaymentMovement;

import java.math.BigDecimal;

public class BankAccountService {

    public static BankAccount createBankAccount(String bankName, String ibanNo,
                                                String companyName, BigDecimal amount){
        return new BankAccount(bankName, ibanNo, companyName, amount);
    }

    public static BankAccount getBankAccountWithEnoughMoney(DanceCourse danceCourse, BigDecimal amount){
        for(BankAccount bankAccount : danceCourse.getBankAccountList()){
            if(bankAccount.getAmount().compareTo(amount) >= 0){
               return bankAccount;
            }
        }

        return null;
    }
}
