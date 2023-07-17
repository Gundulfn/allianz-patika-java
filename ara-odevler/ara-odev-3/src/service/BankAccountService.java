package service;

import model.Agency;
import model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {

    public BankAccount createBankAccount(String bankName, String ibanNo, BigDecimal amount){
        BankAccount bankAccount = new BankAccount(bankName, ibanNo, amount);
        return bankAccount;
    }
}