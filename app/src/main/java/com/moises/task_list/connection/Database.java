package com.moises.task_list.connection;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.moises.task_list.dao.TaskDAO;
import com.moises.task_list.model.CalendarConverterType;
import com.moises.task_list.model.Task;

//created database
@androidx.room.Database(entities = {Task.class}, version = 1, exportSchema = false)
@TypeConverters({CalendarConverterType.class})
public abstract class Database extends RoomDatabase {
    public abstract TaskDAO taskDAO();
}
