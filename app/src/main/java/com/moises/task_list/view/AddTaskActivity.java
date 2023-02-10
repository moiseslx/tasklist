package com.moises.task_list.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.moises.task_list.R;
import com.moises.task_list.presenter.AddTask;

import java.util.Calendar;

public class AddTaskActivity extends AppCompatActivity implements ViewFunctions.AddTaskView {

    private AddTask addTask;

    private EditText title;
    private EditText description;
    private final Calendar calendar = Calendar.getInstance();

    private ImageView closeActivity;
    private Button selectDate, selectTime, save;

    private DatePicker datePicker;
    private TimePicker timePicker;

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);
        initComponents();

        addTask = new AddTask(this, this);

        //dialogs
        datePicker = new DatePicker(selectDate, this, calendar);
        timePicker = new TimePicker(selectTime, this);

        datePicker.initDate();
        timePicker.initTime();

        closeActivity.setOnClickListener(view -> {
            startActivity(new Intent(getApplicationContext(), ListActivity.class));
            finish();
        });

        selectDate.setOnClickListener(view -> {
            datePicker.showDialogDate();

            //set calendar
            calendar.set(Calendar.YEAR, datePicker.getCalendar().get(Calendar.YEAR));
            calendar.set(Calendar.MONTH, datePicker.getCalendar().get(Calendar.MONTH));
            calendar.set(Calendar.DAY_OF_MONTH, datePicker.getCalendar().get(Calendar.DAY_OF_MONTH));
            calendar.set(Calendar.HOUR, 9);
            calendar.set(Calendar.MINUTE, 30);
            calendar.set(Calendar.SECOND, 0);
            calendar.set(Calendar.MILLISECOND, 0);
        });

        selectTime.setOnClickListener(view -> {
            timePicker.showDialogTime();

            //set update time
            calendar.set(Calendar.HOUR, timePicker.getHour());
            calendar.set(Calendar.MINUTE, timePicker.getMin());
        });

        save.setOnClickListener(view -> {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(new View(getApplicationContext()).getWindowToken(), 0);
            progressBar.setVisibility(View.VISIBLE);
            save.setVisibility(View.INVISIBLE);
            new Handler().postDelayed(() -> {
                progressBar.setVisibility(View.INVISIBLE);
                addTask.create(title.getText().toString(), description.getText().toString(), calendar);
            }, 4000);
        });
    }

    @Override
    public void success() {
        Toast.makeText(getApplicationContext(), "tarefa salva com sucesso", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error() {
        Toast.makeText(getApplicationContext(), "erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void completeFields() {
        Toast.makeText(getApplicationContext(), "informe todos os campos", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void activityTransition() {
        startActivity(new Intent(this, ListActivity.class));
        finish();
    }

    //components instance
    private void initComponents() {
        this.title = findViewById(R.id.et_title);
        this.description = findViewById(R.id.et_description);
        this.closeActivity = findViewById(R.id.img_close);
        this.selectDate = findViewById(R.id.bt_calendar);
        this.selectTime = findViewById(R.id.bt_time);
        this.save = findViewById(R.id.bt_save);
        this.progressBar = findViewById(R.id.progress_bar);
    }
}