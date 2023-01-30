import java.util.*;
public class Competitor{
    private String name;
    private String school;
    int tries;
    ArrayList<Integer> points = new ArrayList<Integer>();
    double maxPoints;
    public double calcPoints(){
        double sum = 0;
        for(int i = 0; i < points.size(); i++){
            sum += points.get(i);
            //System.out.println("point " + (i + 1) + " " + points.get(i));
        }
        return sum;
    }
    public void printInfo(){
        maxPoints = calcPoints();
        System.out.println("Name: " + name + " School " + school + " points " + maxPoints);
        for(int i = 0; i < points.size(); i ++){
            System.out.println("point for try number " + (i + 1) + " " + points.get(i));
        }
        
    }
    public void setName(String n){
        this.name = n;
    }
    public String getName(){
        return name;
    }
    public void setSchool(String s){
        this.school = s;
    }
    public String getSchool(){
        return school;
    }
}