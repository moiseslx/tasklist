package com.moises.task_list.model;

import androidx.room.TypeConverter;

import java.util.Calendar;

public class CalendarConverterType {

    @TypeConverter
    public static Long toLong(Calendar calendar) {
        return calendar.getTimeInMillis();
    }

    @TypeConverter
    public static Calendar toCalendar(Long longTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(longTime);
        return calendar;
    }
}
