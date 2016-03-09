package ickarus.zordon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Tasks extends AppCompatActivity {
    private int taskId=0;
    ListView lv;
    List <String> tasks;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        lv= (ListView) findViewById(R.id.listView1);
        tasks= new ArrayList<>();

        final EditText taskName= (EditText) findViewById(R.id.TaskName);
        Button taskButton= (Button) findViewById(R.id.TaskButton);
        final CustomAdapter adapter = new CustomAdapter(this, tasks);
        lv.setAdapter(adapter);

        taskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String getTask = taskName.getText().toString();
                if (!getTask.isEmpty()) {
                    tasks.add(getTask);
                    taskName.setText("");
                    adapter.notifyDataSetChanged();
                }
            }
        });



    }

}
