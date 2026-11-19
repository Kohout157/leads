package cz.leads.model;

import java.time.LocalDate;

public class Reminder {

    private String text;
    private LocalDate date;

    public Reminder() {
    }

    public Reminder(String text, LocalDate date) {
        this.text = text;
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
