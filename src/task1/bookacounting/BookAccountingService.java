package src.task1.bookacounting;

import java.io.FileNotFoundException;


public interface BookAccountingService {
    void startMyBooksLibraryService() throws Exception;
    void userMenu() throws Exception;
    void adminMenu() throws Exception;
    void registration() throws Exception;
    void authorization() throws Exception;
    void bookSearch() throws Exception;
    void bookRemoved() throws Exception;
    void bookAdd() throws Exception;
    void watchCatalog() throws FileNotFoundException;

}
