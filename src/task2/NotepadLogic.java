package src.task2;

import java.util.*;
import java.time.LocalDate;

import static src.task2.MessageConstant.*;


public class NotepadLogic {
    private void sortNotes(List<src.task2.Notepad> sortingList) {
        sortingList.sort(Comparator.comparing(src.task2.Notepad::getTopic));
    }

    public void displayNotes(List<Notepad> notepads) throws Exception {
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            System.out.println(notepad);
        }
    }

    public void findNotesByTopic(List<Notepad> notepads, String topic) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getTopic(), topic)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void findNotesByCreationDate(List<Notepad> notepads, LocalDate creationDate) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getCreationDate(), creationDate)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void findNotesByEmail(List<Notepad> notepads, String email) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getEmail(), email)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void findNotesByMessage(List<Notepad> notepads, String message) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getMessage(), message)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void findNotesByTopicAndEmail(List<Notepad> notepads, String topic, String email) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getEmail(), email) && Objects.equals(notepad.getTopic(), topic)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void findNoteByMessageAndCreationDate(List<Notepad> notepads, String message, LocalDate creationDate) throws Exception {
        boolean condition = false;
        sortNotes(notepads);
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getCreationDate(), creationDate) && Objects.equals(notepad.getMessage(), message)) {
                System.out.println(NOTE_FOUND);
                System.out.println(notepad);
                condition = true;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }

    public void noteAdd(List<Notepad> notepads, String topic, LocalDate creationDate, String email, String message) {
        Notepad objNotepad = new Notepad(topic, creationDate, email, message);
        notepads.add(objNotepad);
        System.out.println(NOTE_ADD);
    }

    public void noteRemove(List<Notepad> notepads, String topic) throws Exception {
        boolean condition = false;
        for (Notepad notepad : notepads) {
            if (Objects.equals(notepad.getTopic(), topic)) {
                condition = true;
                notepads.remove(notepad);
                System.out.println(NOTE_REMOVED);
                break;
            }
        }
        if (!condition) {
            System.out.println(NO_RESULTS_FOR_YOUR_SEARCH);
        }
    }
}
