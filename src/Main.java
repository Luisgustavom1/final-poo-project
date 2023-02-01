import entity.Transaction;

import usecases.Account.*;
import usecases.Transaction.*;
import usecases.Agency.AgencyImpl;
import usecases.Address.AddressImpl;

import infra.menu.Menu;

import java.io.*;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
  public static void main(String args[]) throws Exception {
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
    // BalanceTransaction transaction = new BalanceTransaction(
    //   salaryAccount,
    //   "Caixa eletrônico"
    // );

    // try {
    //   ArrayList<Transaction> transactions = transactionRepository.read();
    //   transactions.add(transaction);

    //   for (int i = 0; i < transactions.size(); i++) {
    //     System.out.println("Transactions antes de salvar " + transactions.get(i).getAccount().getBalance());
    //   }

    //   transactionRepository.write(transactions);

    //   ArrayList<Transaction> newTransactions = transactionRepository.read();

    //   System.out.println("\nSalvando....\n");
    //   for (int i = 0; i < newTransactions.size(); i++) {
    //     System.out.println("Transactions dps de salvar " + newTransactions.get(i).getAccount().getBalance());
    //   }
    // } catch (IOException e) {
    //   System.out.println(e.getMessage());
    // }

    Menu menu = new Menu();
    menu.initMenu();
  }
}