package infra.menu.account;

import java.io.*;
public class Login implements Hash {
    private String accountNumber;
    private String password;

    public Login(String accountNumber, String password) throws IOException {
        if(login(accountNumber,password)){
            this.accountNumber = accountNumber;
            this.password = password;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Account number/password!");
        }

    }

    private boolean login(String accountNumber, String password) throws IOException { //Verifica se o Login existe
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

    //private boolean loginVerify()
    public void addUser(String accountNumber,String password) throws IOException {
        File file = new File("login.dat");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true))); // faz a escrita

        pw.printf("%d:%d\n",geraHash(accountNumber),geraHash((password)));
        pw.close();
    }

    public String getUsername() {
        return accountNumber;
    }

    public void setUsername(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

