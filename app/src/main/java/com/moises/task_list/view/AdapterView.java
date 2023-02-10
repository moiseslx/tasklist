package com.moises.task_list.view;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.moises.task_list.R;
import com.moises.task_list.model.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

//inner class
public class AdapterView extends RecyclerView.Adapter<AdapterView.ViewHolder> {
    private List<Task> taskList;
    public AdapterView() {
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter, parent, false);

        return new ViewHolder(listItem);
    }

    @SuppressLint({"SimpleDateFormat", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.title.setText(" "+task.getTitle()+" ");
        //format date
        Date date = task.getDateNotify().getTime();
        holder.date.setText(new SimpleDateFormat(" dd/MM/yyyy - HH:mm:ss ").format(date));

        holder.delete.setOnClickListener(view -> {
          //TO-DO delete and update Adapter
        });
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // view's attributes
        protected TextView title;
        protected TextView date;
        protected ImageButton delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.tv_title_adapter);
            date = itemView.findViewById(R.id.tv_date_adapter);
            delete = itemView.findViewById(R.id.bt_delete);
        }
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }
}
