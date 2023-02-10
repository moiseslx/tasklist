package com.moises.task_list.presenter;

import android.content.Context;
import android.util.Log;

import androidx.room.Room;

import com.moises.task_list.connection.Database;
import com.moises.task_list.functions.Functions;
import com.moises.task_list.model.Task;
import com.moises.task_list.view.ViewFunctions;

import java.util.List;

public class ListTask implements Functions.GetList {
    private final ViewFunctions.TaskView taskView;
    private final Database database;

    public ListTask(Context context, ViewFunctions.TaskView taskView) {
        this.taskView = taskView;
        database = Room.databaseBuilder(context, Database.class, "to-do").allowMainThreadQueries().build();
    }
    //.allowMainThreadQueries().build() Thread for queries
    public void load() {
        taskView.loadTask(listTask());
    }

    @Override
    public List<Task> listTask() {
        //task list database
        try {
            return database.taskDAO().getAll();
        } catch (Exception e) {
            Log.i("Access All", e.toString());
            return null;
        }
    }
}
