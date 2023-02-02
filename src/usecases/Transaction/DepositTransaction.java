package usecases.Transaction;

import entity.*;
import exceptions.GreaterThanZeroException;

import java.time.LocalDate;

public class DepositTransaction extends Transaction {
  public DepositTransaction (
    Account account,
    String channel
  ) {
    super(
      account,
      channel
    );
  }

  /*
  This is a method to execute a deposit operation.
   */
  public double execute(double value) {
    if (value <= 0) {
      throw new GreaterThanZeroException("The deposit must be greater than zero");
    } else {
      this.value = value;
      double valueUpdated = this.getAccount().getBalance() + value;
      this.getAccount().setBalance(valueUpdated);
      this.getAccount().setLastTransactionAt(LocalDate.now());
      return valueUpdated;
    }
  }
}
