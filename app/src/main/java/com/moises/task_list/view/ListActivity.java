package com.moises.task_list.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.moises.task_list.R;
import com.moises.task_list.model.Task;
import com.moises.task_list.presenter.ListTask;

import java.util.List;

public class ListActivity extends AppCompatActivity implements ViewFunctions.TaskView{

    //create recycler view (recycler view component)
    private RecyclerView recyclerView;
    private AdapterView adapterView;

    //simple components
    private TextView isEmpty;
    private FloatingActionButton add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        //layout manager -> adapter -> dataset
        //set layout manager (recyclerView) and create layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //set adapter (class)
        adapterView = new AdapterView();
        recyclerView.setAdapter(adapterView);
        //presenter
        ListTask listTask = new ListTask(this, this);
        listTask.load();


        if (adapterView.getTaskList().size() == 0){
            isEmpty.setVisibility(View.VISIBLE);
        } else {
            isEmpty.setVisibility(View.INVISIBLE);
        }

        add.setOnClickListener(view -> startActivity(new Intent(this,AddTaskActivity.class)));
    }

    @Override
    public void deleteTask() {

    }

    @Override
    public void loadTask(List<Task> taskList) {
        adapterView.setTaskList(taskList);
    }

    private void initComponents(){
        recyclerView = findViewById(R.id.recycler_view);
        isEmpty = findViewById(R.id.tv_empty_list);
        add = findViewById(R.id.bt_add);
    }
}