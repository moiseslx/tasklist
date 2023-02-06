package com.moises.task_list.dao;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.moises.task_list.model.Task;

import java.util.List;

//data access interface

@Dao
public interface TaskDAO{

    @Insert
    void insert(Task task);
    @Query("Select * from Task")
    List <Task> getAll();
    @Update
    void update(Task task);
    @Delete
    void delete(Task task);
}
