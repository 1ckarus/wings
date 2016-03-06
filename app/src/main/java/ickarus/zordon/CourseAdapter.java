package ickarus.zordon;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Richard on 3/6/2016.
 */
public class CourseAdapter extends ArrayAdapter <course>{
    List<course> courses=null;
    Context context;
    public CourseAdapter (Context context, List objects) {
        super(context, R.layout.courserow, objects);
        this.context = context;
        this.courses = objects;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.row, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.coursName);
        TextView score = (TextView) convertView.findViewById(R.id.courScore);
        name.setText(courses.get(position).getCourseName());
        String b= ""+courses.get(position).getGrade();
        score.setText(b);

        return convertView;
    }
}
