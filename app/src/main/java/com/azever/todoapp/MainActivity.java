package com.azever.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.azever.todoapp.adapters.TaskAdapter;
import com.azever.todoapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewTask;
    TaskAdapter adapter;
    List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskList = new ArrayList<Task>();
        Task task = new Task();
        task.setName("Mua trái cây");
        task.setDescription("Mua ở USMart Trần Hưng Đạo");
        task.setStatus(false);
        task.setTime("19:00 13/12");
        taskList.add(task);

        listViewTask = (ListView) findViewById(R.id.listViewTask);
        adapter = new TaskAdapter(MainActivity.this,0,taskList);
        listViewTask.setAdapter(adapter);
    }
}
