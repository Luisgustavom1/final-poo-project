package src.usecases.Account;
import src.entity.Account;

public class SavingAccount extends Accounts {
    private double incomeMonth;

    public SavingAccount(String password, boolean isActive, double accNumber, double balance, LocalDate createdAt, LocalDate lastTransactionAt, Agency agency,double incomeMonth) {
        super(password,isActive,accNumber,balance,createdAt, lastTransactionAt,agency,incomeMonth);
        this.incomeMonth = incomeMonth;
    }

    public double getIncomeMonth() {
        return incomeMonth;
    }

    public void setIncomeMonth(double incomeMonth) {
        this.incomeMonth = incomeMonth;
    }
}