package usecases.Transaction;

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

  public void execute() {
    this.getAccount().setLastTransactionAt(LocalDate.now());
    this.getAccount().setBalance(this.getAccount().getBalance() + this.getValue());
  }
}
