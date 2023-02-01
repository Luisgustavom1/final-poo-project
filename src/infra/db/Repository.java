package infra.db;

import java.io.*;
import java.util.ArrayList;

public class Repository {
  private String file;

  public Repository(String file) {
    this.file = file;
  }

  public void write(ArrayList<Object> object) throws IOException {
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
  public ArrayList<Object> read() throws IOException {
    ArrayList<Object> objects = new ArrayList<>();
    
    try {
      FileInputStream fileInputStream = new FileInputStream(file);
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

      objects = (ArrayList<Object>) objectInputStream.readObject();
      objectInputStream.close();
      fileInputStream.close();
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    } finally {
      return objects;
    }
  }
}