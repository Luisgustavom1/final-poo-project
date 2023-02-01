package infra.menu.account;

import entity.Account;

import infra.db.AccountRepository;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class ListAccount {
    private static AccountRepository accountRepository = new AccountRepository();

    public static void InitMenu(){
        try {
            ArrayList<Account> accounts = accountRepository.read();

            for (int c = 0; c < accounts.size(); c++) {
                System.out.println(accounts.get(c).toString());
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}