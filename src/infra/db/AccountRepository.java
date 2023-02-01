package infra.db;

import entity.Account;
import java.io.*;
import java.util.ArrayList;

public class AccountRepository {
  private String file;

  public AccountRepository() {
    this.file = "accounts.dat";
  }

  public void write(ArrayList<Account> object) throws IOException {
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
  public ArrayList<Account> read() throws IOException {
    ArrayList<Account> accounts = new ArrayList<>();
    
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      accounts = (ArrayList<Account>) objectInputStream.readObject();
      objectInputStream.close();
      fileInputStream.close();
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    } finally {
      return accounts;
    }
  }
}