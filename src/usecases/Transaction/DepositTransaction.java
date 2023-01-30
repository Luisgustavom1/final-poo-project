package Transaction;

import entity.*;
import exceptions.GreaterThanZeroException;

import java.io.Serializable;
import java.time.LocalDate;

public class DepositTransaction extends Transaction implements Serializable {
  public DepositTransaction (
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
    if (this.getValue() <= 0) {
      throw new GreaterThanZeroException("The deposit must be greater than zero");
    } 
    double valueUpdated = this.getAccount().getBalance() + this.getValue();
    this.getAccount().setLastTransactionAt(LocalDate.now());
    this.getAccount().setBalance(valueUpdated);
    return valueUpdated;
  }
}
