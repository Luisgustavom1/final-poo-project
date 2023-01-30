package infra.db;

import db.*;
import java.io.*;

public class Repository implements Add {
  public Repository() {}

  public void add(Object object, String file) throws IOException {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream(file);
      ObjectOutputStream stream = new ObjectOutputStream(fileOutputStream);

      stream.writeObject(object);
      stream.flush();
      stream.close();

      fileOutputStream.flush();
      fileOutputStream.close();
    } catch (Exception e) {
      throw new IOException(e.getMessage());
    }
  }
}