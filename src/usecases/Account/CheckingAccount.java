package Account;

import entity.Account;

import java.time.LocalDate;

import Agency.Agency;


public class CheckingAccount extends Account {

    
    private double limiteOverdraft;
    private double adminFee;
    
    
    public CheckingAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, Agency agency, double limiteOverdraft, double adminFee) {
        super(password, isActive, accNumber, balance, createdAt, agency);
        this.limiteOverdraft = limiteOverdraft;
        this.adminFee = adminFee;
    }
    
    public double getLimiteOverdraft() {
        return limiteOverdraft;
    }

    public void setLimiteOverdraft(double limiteOverdraft) {
        this.limiteOverdraft = limiteOverdraft;
    }

    public double getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(double adminFee) {
        this.adminFee = adminFee;
    }
}