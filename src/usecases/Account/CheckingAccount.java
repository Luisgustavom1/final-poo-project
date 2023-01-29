package src.usecases.Account;
import src.entity.Account;
public class CheckingAccount extends Account {
    private double limiteOverdraft;
    private double adminFee;

    public CheckingAccount(double limiteOverdraft, double adminFee) {
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