import entity.Transaction;
import usecases.Account.*;
import usecases.Transaction.*;
import usecases.Agency.AgencyImpl;
import usecases.Address.AddressImpl;
import infra.db.TransactionRepository;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
  public static void main(String args[]) throws Exception {
    TransactionRepository transactionRepository = new TransactionRepository("transaction.dat");
    AddressImpl address = new AddressImpl(
      "city",
      "state",
      "country",
      "neighborhood",
      "streetName",
      "streetNumber"
    );
    AgencyImpl agency = new AgencyImpl(
      12345, 
      "Agencia teste",
      address
    );
    SalaryAccount salaryAccount = new SalaryAccount(
      "12345", 
      true, 
      12345, 
      100000.00, 
      LocalDate.now(), 
      agency, 
      1000.00, 
      500.00
    );
    BalanceTransaction transaction = new BalanceTransaction(
      salaryAccount,
      "Caixa eletrônico"
    );

    try {
      ArrayList<Transaction> transactions = transactionRepository.read();
      transactions.add(transaction);

      for (int i = 0; i < transactions.size(); i++) {
        System.out.println("Transactions antes de salvar" + transactions.get(i));
      }
      System.out.println();
      transactionRepository.write(transactions);

      ArrayList<Transaction> newTransactions = transactionRepository.read();

      for (int i = 0; i < newTransactions.size(); i++) {
        System.out.println("Transactions dps de salvar " + newTransactions.get(i));
      }
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}