package usecases.Transaction;

import entity.*;
import java.time.LocalDate;

public class WithdrawTransaction extends Transaction {
  public WithdrawTransaction (
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
    // validar se o valor é maior q o valor total
    this.getAccount().setBalance(this.getAccount().getBalance() - this.getValue());
  }
}
