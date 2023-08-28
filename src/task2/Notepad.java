package src.task2;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;

public class Notepad {
    private String topic;
    private LocalDate creationDate;
    private String email;
    private String message;

    public Notepad() {
    }

    public Notepad(String topic, LocalDate creationDate, String email, String message) {
        this.topic = topic;
        this.creationDate = creationDate;
        this.email = email;
        this.message = message;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "{" +
                " Тема : " + this.topic + "\r\n" +
                " Email : " + this.email + "\r\n" +
                " Сообщение : " + this.message + "\r\n" +
                " Дата : " + this.creationDate + "\r\n" +
                '}';
    }

    public void saveNotesToFile(List<Notepad> notepads)
            throws Exception {
        FileWriter nFile = new FileWriter("src\\task2\\resources\\notes.txt", false);
        for (Notepad notepad : notepads) {
            nFile.write(notepad.topic + System.lineSeparator());
            nFile.write(notepad.creationDate + System.lineSeparator());
            nFile.write(notepad.email + System.lineSeparator());
            nFile.write(notepad.message + System.lineSeparator());
        }
        nFile.close();
    }
}