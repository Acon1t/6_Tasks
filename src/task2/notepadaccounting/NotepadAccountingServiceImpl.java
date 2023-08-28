package src.task2.notepadaccounting;

import src.task2.Notepad;
import src.task2.NotepadLogic;

import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.regex.Pattern;

import static src.task1.MessageConstant.GOODBYE;
import static src.task2.MessageConstant.*;

public class NotepadAccountingServiceImpl implements NotepadAccountingService {
    private List<Notepad> notepads = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    Notepad note = new Notepad();
    NotepadLogic notepadLogic = new NotepadLogic();

    private void runSearchMenu(List<Notepad> notepads) throws Exception {
        int choice;
        while (true) {
            System.out.println(SEARCH_OPTIONS);
            choice = helpSwitch(0, 6);
            switch (choice) {
                case 1:
                    notepadLogic.findNotesByTopic(notepads, topicConsole());
                    break;
                case 2:
                    notepadLogic.findNotesByCreationDate(notepads, dateOfCreationConsole());
                    break;
                case 3:
                    notepadLogic.findNotesByEmail(notepads, emailConsole());
                    break;
                case 4:
                    notepadLogic.findNotesByMessage(notepads, messageConsole());
                    break;
                case 5:
                    notepadLogic.findNotesByTopicAndEmail(notepads, topicConsole(), emailConsole());
                    break;
                case 6:
                    notepadLogic.findNoteByMessageAndCreationDate(notepads, messageConsole(), dateOfCreationConsole());
                    break;
                case 0:
                    return;
            }
        }
    }

    public void startNotepadservice() throws Exception {
        while (true) {
            notepads = getNotesFromFile();
            int choice;
            while (true) {
                System.out.println(OPTIONS_FOR_ACTION);
                choice = helpSwitch(0, 4);
                switch (choice) {
                    case 1:
                        notepadLogic.displayNotes(notepads);
                        break;
                    case 2:
                        notepadLogic.noteAdd(notepads, topicConsole(), dateOfCreationConsole(), emailConsole(), messageConsole());
                        break;
                    case 3:
                        notepadLogic.noteRemove(notepads, topicConsole());
                        break;
                    case 4:
                        runSearchMenu(notepads);
                        break;
                    case 0:
                        note.saveNotesToFile(notepads);
                        System.out.println(GOODBYE);
                        return;
                }
            }
        }
    }

    private LocalDate dateOfCreationConsole() {
        java.util.Locale locale = java.util.Locale.US;
        String pattern = "dd MM yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern, locale);
        String date;
        System.out.println(ENTER_DATE);
        while (true) {
            date = scanner.nextLine();
            LocalDate dateLocal = LocalDate.parse(date, formatter);
            return dateLocal;
        }
    }

    private String topicConsole() {
        System.out.println(ENTER_TOPIC);
        return scanner.nextLine();
    }

    private String messageConsole() {
        System.out.println(ENTER_MESSAGE);
        return scanner.nextLine();
    }

    private String emailConsole() {
        Pattern EMAIL_PATTERN = Pattern.compile("^(.+)@(\\S+)$");
        while (true) {
            System.out.println(ENTER_EMAIL);
            String email = scanner.nextLine();
            if (EMAIL_PATTERN.matcher(email).find()) {
                return email;
            }
            System.out.println(INVALID_INPUT);
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

    public List<Notepad> getNotesFromFile() throws Exception {
        FileReader fileReader = new FileReader("src\\task2\\resources\\notes.txt");
        Scanner scanner = new Scanner(fileReader);
        while (scanner.hasNextLine()) {
            Notepad objNotepad = new Notepad(scanner.nextLine(), LocalDate.parse(scanner.nextLine()), scanner.nextLine(),
                    scanner.nextLine());
            notepads.add(objNotepad);
        }
        return notepads;
    }
}