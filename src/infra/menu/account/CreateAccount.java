package infra.menu.account;

import entity.Account;

import entity.Address;
import usecases.Account.*;
import usecases.Agency.AgencyImpl;
import usecases.Address.AddressImpl;

import infra.db.Repository;

import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class CreateAccount {
    private static Repository accountRepository = new Repository("accounts.dat");
    private static Scanner sc = new Scanner(System.in);

    private static String password;
    private static double accNumber;
    private static double balance;

    public static void InitMenu(){
        System.out.println(
                "\n==== Type of account you want to crate ====\n" +
                        "1. Checking account\n" +
                        "2. Savings account\n" +
                        "3. Salary account"
        );
        System.out.print("Option: ");
        CreateAccount.ProcessCreateAccountMenu(sc.nextInt());
    }

    public static void ProcessCreateAccountMenu(int itemSelected){
        AddressImpl address = createAddress(); // cria e retorna um adress

        AgencyImpl agency = createAgency(address); // cria e retorna uma agency

        switch (itemSelected) {
            case 1:
                CreateAccount.GetDefaultAccountData();
                System.out.print("Limit Overdraft: ");
                double limitOverdraft = sc.nextDouble();
                System.out.print("Admin Fee: ");
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
                System.out.print("Income Month: ");
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
                System.out.print("Limit Withdraw: ");
                double limitWithdraw = sc.nextDouble();
                System.out.print("Limit Transfer: ");
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
        System.out.println("\n==== Enter data of your account ====");
        System.out.print("Password: ");
        password = sc.next();
        System.out.print("AccNumber: ");
        accNumber = sc.nextDouble();
        System.out.print("Balance: ");
        balance = sc.nextDouble();
    }

    public static void SaveAccount(Account account) {
        try {
            ArrayList<Object> accounts = accountRepository.read();
            accounts.add(account);

            accountRepository.write(accounts);
            System.out.println("\n==== Account created successfully!! ====\n");
        } catch (IOException e) {
            System.out.println(e.getMessage());
            CreateAccount.InitMenu();
        }
    }

    public static AddressImpl createAddress(){
        String city,state,country,neigh,streetName,streetNumber;

        System.out.println("\n==== Enter data of your address ====");
        sc.nextLine();
        System.out.print("Name of city: ");
        city = sc.nextLine();
        System.out.print("State: ");
        state = sc.nextLine();
        System.out.print("Country: ");
        country = sc.nextLine();
        System.out.print("Neighborhood: ");
        neigh = sc.nextLine();
        System.out.print("Street Name: ");
        streetName = sc.nextLine();
        System.out.print("Street Number: ");
        streetNumber = sc.nextLine();

        AddressImpl address = new AddressImpl(
                city,
                state,
                country,
                neigh,
                streetName,
                streetNumber
        );

        return address;
    }

    public static AgencyImpl createAgency(Address address){
        String nameAgency;
        int numberAgency;

        System.out.println("\n==== Enter data of your agency ====");
        System.out.print("Number of Agency: ");
        numberAgency = sc.nextInt();
        sc.nextLine();
        System.out.print("Name of Agency: ");
        nameAgency = sc.nextLine();

        AgencyImpl agency = new AgencyImpl(
                numberAgency,
                nameAgency,
                address
        );

        return agency;
    }
}