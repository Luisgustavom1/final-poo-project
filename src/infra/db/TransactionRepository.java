package infra.db;

import entity.Transaction;
import java.io.*;
import java.util.ArrayList;

public class TransactionRepository {
  private String file;

  public TransactionRepository(
    String file
  ) {
    this.file = file;
  }

  public void write(ArrayList<Transaction> object) throws IOException {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

      objectOutputStream.writeObject(object);
      
      objectOutputStream.flush();
      objectOutputStream.close();

      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  @SuppressWarnings("unchecked")
  public ArrayList<Transaction> read() throws IOException {
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      ArrayList<Transaction> transactions = (ArrayList<Transaction>) objectInputStream.readObject();
      objectInputStream.close();
      fileInputStream.close();

      return transactions;
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }
}