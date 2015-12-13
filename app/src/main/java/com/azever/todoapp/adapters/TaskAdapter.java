package com.azever.todoapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.azever.todoapp.R;
import com.azever.todoapp.models.Task;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kimhieu on 12/13/15.
 */
public class TaskAdapter extends ArrayAdapter<Task> {

    List<Task> list;
    Context context;

    public TaskAdapter(Context context, int resource, List<Task> objects) {
        super(context, resource, objects);
        this.context = context;
        this.list = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.list_task_item,parent,false);

        TextView textViewName = (TextView) v.findViewById(R.id.textViewName);
        TextView textViewDescription = (TextView) v.findViewById(R.id.textViewDescription);
        TextView textViewTime = (TextView) v.findViewById(R.id.textViewTime);
        CheckBox checkBoxStatus = (CheckBox) v.findViewById(R.id.checkBoxStatus);

        // get task from position in list
        Task task = list.get(position);

        textViewName.setText(task.getName());
        textViewDescription.setText(task.getDescription());
        textViewTime.setText(task.getTime());
        checkBoxStatus.setChecked(task.isStatus());

        return v;
    }
}
