package src.task2.notepadaccounting;

import src.task2.Notepad;

import java.util.List;

public interface NotepadAccountingService {
    void startNotepadservice() throws Exception;

    int helpSwitch(int first, int second);

    List<Notepad> getNotesFromFile() throws Exception;
}
