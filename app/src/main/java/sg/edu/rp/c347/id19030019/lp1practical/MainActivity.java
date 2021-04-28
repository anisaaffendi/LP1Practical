package sg.edu.rp.c347.id19030019.lp1practical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayList<Task> alTask;
    TaskAdapter taskAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lvInfo);

        alTask = new ArrayList<Task>();
        alTask.add(new Task("Group discussion", "1 May 2021"));
        alTask.add(new Task("Assignment Submission", "5 May 2021"));
        alTask.add(new Task("Online Course", "19 June 2021"));

        taskAdapter = new TaskAdapter(this, R.layout.row_task, alTask);
        lv.setAdapter(taskAdapter);
    }
}