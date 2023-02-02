package usecases.Transaction;

import entity.*;
import java.time.LocalDate;

public class BalanceTransaction extends Transaction {
  public BalanceTransaction (
    Account account,
    String channel
  ) {
    super(
      account,
      channel
    );
  }

  /*
  This is a method to execute a balance operation.
   */
  public double execute(double value) {
    this.value = this.getAccount().getBalance();
    this.getAccount().setLastTransactionAt(LocalDate.now());
    return this.value;
  }
}
