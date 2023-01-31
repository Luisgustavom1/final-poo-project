import infra.db.Repository;
import usecases.Account.*;
import usecases.Transaction.*;
import usecases.Agency.AgencyImpl;
import usecases.Address.AddressImpl;

import java.io.IOException;
import java.time.LocalDate;

import java.io.*;
import java.nio.file.*;

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
    BalanceTransaction transaction = new BalanceTransaction(
      salaryAccount,
      "Caixa eletrônico"
    );

    try {
      File file = new File("C:\\Users\\datha\\IdeaProjects\\final-poo-project\\database\\transaction.txt");
      FileWriter fw = new FileWriter(file.getAbsolutePath());
      fw.write(transaction.toString());
      fw.flush();
      fw.close();
      // Repository transactionRepository = new Repository(dir.toString());
      // transactionRepository.write(transaction);
      // Object obj = transactionRepository.read();
      // System.out.println("dd " + obj);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}