package Transaction;

import entity.*;

import java.io.Serializable;
import java.time.LocalDate;

public class BalanceTransaction extends Transaction implements Serializable {
  public BalanceTransaction (
    Account account,
    String channel
  ) {
    super(
      0.00,
      account,
      channel
    );
  }

  public double execute() {
    this.getAccount().setLastTransactionAt(LocalDate.now());
    return this.getAccount().getBalance();
  }
}
