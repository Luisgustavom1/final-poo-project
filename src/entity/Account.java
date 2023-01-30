package entity;

import java.time.LocalDate;
import usecases.Agency.Agency;

public abstract class Account {
    private String password;
    private boolean isActive;
    private double accNumber;
    private double balance;
    private LocalDate createdAt;
    private LocalDate lastTransactionAt;
    private Agency agency;

    public Account(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, Agency agency) {
        this.password = password;
        this.isActive = isActive;
        this.accNumber = accNumber;
        this.balance = balance;
        this.createdAt = createdAt;
        this.lastTransactionAt = null;
        this.agency = agency;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public double getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(double accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getLastTransactionAt() {
        return lastTransactionAt;
    }

    public void setLastTransactionAt(LocalDate lastTransactionAt) {
        this.lastTransactionAt = lastTransactionAt;
    }

    public Agency getAgency() {
        return agency;
    }

    public void setAgency(Agency agency) {
        this.agency = agency;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}