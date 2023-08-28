package src.task2;

import src.task2.notepadaccounting.NotepadAccountingService;
import src.task2.notepadaccounting.NotepadAccountingServiceImpl;

public class Main {
    public static void main(String[] args) throws Exception {
        NotepadAccountingService notepadAccountingService = new NotepadAccountingServiceImpl();
        notepadAccountingService.startNotepadservice();
    }
}
