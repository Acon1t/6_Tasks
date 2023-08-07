package src.task1.bookacounting;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.task1.Role;
import src.task1.Book;

import static src.task1.MessageConstant.*;

public class BookAccountingServiceImpl implements BookAccountingService {
    public static void booksAccount() throws Exception {
        List<Book> books = new ArrayList<>();
        FileReader fr = new FileReader("src\\task1\\resources\\Books.txt");
        Scanner scan3 = new Scanner(fr);
        while (scan3.hasNextLine()) {
            Book objBooks = new Book(scan3.nextLine(), scan3.nextLine(), scan3.nextLine(),
                    Integer.parseInt(scan3.nextLine()), scan3.nextLine(), scan3.nextLine(), scan3.nextLine());
            books.add(objBooks);
        }
        scan3.close();
        fr.close();
        Role R1 = new Role();
        Book R2 = new Book();
        Scanner scan = new Scanner(System.in);
        String password = "";
        String email = "";
        String name = "";
        String bookTitle = "";
        String author = "";
        String format = "";
        String year = "";
        String genre = "";
        String description = "";
        String location = "";
        String s = "";
        String pas = "";
        String ss = "";
        boolean bol = false;
        int x = 0;
        while (!"0".equals(s)) {
            System.out.println(GREETING);
            ss = "9";
            s = scan.next();
            try {
                x = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT);
            }
            switch (x) {
                case 1:
                    System.out.println(ENTER_NAME);
                    name = scan.next();
                    scan.nextLine();
                    System.out.println(ENTER_PASSWORD);
                    password = scan.nextLine();
                    System.out.println(ENTER_EMAIL);
                    email = scan.nextLine();
                    R1.registration(name, password, email);
                    System.out.println(ACCOUNT_CREATED);
                    break;
                case 2:
                    System.out.println(ENTER_NAME);
                    name = scan.next();
                    scan.nextLine();
                    System.out.println(ENTER_PASSWORD);
                    password = scan.nextLine();
                    pas = R1.authorization(name, password);
                    if (Integer.parseInt(pas) == 146731693) {
                        while (!"0".equals(ss)) {
                            System.out.println(ADMINISTRATOR_ACCESS_RIGHTS);
                            ss = scan.next();
                            try {
                                x = Integer.parseInt(ss);
                            } catch (NumberFormatException e) {
                                System.out.println(INVALID_INPUT);
                            }
                            switch (x) {
                                case 1:
                                    for (Book u : books) {
                                        System.out.println(u);
                                    }
                                    break;
                                case 2:
                                    System.out.println(ENTER_BOOK_TITLE);
                                    scan.nextLine();
                                    bookTitle = scan.nextLine();
                                    for (Book u : books) {
                                        if (u.search(bookTitle) == "1") {
                                            System.out.println(BOOK_FOUND);
                                            System.out.println(u);
                                            bol = true;
                                        }
                                    }
                                    if (bol == false) {
                                        System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
                                    }
                                    break;
                                case 3:
                                    System.out.println(ENTER_BOOK_TITLE);
                                    bookTitle = scan.next();
                                    scan.nextLine();
                                    System.out.println(ENTER_AUTHOR);
                                    author = scan.nextLine();
                                    System.out.println(ENTER_BOOK_FORMAT);
                                    format = scan.nextLine();
                                    System.out.println(ENTER_YEAR_OF_CREATION);
                                    year = scan.nextLine();
                                    System.out.println(ENTER_GENRE);
                                    genre = scan.nextLine();
                                    System.out.println(ENTER_DESCRIPTION);
                                    description = scan.nextLine();
                                    System.out.println(ENTER_BOOK_LOCATION);
                                    location = scan.nextLine();
                                    Book objBooks = new Book(bookTitle, author, format, Integer.parseInt(year), genre, description, location);
                                    books.add(objBooks);
                                    R2.delFile();
                                    for (Book u2 : books) {
                                        R2.add(u2.getName(), u2.getAuthor(), u2.getFormat(), Integer.toString(u2.getYear()),
                                                u2.getGenre(), u2.getDescription(), u2.getLocation());
                                    }
                                    break;
                                case 4:
                                    System.out.println(ENTER_BOOK_TITLE);
                                    bol = false;
                                    scan.nextLine();
                                    bookTitle = scan.nextLine();
                                    for (Book u : books) {
                                        if (u.search(bookTitle) == "1") {
                                            bol = true;
                                            books.remove(u);
                                            System.out.println(BOOK_REMOVED);
                                            R2.delFile();
                                            for (Book u2 : books) {
                                                R2.add(u2.getName(), u2.getAuthor(), u2.getFormat(), Integer.toString(u2.getYear()),
                                                        u2.getGenre(), u2.getDescription(), u2.getLocation());
                                            }
                                            break;
                                        }
                                    }
                                    if (bol == false) {
                                        System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
                                    }
                                    break;
                            }
                        }
                    }
                    if (Integer.parseInt(pas) == 2645995) {
                        while (!"0".equals(ss)) {
                            System.out.println(USER_ACCESS_RIGHTS);
                            ss = scan.next();
                            try {
                                x = Integer.parseInt(ss);
                            } catch (NumberFormatException e) {
                                System.out.println(INVALID_INPUT);
                            }
                            switch (x) {
                                case 1:
                                    for (Book u : books) {
                                        System.out.println(u);
                                    }
                                    break;
                                case 2:
                                    System.out.println(ENTER_BOOK_TITLE);
                                    scan.nextLine();
                                    bookTitle = scan.nextLine();
                                    for (Book u : books) {
                                        if (u.search(bookTitle) == "1") {
                                            System.out.println(BOOK_FOUND);
                                            System.out.println(u);
                                            bol = true;
                                        }
                                    }
                                    if (bol == false) {
                                        System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
                                    }
                                    break;
                            }
                        }
                    }
                    break;
            }
        }
        System.out.println(GOODBYE);
        scan.close();
    }
}