package usecases.Account;
import entity.Account;
import usecases.Agency.AgencyImpl;
import java.time.LocalDate;

public class CheckingAccount extends Account {
    private double limitOverdraft;
    private double adminFee;
    
    
    public CheckingAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, AgencyImpl agency, double limitOverdraft, double adminFee) {
        super(password, isActive, accNumber, balance, createdAt, agency);
        this.limitOverdraft = limitOverdraft;
        this.adminFee = adminFee;
    }
    
    public double getLimitOverdraft() {
        return limitOverdraft;
    }

    public void setLimitOverdraft(double limitOverdraft) {
        this.limitOverdraft = limitOverdraft;
    }

    public double getAdminFee() {
        return adminFee;
    }

    public void setAdminFee(double adminFee) {
        this.adminFee = adminFee;
    }
}