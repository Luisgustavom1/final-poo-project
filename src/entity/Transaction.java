package entity;

import entity.Account;
import java.time.LocalDate;

public abstract class Transaction {
  private double value;
  private Account account;
  private LocaleDate createdAt;
  private String channel;

  public Transaction (
    double value,
    Account account,
    String channel
  ) {
    this.value = value;
    this.account = account;
    this.channel = channel;
    this.createdAt = LocalDate.now();
  }

  public abstract void execute();

  public double getValue() {
    return this.value;
  }

  public Account getAccount() {
    return this.account;
  }

  public String getCreatedAt() {
    return this.createdAt;
  }

  public String getChannel() {
    return this.channel;
  }
}