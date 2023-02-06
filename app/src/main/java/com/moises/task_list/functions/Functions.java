package com.moises.task_list.functions;
import com.moises.task_list.model.Task;

import java.util.Calendar;
import java.util.List;

public interface Functions {

    //send notify
    @FunctionalInterface
    interface SendNotify{
        void sendNotify();
    }

    //returns the reading of dao
    @FunctionalInterface
    interface GetList{
        List <Task> listTask();
    }

    //create new task
    @FunctionalInterface
    interface createTask{
        void create(String title, String description, Calendar dateNotify);
    }
}
