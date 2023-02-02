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
    private static Repository accountRepository = new Repository("accounts.dat");
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
        ManageAccount.LoadTransaction();
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
        System.out.printf("Option: ");
        try {
            int optionSelected = sc.nextInt();

            System.out.printf("Enter with channel: ");
            String channel = sc.next();

            switch (optionSelected) {
                case 1:
                    transaction = new BalanceTransaction(
                            account,
                            channel
                    );
                    System.out.println("Your balance: R$" + transaction.execute(0.0));
                    break;
                case 2:
                    transaction = new DepositTransaction(
                            account,
                            channel
                    );
                    System.out.printf("Enter with value: ");
                    transaction.execute(sc.nextDouble());
                    System.out.println("Deposit of... R$" + transaction.getValue());
                    break;
                case 3:
                    transaction = new PaymentTransaction(
                            account,
                            channel
                    );
                    System.out.printf("Enter with value: ");
                    transaction.execute(sc.nextDouble());
                    System.out.println("Payment of... R$" + transaction.getValue());
                    break;
                case 4:
                    transaction = new WithdrawTransaction(
                            account,
                            channel
                    );
                    System.out.printf("Enter with value: ");
                    transaction.execute(sc.nextDouble());
                    System.out.println("Withdraw of... R$" + transaction.getValue());
                    break;
                default:
                    System.out.println("Item not found\n");
                    ManageAccount.CreateTransaction();
            }
            ManageAccount.SaveTransaction(transaction);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void SaveTransaction(Transaction transaction) {
        try {
            ArrayList<Object> transactions = transactionRepository.read();
            transactions.add(transaction);

            transactionRepository.write(transactions);
            ArrayList<Object> accounts = accountRepository.read();
            accounts.forEach(acc -> {
                Account accountInAnalysis = (Account) acc;
                
                if(accountInAnalysis.getAccNumber() == account.getAccNumber()) {
                    accountInAnalysis.setBalance(account.getBalance());
                }
            });
            accountRepository.write(accounts);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            ManageAccount.InitMenu(account);
        }
    }

    public static void LoadTransaction(){

        try {
            ArrayList<Object> transactions = transactionRepository.read();

            for (int c = 0; c < transactions.size(); c++) {
                Transaction t = (Transaction) transactions.get(c);

                if(t.getAccount().getAccNumber() == account.getAccNumber()) System.out.println(t.toString());
            }
            System.out.println("");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}