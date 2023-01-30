package usecases.Account;

import entity.Account;
import java.time.LocalDate;

import usecases.Agency.Agency;


public class SavingAccount extends Account {
    private double incomeMonth;

    public SavingAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, LocalDate lastTransactionAt, Agency agency,double incomeMonth) {
        super(password,isActive,accNumber,balance,createdAt, agency);
        this.incomeMonth = incomeMonth;
    }

    public double getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(double incomeMonth) {
        this.incomeMonth = incomeMonth;
    }
}