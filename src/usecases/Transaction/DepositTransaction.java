package Transaction;

import entity.*;
import java.time.LocalDate;

public class DepositTransaction extends Transaction {
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
    double valueUpdated = this.getAccount().getBalance() + this.getValue();
    this.getAccount().setLastTransactionAt(LocalDate.now());
    this.getAccount().setBalance(valueUpdated);
    return valueUpdated;
  }
}
