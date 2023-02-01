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
  public static void main(String args[]){
    Menu menu = new Menu();
    menu.initMenu();
  }
}