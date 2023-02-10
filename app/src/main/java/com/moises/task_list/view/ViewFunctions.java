package com.moises.task_list.view;

import com.moises.task_list.model.Task;

import java.util.List;

public interface ViewFunctions {

    interface AddTaskView {
        void success();
        void error();
        void completeFields();
        void activityTransition();
    }

    interface TaskView {
        //TO-DO
        void deleteTask();
        void loadTask(List<Task> dataList);
    }
}
