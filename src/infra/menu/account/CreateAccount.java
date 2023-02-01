package infra.menu.account;

import entity.Account;

import usecases.Account.*;
import usecases.Agency.AgencyImpl;
import usecases.Address.AddressImpl;

import infra.db.AccountRepository;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class CreateAccount {
    private static AccountRepository accountRepository = new AccountRepository();
    private static Scanner sc = new Scanner(System.in);
    
    private static String password;
    private static double accNumber;
    private static double balance;
    
    public static void InitMenu(){
      System.out.println(
        "==== Type of account you want to crate ====\n" +
        "1. Checking account\n" +
        "2. Savings account\n" +
        "3. Salary account\n"
      );
      CreateAccount.ProcessCreateAccountMenu(sc.nextInt());
    }

    public static void ProcessCreateAccountMenu(int itemSelected){
        AddressImpl address = new AddressImpl(
            "city",
            "state",
            "country",
            "neighborhood",
            "streetName",
            "streetNumber"
        );
        AgencyImpl agency = new AgencyImpl(
            12345, 
            "Agencia teste",
            address
        );

        switch (itemSelected) {
            case 1:
                CreateAccount.GetDefaultAccountData();
                System.out.println("\nLimit Overdraft: ");
                double limitOverdraft = sc.nextDouble();
                System.out.println("\nAdmin Fee: ");
                double adminFee = sc.nextDouble();

                CreateAccount.SaveAccount(
                    new CheckingAccount(
                        password, 
                        true,
                        accNumber,
                        balance,
                        LocalDate.now(),
                        agency,
                        limitOverdraft,
                        adminFee
                    )
                );
            break;
            case 2:
                CreateAccount.GetDefaultAccountData();
                System.out.println("\nIncome Month: ");
                double incomeMonth = sc.nextDouble();

                CreateAccount.SaveAccount(
                    new SavingAccount(
                        password, 
                        true,
                        accNumber,
                        balance,
                        LocalDate.now(),
                        agency,
                        incomeMonth
                    )
                );
            break;
            case 3:
                CreateAccount.GetDefaultAccountData();
                System.out.println("\nLimit Withdraw: ");
                double limitWithdraw = sc.nextDouble();
                System.out.println("\nLimit Transfer: ");
                double limitTransfer = sc.nextDouble();

                CreateAccount.SaveAccount(
                    new SalaryAccount(
                        password, 
                        true,
                        accNumber,
                        balance,
                        LocalDate.now(),
                        agency,
                        limitWithdraw,
                        limitTransfer
                    )
                );
            break;
            default:
                System.out.println("Item not found\n");
                CreateAccount.InitMenu();
        } 
    }

    public static void GetDefaultAccountData() {
        System.out.println("==== Enter data of your account ====");

        System.out.println("Password: ");
        password = sc.next();
        System.out.println("\nAccNumber: ");
        accNumber = sc.nextDouble();
        System.out.println("\nBalance: ");
        balance = sc.nextDouble();
    }

    public static void SaveAccount(Account account) {
        try {
            ArrayList<Account> accounts = accountRepository.read();
            accounts.add(account);

            accountRepository.write(accounts);
            System.out.println("\n==== Account created successfully!! ====\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            CreateAccount.InitMenu();
        }
    }
}