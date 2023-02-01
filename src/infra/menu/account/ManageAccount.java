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

    public static void InitMenu(Account conta) {
        account = conta;
        System.out.println(
            "\nSelect the option you want\n" +
            "1. Generate Bank Statement\n" +
            "2. Make Transaction\n"
        );
        System.out.print("Option: ");
        ManageAccount.ProcessManageAccount(sc.nextInt());
    }

    public static void ProcessManageAccount(int itemSelected){
        switch (itemSelected) {
            case 1:
                ManageAccount.CreateBankStatement();
            break;
            case 2:
                ManageAccount.CreateTransaction();
            break;
            default:
                System.out.println("Item not found\n");
        } 

        ManageAccount.InitMenu(account);
    }

    public static void CreateBankStatement(){
        System.out.printf("===== Generate bank statement of account %f ======\n", account.getAccNumber());
        ManageAccount.loadTransaction();
    }

    public static void CreateTransaction() {
        Scanner sc = new Scanner(System.in);
        Transaction transaction = null;
        System.out.println(
            "==== Type of transaction you want to do =====\n" +
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
            ManageAccount.InitMenu(account);
        }
    }

    public static void loadTransaction(){

        try {
            ArrayList<Object> transactions = transactionRepository.read();

            for (int c = 0; c < transactions.size(); c++) {
                Transaction t = (Transaction) transactions.get(c);

                if(t.getAccount().getAccNumber() == account.getAccNumber()) System.out.println(t.getAccount());
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}