package infra.menu.account;

import infra.menu.account.login.Login;

import java.util.Scanner;
import java.io.IOException;

public class AccountMenu {
    private static Scanner sc = new Scanner(System.in);

    public static void InitMenu() {
        System.out.println(
            "==== Account ====\n" +
            "Select the option you want\n" +
            "1. Login account\n" +
            "2. Create account\n" +
            "3. List all accounts"
        );
        AccountMenu.ProcessAccountMenu(sc.nextInt());
    }

    public static void ProcessAccountMenu(int itemSelected){
        switch (itemSelected) {
            case 1:
                // try {
                    // Login login = new Login(sc.nextLine(), sc.nextLine());

                    ManageAccount.InitMenu();
                // } catch (IOException e) {
                //    System.out.println(e.getMessage());
                // }

            break;
            case 2:
                CreateAccount.InitMenu();
            break;
            case 3:
                ListAccount.InitMenu();
            break;
            default:
                System.out.println("Item not found\n");
        } 

        AccountMenu.InitMenu();
    }
}
