package src.task1.bookacounting;

import java.io.FileNotFoundException;


public interface BookAccountingService {
    void startMyBooksLibraryService() throws Exception;

    void startUserMenu() throws Exception;

    void startAdminMenu() throws Exception;

    void register() throws Exception;

    void logIn() throws Exception;

    void bookSearch() throws Exception;

    void bookRemove() throws Exception;

    void bookAdd() throws Exception;

    void watchCatalog() throws FileNotFoundException;

    int helpSwitch(int first, int second);
}
