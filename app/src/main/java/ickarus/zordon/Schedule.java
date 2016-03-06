package ickarus.zordon;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Schedule extends AppCompatActivity {
    final Context context=this;
    ListView lv;
    List<course> courseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        lv= (ListView) findViewById(R.id.CourseView);
        courseList=new ArrayList<>();
        ImageButton button = (ImageButton) findViewById(R.id.addCourseButton);
        final CourseAdapter courseAdapter = new CourseAdapter(this, courseList);
        lv.setAdapter(courseAdapter);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("button  pressed","YES");
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        context);
                alertDialogBuilder.setTitle("Adding Course");
                alertDialogBuilder
                        .setMessage("Click Yes to Add Course")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, close
                                // current activity
                                Log.i("Course Added","YES");
                            }
                        })
                        .setNegativeButton("No",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                // if this button is clicked, just close
                                // the dialog box and do nothing
                                dialog.cancel();
                            }
                        });

                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();


            }
        });
    }
}
