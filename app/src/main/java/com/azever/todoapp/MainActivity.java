package com.azever.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.azever.todoapp.adapters.TaskAdapter;
import com.azever.todoapp.models.Task;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listViewTask;
    TaskAdapter adapter;
    List<Task> taskList;

    EditText editTextName;
    EditText editTextDesc;
    EditText editTextTime;
    Button buttonSubmit;

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

        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextDesc = (EditText) findViewById(R.id.editTextDesc);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        buttonSubmit = (Button) findViewById(R.id.buttonSubmit);

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString();
                String desc = editTextDesc.getText().toString();
                String time = editTextTime.getText().toString();

                Task task = new Task();
                task.setName(name);
                task.setDescription(desc);
                task.setTime(time);
                task.setStatus(false);
                taskList.add(task);

                adapter.notifyDataSetChanged();
                
                editTextName.setText("");
                editTextDesc.setText("");
                editTextTime.setText("");

            }
        });


        listViewTask = (ListView) findViewById(R.id.listViewTask);
        adapter = new TaskAdapter(MainActivity.this,0,taskList);
        listViewTask.setAdapter(adapter);
    }
}
