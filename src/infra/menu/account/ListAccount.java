package infra.menu.account;

import infra.db.Repository;
import java.io.IOException;
import java.util.ArrayList;

public class ListAccount {
    private static Repository accountRepository = new Repository("accounts.dat");

    public static void InitMenu(){
        try {
            ArrayList<Object> accounts = accountRepository.read();

            for (int c = 0; c < accounts.size(); c++) {
                System.out.println(c + 1 + " - " + accounts.get(c).toString() + "\n");
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}