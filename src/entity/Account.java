package entity;

import java.time.LocalDate;

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
        this.lastTransactionAt = LocalDate.now();
        this.agency = agency;
    }

    @Override
    public String toString() {
        String lastTransactionAtString = this.lastTransactionAt == null ? "Not found transactions" : this.lastTransactionAt.toString();
        // TODO implementar um toString pra cada classe que extende o Account, para printar seu atributo especifico, aquele que não é global. Ex:. SalaryAccount tem limitWithdraw
        return "Account { " +
            "AccNumber = '" + this.accNumber + '\'' +
            ", Balance = '" + this.balance + '\'' +
            ", Created at = '" + this.createdAt + '\'' +
            ", Last transaction at = '" + lastTransactionAtString + '\'' +
            ", Agency name = '" + this.agency.getName() + '\'' +
            ", Agency number = '" + this.agency.getNumber() + '\'' +
            '}';
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