package src.task1.bookacounting;

import src.task1.Book;
import src.task1.Role;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import static src.task1.MessageConstant.*;

public class BookAccountingServiceImpl implements BookAccountingService {
    public void startMyBooksLibraryService() throws Exception {
        int choice;
        while (true) {
            System.out.println(GREETING);
            choice = helpSwitch(0, 2);
            switch (choice) {
                case 1:
                    register();
                    break;
                case 2:
                    logIn();
                    break;
                case 0:
                    System.out.println(GOODBYE);
                    return;
            }
        }
    }


    public int helpSwitch(int first, int second) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                scanner.nextLine();
            }
            choice = scanner.nextInt();
        } while (choice < first || choice > second);
        return choice;
    }


    public void startUserMenu() throws Exception {
        int choice;
        while (true) {
            System.out.println(USER_ACCESS_RIGHTS);
            choice = helpSwitch(0, 2);
            switch (choice) {
                case 1:
                    watchCatalog();
                    break;
                case 2:
                    bookSearch();
                    break;
                case 0:
                    return;
            }
        }
    }


    public void startAdminMenu() throws Exception {
        int choice;
        while (true) {
            System.out.println(ADMINISTRATOR_ACCESS_RIGHTS);
            choice = helpSwitch(0, 4);
            switch (choice) {
                case 1:
                    watchCatalog();
                    break;
                case 2:
                    bookSearch();
                    break;
                case 3:
                    bookAdd();
                    break;
                case 4:
                    bookRemove();
                    break;
                case 0:
                    return;
            }
        }
    }

    public void register() throws Exception {
        Role R1 = new Role();
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_NAME);
        String name = scan.next();
        scan.nextLine();
        System.out.println(ENTER_PASSWORD);
        String password = scan.nextLine();
        System.out.println(ENTER_EMAIL);
        String email = scan.nextLine();
        R1.registration(name, password, email);
        System.out.println(ACCOUNT_CREATED);
    }

    public void logIn() throws Exception {
        Role R1 = new Role();
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_NAME);
        String name = scan.next();
        scan.nextLine();
        System.out.println(ENTER_PASSWORD);
        String password = scan.nextLine();
        String isAdmin = R1.search(name, password);
        if (isAdmin.equals("true")) {
            startAdminMenu();
        }
        if (isAdmin.equals("false")) {
            startUserMenu();
        }
    }

    public void bookSearch() throws Exception {
        List<Book> books;
        books = getBooksFromFile();
        Scanner scan = new Scanner(System.in);
        System.out.println(ENTER_BOOK_TITLE);
        String bookTitle = scan.nextLine();
        boolean condition = false;
        for (Book book : books) {
            if (Objects.equals(book.getName(), bookTitle)) {
                System.out.println(BOOK_FOUND);
                System.out.println(book);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void bookRemove() throws Exception {
        Book R2 = new Book();
        List<Book> books;
        books = getBooksFromFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_BOOK_TITLE);
        String bookTitle = scanner.nextLine();
        boolean condition = false;
        for (Book book : books) {
            if (Objects.equals(book.getName(), bookTitle)) {
                condition = true;
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
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void bookAdd() throws Exception {
        Book R2 = new Book();
        List<Book> books;
        books = getBooksFromFile();
        Scanner scanner = new Scanner(System.in);
        System.out.println(ENTER_BOOK_TITLE);
        String bookTitle = scanner.next();
        scanner.nextLine();
        System.out.println(ENTER_AUTHOR);
        String author = scanner.nextLine();
        System.out.println(ENTER_BOOK_FORMAT);
        String format = scanner.nextLine();
        System.out.println(ENTER_YEAR_OF_CREATION);
        String year = scanner.nextLine();
        System.out.println(ENTER_GENRE);
        String genre = scanner.nextLine();
        System.out.println(ENTER_DESCRIPTION);
        String description = scanner.nextLine();
        System.out.println(ENTER_BOOK_LOCATION);
        String location = scanner.nextLine();
        Book objBooks = new Book(bookTitle, author, format, Integer.parseInt(year), genre, description, location);
        books.add(objBooks);
        R2.delFile();
        for (Book book : books) {
            R2.add(book.getName(), book.getAuthor(), book.getFormat(), Integer.toString(book.getYear()),
                    book.getGenre(), book.getDescription(), book.getLocation());
        }
    }

    private List<Book> getBooksFromFile() throws FileNotFoundException {
        List<Book> books = new ArrayList<>();
        FileReader fileReader = new FileReader("src\\task1\\resources\\Books.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            Book objBooks = new Book(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(),
                    Integer.parseInt(scanner.nextLine()), scanner.nextLine(), scanner.nextLine(), scanner.nextLine());
            books.add(objBooks);
        }
        return books;
    }

    public void watchCatalog() throws FileNotFoundException {
        List<Book> books;
        books = getBooksFromFile();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}