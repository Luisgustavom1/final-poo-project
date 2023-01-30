import infra.db.Repository;
import usecases.Account.*;
import usecases.Transaction.*;
import usecases.Agency.Agency;
import usecases.Address.AddressImpl;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
  public static void main(String args[]) {
    AddressImpl address = new AddressImpl(
      "city",
      "state",
      "country",
      "neighborhood",
      "streetName",
      "streetNumber"
    );
    Agency agency = new Agency(
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
      Repository transactionRepository = new Repository("caminho-do-projeto-no-seu-pc/database/transaction.txt");
      transactionRepository.add(transaction);
      Object obj = transactionRepository.read();
      System.out.println(obj);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}