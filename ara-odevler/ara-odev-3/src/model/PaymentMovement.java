package model;

import java.math.BigDecimal;

public class PaymentMovement {

    private BankAccount bankAccount;
    private String description;
    private MovementTypeEnum movementType;
    private BigDecimal amount;

    public PaymentMovement(BankAccount bankAccount, String description, MovementTypeEnum movementType, BigDecimal amount) {
        this.bankAccount = bankAccount;
        this.description = description;
        this.movementType = movementType;
        this.amount = amount;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public MovementTypeEnum getMovementType() {
        return movementType;
    }

    public void setMovementType(MovementTypeEnum movementType) {
        this.movementType = movementType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "PaymentMovement{" +
                "bankAccount=" + bankAccount +
                ", description='" + description + '\'' +
                ", movementType=" + movementType +
                ", amount=" + amount +
                '}';
    }
}
