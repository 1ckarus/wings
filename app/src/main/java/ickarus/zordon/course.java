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
    public void addScore(String name, double score)
    {
        for (int i=0;i< list.size();i++)
        {
            if(list.get(i).getName().equals(name))
            {
                list.get(i).addItem(score);
            }
        }
    }

    public void addCourseItem(String name, double weight)
        {
        courseItem courseItem= new courseItem();
        courseItem.setName(name);
        courseItem.setWeight(weight);

        // here i think I want a loop that will usen an array to add the scored
        //courseItem.addItem(20);

        list.add(courseItem);

    }


}
