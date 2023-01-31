package infra.menu.account;

import java.io.*;
public class Login implements Hash {
    private String username;
    private String password;

    public Login(String username, String password) throws IOException {
        if(login(username,password)){
            this.username = username;
            this.password = password;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username/password!");
        }

    }

    private boolean login(String username, String password) throws IOException { //Verifica se o Login existe
        String logins;
        File file = new File("database/login.txt");
        BufferedReader br;
        br = new BufferedReader(new FileReader(file)); // faz a leitura do arquivo.

        while ((logins = br.readLine()) != null){
            String[] res = logins.split(":"); // faz o split
            if(res[0].equals(Long.toString(geraHash(username))) && res[1].equals(Long.toString(geraHash(password)))) // achou.
                return true;
        }
        return false;
    }

    //private boolean loginVerify()
    public void addUser(String username,String password) throws IOException {
        File file = new File("database/login.txt");
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true))); // faz a escrita

        pw.printf("%d:%d\n",geraHash(username),geraHash((password)));
        pw.close();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

