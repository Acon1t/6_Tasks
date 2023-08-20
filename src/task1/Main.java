package src.task1;

import src.task1.bookacounting.BookAccountingService;
import src.task1.bookacounting.BookAccountingServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        BookAccountingService bookAccountingService =new BookAccountingServiceImpl();
        bookAccountingService.startMyBooksLibraryService();
    }
}

