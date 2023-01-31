package db;

import java.io.*;
import entity.Transaction;

public interface Write {
  void write(Transaction object) throws IOException; 
}