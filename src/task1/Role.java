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

    public String authorization(String name, String password) throws Exception {
        String s3 = "", sc1 = "", sc2 = "";
        boolean bol = false;
        FileReader fr = new FileReader("src\\task1\\resources\\Password.txt");
        Scanner scan2 = new Scanner(fr);
        while (bol == false && scan2.hasNextLine()) {
            s3 = scan2.nextLine();
            sc1 = scan2.nextLine();
            sc2 = scan2.nextLine();
            scan2.nextLine();
            if (name.equals(sc1) && password.hashCode() == Integer.parseInt(sc2)) {
                bol = true;
                System.out.println(AUTHORIZATION);
            }
        }
        if (bol == false) {
            System.out.println(PASSWORD_OR_LOGIN_ERROR);
            s3 = "0";
        }
        scan2.close();
        return s3;
    }

    public void registration(String name, String password, String email) throws Exception {
        FileWriter nFile = new FileWriter("src\\task1\\resources\\Password.txt", true);
        nFile.write(System.lineSeparator());
        nFile.write(System.lineSeparator() + "2645995" + System.lineSeparator());
        nFile.write(name + System.lineSeparator());
        nFile.write(password.hashCode() + System.lineSeparator());
        nFile.write(email);
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
