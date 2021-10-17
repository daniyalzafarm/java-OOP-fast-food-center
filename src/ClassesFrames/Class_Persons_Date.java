package ClassesFrames;

import java.io.Serializable;

public class Class_Persons_Date implements Serializable{

    private int month;
    private int year;
    private int day;


    Class_Persons_Date(int day, int month, int year) {
        this.month = month;
        this.year = year;
        this.day = day;
    }
//    public String checkDate(String date) {
//        int c = 0;
//        int c1 = 0;
//        if (date.contains("-")) {
//            String[] d = date.split("");
//            for (int i = 0; i < d.length; i++) {
//                if (d[i].equals("-")) {
//                    c1++;
//                }
//            }
//            if (c1 == 2) {
//                c++;
//                String[] d1 = date.split("-");
//                if (d1.length == 3) {
//                    if (d[0].length() == 2 && d[1].length() == 2 && d[3].length() == 4) {
//                        c++;
//                    }
//                }
//            }
//        }
//        if(c==2){
//        return "Valid";
//        }else{
//        return "Invalid Date!";
//        }
//    }

    public void setDay(int d) {
        day = d;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setYear(int y) {
        year = y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
//    public void Display(){
//        System.out.print("Birth Date: "+this.getDay()+"/"+this.getMonth()+"/"+this.getYear());
//    }
}
