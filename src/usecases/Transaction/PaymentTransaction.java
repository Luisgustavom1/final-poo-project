package usecases.Transaction;

import entity.*;
import exceptions.InsufficientBalanceException;

import java.time.LocalDate;

public class PaymentTransaction extends Transaction {
  public PaymentTransaction (
    Account account,
    String channel
  ) {
    super(
      account,
      channel
    );
  }

  /*
  This is a method to execute a payment operation.
   */
  public double execute(double value) {
    if (value > this.getAccount().getBalance()) {
      throw new InsufficientBalanceException("Insufficient balance");
    } else {
      this.value = value;
      double valueUpdated = this.getAccount().getBalance() - value;
      this.getAccount().setBalance(valueUpdated);
      this.getAccount().setLastTransactionAt(LocalDate.now());
      return valueUpdated;
    }
  }
}
