package src.task1;

import java.io.FileReader;
import java.util.Scanner;
import java.io.FileWriter;

import static src.task1.MessageConstant.*;

public class Role {
    private String Name;
    private String login;
    private String password;

    public Role() {
    }

    public String search(String name, String password) throws Exception {
        String skipLine = "";
        String isAdmin = "";
        String readName = "";
        String readPassword = "";
        boolean bol = false;
        FileReader fr = new FileReader("src\\task1\\resources\\Password.txt");
        Scanner scan2 = new Scanner(fr);
        while (!bol && scan2.hasNextLine()) {
            skipLine = scan2.nextLine();
            isAdmin = scan2.nextLine();
            readName = scan2.nextLine();
            readPassword = scan2.nextLine();
            scan2.nextLine();
            if (name.equals(readName) && password.hashCode() == Integer.parseInt(readPassword)) {
                bol = true;
                System.out.println(AUTHORIZATION);
            }
        }
        if (!bol) {
            System.out.println(PASSWORD_OR_LOGIN_ERROR);
        }
        scan2.close();
        return isAdmin;
    }

    public void registration(String name, String password, String email) throws Exception {
        FileWriter nFile = new FileWriter("src\\task1\\resources\\Password.txt", true);
        nFile.write(System.lineSeparator() + "false" + System.lineSeparator());
        nFile.write(name + System.lineSeparator());
        nFile.write(password.hashCode() + System.lineSeparator());
        nFile.write(email + System.lineSeparator());
        nFile.close();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
