package sg.edu.rp.c347.id19030019.lp1practical;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class TaskAdapter extends ArrayAdapter<Task> {

    private Context context;
    private TextView description, date, item;
    private Button btnshare;
    private ArrayList<Task> alTask;

    public TaskAdapter(Context context, int resource, ArrayList<Task> objects){
        super(context, resource, objects);

        alTask = objects;
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row_task, parent, false);

        Task currentTask = alTask.get(position);

        item = rowView.findViewById(R.id.tvItem);
        description = rowView.findViewById(R.id.tvDesc);
        date = rowView.findViewById(R.id.tvDate);
        btnshare = rowView.findViewById(R.id.btnShare);

        item.setText("Item: " + (position + 1));
        description.setText(currentTask.getDescription());
        date.setText(currentTask.getDate());

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = " Task Description: " + currentTask.getDescription() + "\n Task Date: " + currentTask.getDate();
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"andy_tao@rp.edu.sg"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "A task is shared with you from 19030019");
                intent.putExtra(Intent.EXTRA_TEXT, email);
                intent.setType("message/rfc822");
                context.startActivity(Intent.createChooser(intent, "Choose an Email client"));
            }
        });

        return rowView;
    }

}
