package ickarus.zordon;

import java.util.ArrayList;

/**
 * Created by Richard on 3/6/2016.
 */
public class course {
    private String courseName;
    private ArrayList<courseItem> list= new ArrayList<>();
    private double grade=0;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }


    public double getGrade()
    {
        double sum=0;
        double totalWeight=0;

        for(int i=0; i<list.size();i++)
        {
            sum+=list.get(i).getGradePts();
            totalWeight+=list.get(i).getWeight();
        }
        return sum/totalWeight;
    }

    public void addCourseItem(String name, double weight, ArrayList<Double> scores)
    {
        courseItem courseItem= new courseItem();
        courseItem.setName(name);
        courseItem.setWeight(weight);

        // here i think I want a loop that will usen an array to add the scored
        //courseItem.addItem(20);
        for(int i=0; i< scores.size();i++)
            courseItem.addItem(scores.get(i));
        list.add(courseItem);

    }


}
