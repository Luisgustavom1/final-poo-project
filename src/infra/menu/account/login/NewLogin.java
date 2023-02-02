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

        System.out.print("\n===== Login =====\n" +
                "Account: ");
        accNumber = sc.nextDouble();
        sc.nextLine();
        System.out.print("Password: ");
        password = sc.nextLine();

        try {
            ArrayList<Object> accounts = accountRepository.read();
            Account loggedAccount = null;

            for (int c = 0; c < accounts.size(); c++) {
                Account acc = (Account) accounts.get(c);
                if((acc.getAccNumber() == accNumber) && (acc.getPassword().equals(password))) {
                    loggedAccount = acc;
                    ManageAccount.InitMenu(acc);
                }
            }
            
            if (loggedAccount == null) {
                System.out.println("\nIncorrect account or password, please try again!\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

