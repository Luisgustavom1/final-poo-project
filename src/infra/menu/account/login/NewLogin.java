package infra.menu.account.login;

import entity.Account;
import infra.db.Repository;
import infra.menu.account.ManageAccount;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class NewLogin {
    private static Repository accountRepository = new Repository("accounts.dat");

    public static void InitMenu(){
        Scanner sc = new Scanner(System.in);
        double accNumber;
        String password;

        System.out.print("===== LOGIN =====\n" +
                "Account: ");
        accNumber = sc.nextDouble();
        sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();

        try {
            ArrayList<Object> accounts = accountRepository.read();

            for (int c = 0; c < accounts.size(); c++) {
                Account a = (Account) accounts.get(c);

                if((a.getAccNumber() == accNumber) && (a.getPassword().equals(password))) {
                    ManageAccount.InitMenu(a);
                }

            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

