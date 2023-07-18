package service;

import model.BankAccount;
import model.MovementTypeEnum;
import model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {

    public PaymentMovement createPaymentMovement(BankAccount bankAccount, String description,
                                                        MovementTypeEnum movementType, BigDecimal amount){
        return new PaymentMovement(bankAccount, description, movementType, amount);
    }
}