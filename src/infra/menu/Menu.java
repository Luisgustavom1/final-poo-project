package infra.menu;

import infra.menu.account.AccountMenu;

public class Menu {
    private int choice;

    public Menu() {}

    public void initMenu() {
        AccountMenu.InitMenu();
    }
}
