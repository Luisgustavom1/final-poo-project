package usecases.Transaction;

import entity.*;
import exceptions.InsufficientBalanceException;
import java.time.LocalDate;

public class WithdrawTransaction extends Transaction {
  public WithdrawTransaction (
    Account account,
    String channel
  ) {
    super(
      account,
      channel
    );
  }

  /*
  This is a method to execute a withdraw operation.
   */
  public double execute(double value) {
    this.getAccount().setLastTransactionAt(LocalDate.now());
    this.value = value;

    if (this.getValue() > this.getAccount().getBalance()) {
      throw new InsufficientBalanceException("Insufficient balance");
    }
    else {
      double valueUpdated = this.getAccount().getBalance() - this.getValue();
      this.getAccount().setBalance(valueUpdated);
      return valueUpdated;
    }
  }
}
