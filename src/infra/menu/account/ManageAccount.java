package infra.menu.account;

import entity.Transaction;

import infra.db.Repository;
import entity.Account;
import usecases.Transaction.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;

public class ManageAccount {
    private static Repository transactionRepository = new Repository("transactions.dat");
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
        Transaction transaction = null;
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
                transaction = new BalanceTransaction(
                    account,
                    sc.next()
                );
                transaction.execute(0.0);
                break;
            case 2:
                System.out.printf("Enter with channel: ");
                transaction = new DepositTransaction(
                    account,
                    sc.next()
                );
                System.out.printf("Enter with value: ");
                transaction.execute(sc.nextDouble());
                break;
            case 3:
                System.out.printf("Enter with channel: ");
                transaction = new PaymentTransaction(
                    account,
                    sc.next()
                );
                System.out.printf("Enter with value: ");
                transaction.execute(sc.nextDouble());
                break;
            case 4:
                System.out.printf("Enter with channel: ");
                transaction = new WithdrawTransaction(
                    account,
                    sc.next()
                );
                System.out.printf("Enter with value: ");
                transaction.execute(sc.nextDouble());
                break;
            default: 
                System.out.println("Item not found\n");
                ManageAccount.CreateTransaction();
        }

        ManageAccount.SaveTransaction(transaction);
    }

    public static void SaveTransaction(Transaction transaction) {
        try {
            ArrayList<Object> transactions = transactionRepository.read();
            transactions.add(transaction);

            transactionRepository.write(transactions);
            System.out.println("\n==== Transaction created successfully!! ====\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ManageAccount.InitMenu();
        }
    }
}