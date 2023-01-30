package usecases.Account;

import entity.Account;
import java.time.LocalDate;

import usecases.Agency.Agency;


public class SalaryAccount extends Account{
    private double limitWithdraw;
    private double limitTransfer;

    public SalaryAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, Agency agency, double limitWithdraw, double limitTransfer) {
        super(password,isActive,accNumber,balance,createdAt, agency);
        this.limitWithdraw = limitWithdraw;
        this.limitTransfer = limitTransfer;
    }

    public double getLimitWithdraw() {
        return limitWithdraw;
    }

    public void setLimitWithdraw(double limitWithdraw) {
        this.limitWithdraw = limitWithdraw;
    }

    public double getLimitTransfer() {
        return limitTransfer;
    }

    public void setLimitTransfer(double limitTransfer) {
        this.limitTransfer = limitTransfer;
    }
}