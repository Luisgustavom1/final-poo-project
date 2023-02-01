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
    this.value = value;
    if (this.getValue() <= 0) {
      throw new GreaterThanZeroException("The deposit must be greater than zero");
    } 
    else {
      double valueUpdated = this.getAccount().getBalance() + this.getValue();
      this.getAccount().setLastTransactionAt(LocalDate.now());
      this.getAccount().setBalance(valueUpdated);
      return valueUpdated;
    }
  }
}
