package ClassesFrames;

import java.io.Serializable;

public class Class_Persons_Address implements Serializable{
    private String home;
    private String town;
    public Class_Persons_Address(){
    home="null";
    town="null";
    }
    public Class_Persons_Address(String h,String t){
    home=h;
    town=t;
    }
    public void setHome(String h){
    home=h;
    }
    public void setTown(String t){
    town=t;
    }
    public String getHome(){
    return home;
    }
    public String getTown(){
    return town;
    }

}