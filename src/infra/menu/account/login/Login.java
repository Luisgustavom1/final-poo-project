package infra.menu.account.login;

import java.io.*;
import java.util.Scanner;

public class Login implements Hash {
    private double accountNumber;
    private String password;

    public Login(double accountNumber, String password) throws IOException {
        if(login(Double.toString(accountNumber),password)){
            this.accountNumber = accountNumber;
            this.password = password;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Account number/password!");
        }
    }

    public boolean login(String accountNumber, String password) throws IOException { //Verifica se o Login existe
        String logins;
        File file = new File("login.dat");
        BufferedReader br;
        br = new BufferedReader(new FileReader(file)); // faz a leitura do arquivo.

        while ((logins = br.readLine()) != null){
            String[] res = logins.split(":"); // faz o split
            if(res[0].equals(Long.toString(geraHash(accountNumber))) && res[1].equals(Long.toString(geraHash(password)))) // achou.
                return true;
        }
        return false;
    }

    public void addUser(double accountNumber,String password) throws IOException {
        File file = new File("login.dat");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true))); // faz a escrita

        pw.printf("%d:%d\n",geraHash(Double.toString(accountNumber)),geraHash((password)));
        pw.close();
    }

    public double getUsername() {
        return accountNumber;
    }

    public void setUsername(double accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public static Login printLogin() {
        Scanner sc = new Scanner(System.in);
        Login lg = null;
        String logins;
        double accNumber;

        System.out.print("===== LOGIN =====\n" +
                "Account: ");
        accNumber = sc.nextDouble();
        System.out.println("Password: ");
        logins = sc.nextLine();

        try {
            lg = new Login(accNumber, logins);
        } catch (IOException e) {
            System.out.println("Error:" + e);
        } finally {
            return lg;
        }
    }

    public static Login printAddUser() {
        Login lg = null;
        Scanner sc = new Scanner(System.in);
        String logins;
        double accNumber;
        System.out.print("===== LOGIN =====\n" +
                "Account: ");
        accNumber = sc.nextDouble();
        System.out.println("Password: ");
        logins = sc.nextLine();

        try {
            lg.addUser(accNumber,logins);
        } catch (IOException e) {
            System.out.println("Error:" + e);
        } finally {
            return lg;
        }
    }
}