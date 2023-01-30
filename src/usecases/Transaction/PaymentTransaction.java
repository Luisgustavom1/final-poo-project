package Transaction;

import entity.*;
import exceptions.InsufficientBalanceException;
import java.time.LocalDate;

public class PaymentTransaction extends Transaction {
  public PaymentTransaction (
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
    if (this.getValue() > this.getAccount().getBalance()) {
      throw new InsufficientBalanceException("Insufficient balance");
    }
    double valueUpdated = this.getAccount().getBalance() - this.getValue();
    this.getAccount().setBalance(valueUpdated);
    return valueUpdated; 
  }
}
