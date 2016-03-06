package ickarus.zordon;

import java.util.ArrayList;

/**
 * Created by Richard on 3/6/2016.
 */
public class courseItem {
    private String name;
    private double weight;
    private double gradePts=0;
    private double avg=0;
    private static ArrayList<Double> scores= new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void addItem(double score){
        scores.add(score);
        getAvg();
    }

    public void getAvg() {
        double sum=0;
        for(int i=0; i< scores.size();i++)
            sum+=scores.get(i);

        avg=(sum/scores.size());
        getGradePts();
    }

    public double getGradePts() {
        gradePts=avg*weight;
        return gradePts;
    }
}
