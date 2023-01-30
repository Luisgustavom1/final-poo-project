package infra.db;

import db.*;
import java.io.*;

public class Repository implements Add {
  private FileOutputStream fileOutputStream;
  private FileInputStream fileInputStream;

  private ObjectOutputStream objectOutputStream;
  private ObjectInputStream objectInputStream;

  public Repository(
    String file
  ) {
    try {
      this.fileOutputStream = new FileOutputStream(file);
      this.objectOutputStream = new ObjectOutputStream(this.fileOutputStream);

      this.fileInputStream = new FileInputStream(file);
      this.objectInputStream = new ObjectInputStream(this.fileInputStream);
    } catch (Exception e) {
      this.fileOutputStream = null;
      this.fileInputStream = null;
      
      this.objectOutputStream = null;
      this.objectInputStream = null;
      System.out.println(e.getMessage());
    }
  }

  public void add(Object object) throws IOException {
    try {
      this.objectOutputStream.writeObject(object);
      
      this.objectOutputStream.flush();
      this.objectOutputStream.close();

      this.fileOutputStream.flush();
      this.fileOutputStream.close();
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }

  public Object read() throws IOException {
    Object object = null;

    try {
      object = this.objectInputStream.readObject();
      
      this.objectInputStream.close();
      this.fileInputStream.close();
      return object;
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }
}