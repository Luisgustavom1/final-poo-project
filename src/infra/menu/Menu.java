package infra.menu;

import infra.menu.account.AccountMenu;
import java.util.Scanner;

public class Menu {
    private int choice;
    Scanner sc = new Scanner(System.in);

    public Menu() {
        AccountMenu.printAccount();
    }
}
