package src.task1.bookacounting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import src.task1.Role;
import src.task1.Book;

import static src.task1.MessageConstant.*;

public class BookAccountingServiceImpl implements BookAccountingService {
    public static void booksAccount() throws Exception {
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true) {
            do {
                System.out.println(GREETING);
                while (!scan.hasNextInt()) {
                    scan.nextLine();
                }
                choice = scan.nextInt();

            } while (choice < 0 || choice > 3);
            switch (choice) {
                case 1:
                    BookAccountingServiceImpl.registration();
                    break;
                case 2:
                    BookAccountingServiceImpl.authorization();
                    break;
                case 0:
                    System.out.println(GOODBYE);
                    return;
            }
        }
    }

    public static void userMenu() throws Exception {
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true) {
            do {
                System.out.println(USER_ACCESS_RIGHTS);
                while (!scan.hasNextInt()) {
                    scan.nextLine();
                }
                choice = scan.nextInt();
            } while (choice < 0 || choice > 2);
            switch (choice) {
                case 1:
                    BookAccountingServiceImpl.watchCatalog();
                    break;
                case 2:
                    BookAccountingServiceImpl.bookSearch();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void adminMenu() throws Exception {
        Scanner scan = new Scanner(System.in);
        int choice;
        while (true) {
            do {
                System.out.println(ADMINISTRATOR_ACCESS_RIGHTS);
                while (!scan.hasNextInt()) {
                    scan.nextLine();
                }
                choice = scan.nextInt();
            } while (choice < 0 || choice > 4);
            switch (choice) {
                case 1:
                    BookAccountingServiceImpl.watchCatalog();
                    break;
                case 2:
                    BookAccountingServiceImpl.bookSearch();
                    break;
                case 3:
                    BookAccountingServiceImpl.bookAdd();
                    break;
                case 4:
                    BookAccountingServiceImpl.bookRemoved();
                    break;
                case 0:
                    return;
            }
        }
    }

    public static void registration() throws Exception {
        Role R1 = new Role();
        Scanner scan = new Scanner(System.in);
        String password = "";
        String email = "";
        String name = "";
        System.out.println(ENTER_NAME);
        name = scan.next();
        scan.nextLine();
        System.out.println(ENTER_PASSWORD);
        password = scan.nextLine();
        System.out.println(ENTER_EMAIL);
        email = scan.nextLine();
        R1.registration(name, password, email);
        System.out.println(ACCOUNT_CREATED);
    }

    public static void authorization() throws Exception {
        String name = "";
        String password = "";
        String pas = "";
        Role R1 = new Role();
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_NAME);
        name = scan.next();
        scan.nextLine();
        System.out.println(ENTER_PASSWORD);
        password = scan.nextLine();
        pas = R1.search(name, password);
        if (pas.equals("true")) {
            BookAccountingServiceImpl.adminMenu();
        }
        if (pas.equals("false")) {
            BookAccountingServiceImpl.userMenu();
        }
    }

    public static void bookSearch() throws Exception {
        List<Book> books;
        books = BookAccountingServiceImpl.variables();
        String bookTitle = "";
        boolean bol = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_BOOK_TITLE);
        bookTitle = scan.nextLine();
        for (Book book : books) {
            if (Objects.equals(book.search(bookTitle), "1")) {
                System.out.println(BOOK_FOUND);
                System.out.println(book);
                bol = true;
            }
        }
        if (!bol) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public static void bookRemoved() throws Exception {
        Book R2 = new Book();
        List<Book> books;
        books = BookAccountingServiceImpl.variables();
        String bookTitle = "";
        boolean bol = false;
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_BOOK_TITLE);
        bookTitle = scan.nextLine();
        for (Book book : books) {
            if (Objects.equals(book.search(bookTitle), "1")) {
                bol = true;
                books.remove(book);
                System.out.println(BOOK_REMOVED);
                R2.delFile();
                for (Book book2 : books) {
                    R2.add(book2.getName(), book2.getAuthor(), book2.getFormat(), Integer.toString(book2.getYear()),
                            book2.getGenre(), book2.getDescription(), book2.getLocation());
                }
                break;
            }
        }
        if (!bol) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public static void bookAdd() throws Exception {
        Book R2 = new Book();
        List<Book> books;
        books = BookAccountingServiceImpl.variables();
        String bookTitle = "";
        String author = "";
        String format = "";
        String year = "";
        String genre = "";
        String description = "";
        String location = "";
        Scanner scan = new Scanner(System.in);
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
        for (Book book : books) {
            R2.add(book.getName(), book.getAuthor(), book.getFormat(), Integer.toString(book.getYear()),
                    book.getGenre(), book.getDescription(), book.getLocation());
        }
    }

    public static List<Book> variables() throws FileNotFoundException {
        List<Book> books = new ArrayList<>();
        FileReader fileReader = new FileReader("src\\task1\\resources\\Books.txt");
        Scanner scan3 = new Scanner(fileReader);
        while (scan3.hasNextLine()) {
            Book objBooks = new Book(scan3.nextLine(), scan3.nextLine(), scan3.nextLine(),
                    Integer.parseInt(scan3.nextLine()), scan3.nextLine(), scan3.nextLine(), scan3.nextLine());
            books.add(objBooks);
        }
        return books;
    }

    public static void watchCatalog() throws FileNotFoundException {
        List<Book> books;
        books = BookAccountingServiceImpl.variables();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}