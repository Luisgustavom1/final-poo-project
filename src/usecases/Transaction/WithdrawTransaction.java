package usecases.Transaction;

import entity.*;
import java.time.LocalDate;

public class WithdrawTransaction extends Transaction {
  public WithdrawTransaction (
    double value,
    Account account,
    String channel
  ) {
    super(
      value,
      account,
      channel
    );
  }

  public double execute() {
    this.getAccount().setLastTransactionAt(LocalDate.now());
    // validar se o valor é maior q o valor total
    double currentValue = this.getAccount().getBalance() - this.getValue();
    this.getAccount().setBalance(currentValue);
    return currentValue; 
  }
}
