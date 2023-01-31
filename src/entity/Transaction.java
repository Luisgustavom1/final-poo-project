package entity;

import java.io.Serializable;
import java.time.LocalDate;

public abstract class Transaction implements Serializable {
  private double value;
  private Account account;
  private LocalDate createdAt;
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

  public abstract double execute();

  public double getValue() {
    return this.value;
  }

  public Account getAccount() {
    return this.account;
  }

  public LocalDate getCreatedAt() {
    return this.createdAt;
  }

  public String getChannel() {
    return this.channel;
  }
}