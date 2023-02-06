package com.moises.task_list.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.io.Serializable;
import java.util.Calendar;

@Entity
public class Task implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String title;
    @ColumnInfo
    private String description;
    @ColumnInfo
    @TypeConverters({CalendarConverterType.class})
    private Calendar dateNotify;
    @ColumnInfo
    private boolean isCompleted;

    public Task(String title, String description, Calendar dateNotify, boolean isCompleted) {
        this.title = title;
        this.description = description;
        this.dateNotify = dateNotify;
        this.isCompleted = isCompleted;
    }

    @Ignore
    public Task() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Calendar getDateNotify() {
        return dateNotify;
    }

    public void setDateNotify(Calendar dateNotify) {
        this.dateNotify = dateNotify;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}