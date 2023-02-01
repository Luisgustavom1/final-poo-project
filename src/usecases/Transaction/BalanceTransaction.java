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

  public double execute(double value) {
    this.getAccount().setLastTransactionAt(LocalDate.now());
    return this.getAccount().getBalance();
  }
}
