package com.moises.task_list.view;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.Button;

import java.util.Calendar;

public class TimePicker {
    private int hour;
    private int min;
    private Button selectTime;
    private Context context;
    private TimePickerDialog timePickerDialog;

    public TimePicker(Button selectTime, Context context) {
        this.selectTime = selectTime;
        this.context = context;
    }

    protected void initTime(){
        TimePickerDialog.OnTimeSetListener timeSetListener = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(android.widget.TimePicker view, int hourOfDay, int minute) {
                selectTime.setText(formatDate(hourOfDay,minute));
                hour = hourOfDay;
                min = minute;
            }
        };

        timePickerDialog = new TimePickerDialog(context, timeSetListener,hour,min,true);
    }

    protected String formatDate(Integer hour, Integer minute){
        if(minute.toString().length() == 1){
            return "ás "+hour+":0"+minute;
        } else {
            return "ás "+hour+":"+minute;
        }
    }

    protected void showDialogTime(){
        timePickerDialog.show();
    }

    public int getHour() {
        return hour;
    }

    public int getMin() {
        return min;
    }
}
