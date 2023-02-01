package infra.menu.account;

import entity.Account;
import usecases.Transaction.*;

import java.util.Scanner;

public class ManageAccount {
    private static Scanner sc = new Scanner(System.in);
    private static Account account = null;

    public static void InitMenu() {
        System.out.println(
            "\nSelect the option you want\n" +
            "1. Generate Bank Statement\n" +
            "2. Make Transaction\n"
        );
        ManageAccount.ProcessManageAccount(sc.nextInt());
    }

    public static void ProcessManageAccount(int itemSelected){
        switch (itemSelected) {
            case 1:
                
            break;
            case 2:
                ManageAccount.CreateTransaction();
            break;
            default:
                System.out.println("Item not found\n");
        } 

        ManageAccount.InitMenu();
    }

    public static void CreateTransaction() {
        Scanner sc = new Scanner(System.in);
        System.out.println(
            "==== Type of transaction you want to do ====\n" +
            "1. See Balance \n" +
            "2. Make Deposit\n" +
            "3. Make Payment\n" + 
            "4. Make Withdraw\n" 
        );
        
        switch (sc.nextInt()) {
            case 1:
                System.out.printf("Enter with channel: ");
                new BalanceTransaction(
                    account,
                    sc.next()
                ).execute(sc.nextDouble());
                break;
            case 2:
                System.out.printf("Enter with channel: ");
                new DepositTransaction(
                    account,
                    sc.next()
                ).execute(sc.nextDouble());
                break;
            case 3:
                System.out.printf("Enter with channel: ");
                new PaymentTransaction(
                    account,
                    sc.next()
                ).execute(sc.nextDouble());
                break;
            case 4:
                System.out.printf("Enter with channel: ");
                new WithdrawTransaction(
                    account,
                    sc.next()
                ).execute(sc.nextDouble());
                break;
            default: 
                System.out.println("Item not found\n");
                ManageAccount.CreateTransaction();
        }

        System.out.println("Transaction successfully!!!");
    }
}