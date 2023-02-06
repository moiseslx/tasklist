package com.moises.task_list.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;

public class DatePicker {
    Calendar calendar;
    private final Button selectDate;
    private final Context context;
    private DatePickerDialog datePickerDialog;
    protected DatePickerDialog.OnDateSetListener dateSetListener;

    public DatePicker(Button selectDate, Context context, Calendar calendar) {
        this.selectDate = selectDate;
        this.context = context;
        this.calendar = calendar;
    }

    protected void initDate() {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        dateSetListener = (view, year1, month1, dayOfMonth) -> {
            month1 += month1;
            String date = formatDate(year1, formatMonth(month1), day);
            calendar.set(Calendar.YEAR, year1);
            calendar.set(Calendar.MONTH, month1);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            selectDate.setText(date);
        };

        datePickerDialog = new DatePickerDialog(context, AlertDialog.THEME_HOLO_LIGHT, dateSetListener, year, month, day);
        datePickerDialog.setTitle("Selecione o Dia:");
    }

    private String formatDate(int year, String month, int day) {
        return month + "  •  " + day + "  • " + year;
    }

    private String formatMonth(int month) {
        switch (month) {
            case 1:
                return "JAN";
            case 2:
                return "FEV";
            case 3:
                return "MAR";
            case 4:
                return "ABR";
            case 5:
                return "MAI";
            case 6:
                return "JUN";
            case 7:
                return "JUL";
            case 8:
                return "AGO";
            case 9:
                return "SET";
            case 10:
                return "OUT";
            case 11:
                return "NOV";
            default:
                return "DEZ";
        }
    }

    protected void showDialogDate() {
        datePickerDialog.show();
    }

    protected Calendar getCalendar() {
        return calendar;
    }
}
