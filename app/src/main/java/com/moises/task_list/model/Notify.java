package com.moises.task_list.model;

import java.util.Calendar;

public class Notify {
    private String title;
    private String description;
    private Calendar alert;

    public Notify(String title, String description, Calendar alert) {
        this.title = title;
        this.description = description;
        this.alert = alert;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Calendar getAlert() {
        return alert;
    }

    public void setAlert(Calendar alert) {
        this.alert = alert;
    }
}
