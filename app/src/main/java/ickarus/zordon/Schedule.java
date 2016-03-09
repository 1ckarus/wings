package ickarus.zordon;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.LinearLayout;
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

                               final  course course= new course();
                                Log.i("Course created", "YES");
                                // ask for coursname
                                AlertDialog.Builder alert = new AlertDialog.Builder(context);

                                alert.setTitle("Course Name");
                                alert.setMessage("Add Course Name");

                                // Set an EditText view to get user input
                                final EditText input = new EditText(context);
                                alert.setView(input);

                                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        String value = input.getText().toString();
                                        course.setCourseName(value);
                                        Log.i("Course name added", "YES");
                                        // Do something with value!
                                    }
                                });


                                alert.show();



                                addCourseItem(course, context, courseAdapter);

                                courseList.add(course);

                                courseAdapter.notifyDataSetChanged();
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
    public static void addCourseItem(final course course, final Context context, final CourseAdapter courseAdapter)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle("Item Name");
        alert.setMessage("Add Course Item and Weight");

        LinearLayout layout= new LinearLayout(context);
        layout.setOrientation(LinearLayout.VERTICAL);

        // Set an EditText view to get user input
        final EditText itemName = new EditText(context);
        itemName.setHint("Quizzes, Exam, etc");
        layout.addView(itemName);

        final EditText itemScore= new EditText(context);
        itemScore.setHint("20 for 20%");
        layout.addView(itemScore);
        alert.setView(layout);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String value = itemName.getText().toString();
                double weight= Double.parseDouble(itemScore.getText().toString());
                course.addCourseItem(value, weight);

                addItemScore(course, value, context);
                Log.i("Course name added", "YES");
                courseAdapter.notifyDataSetChanged();// Do something with value!
            }
        });


        alert.show();

    }

    public static void addItemScore(final course course,final String name, Context context)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);

        alert.setTitle("Item Score");
        alert.setMessage("Add Your Score");

        // Set an EditText view to get user input
        final EditText itemSC = new EditText(context);
        itemSC.setHint("enter score here");

        alert.setView(itemSC);


        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                double score= Double.parseDouble(itemSC.getText().toString());
                course.addScore(name, score);

                Log.i("Course name added", "YES");

            }
        });


        alert.show();
    }
}
