package com.moises.task_list.presenter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.moises.task_list.functions.Functions;
import com.moises.task_list.connection.Database;
import com.moises.task_list.model.Task;
import com.moises.task_list.view.AddTaskView;

import java.util.Calendar;

//create new Task, Add class in AddTaskActivity [PRESENTER]
public class AddTask implements Functions.createTask, Functions.SendNotify {
    private final Task task; //model
    private final AddTaskView addTaskView; //view - interface
    private final Database database;
    private final Context context;

    public AddTask(Context context, AddTaskView addTaskView) {
        this.task = new Task();
        this.addTaskView = addTaskView;
        this.context =context;
        database = Room.databaseBuilder(context, Database.class, "to-do").build();
    }

    @Override
    public void create(String title, String description, Calendar dateNotify) {
        task.setTitle(title);
        task.setDescription(description);
        task.setDateNotify(dateNotify);

        try {
            if (title.isEmpty() || description.isEmpty() || dateNotify == null || dateNotify.getTimeInMillis()==Calendar.getInstance().getTimeInMillis()) {
                addTaskView.completeFields();
            } else {
                new Thread(() -> {
                    database.taskDAO().insert(task);
                    ((Activity)context).runOnUiThread(() -> {
                        addTaskView.success();
                        addTaskView.activityTransition();
                    });
                    Log.i("ROOM SAVE: ", database.taskDAO().getAll().get(task.getId()).getTitle());
                }).start();
            }
        } catch (Exception e) {
            addTaskView.error();
        }
    }

    @Override
    public void sendNotify() {

    }
}

