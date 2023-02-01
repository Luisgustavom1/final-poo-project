package usecases.Account;
import entity.Account;
import java.time.LocalDate;
import usecases.Agency.AgencyImpl;

public class SavingAccount extends Account implements Rendimento {
    private double incomeMonth;

    public SavingAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, AgencyImpl agency, double incomeMonth) {
        super(password,isActive,accNumber,balance,createdAt, agency);
        this.incomeMonth = incomeMonth;
    }

    public double getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(double incomeMonth) {
        this.incomeMonth = incomeMonth;
    }

    @Override
    public double calculaRendimento() {
        return this.getBalance() * (incomeMonth/100);
    }
}