package ClassesFrames;

import ClassesFrames.Class_Persons_Address;
import Exceptions.Exception_Salary;

public class Class_Persons_Cook extends Class_Persons {

    private int working_hours;
    private Double salary_per_hour;
    private Class_Persons_Date date_hired;
    private String shift;

    public Class_Persons_Cook(String id, int working_hours, Double salary_per_hour, Class_Persons_Date date_hired, String Name, String phone, Class_Persons_Address add, String shift) throws Exception {
        super(id, Name, phone, add);
        this.working_hours = working_hours;
        if (salary_per_hour > 0) {
            this.salary_per_hour = salary_per_hour;
        } else {
            throw new Exception_Salary();
        }
        this.date_hired = date_hired;
        this.shift = shift;
    }

    public void setWorking_hours(int working_hours) {
        this.working_hours = working_hours;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public void setSalary_per_hour(Double salary_per_hour) throws Exception_Salary {
        if (salary_per_hour > 0) {
            this.salary_per_hour = salary_per_hour;
        } else {
            throw new Exception_Salary();
        }
    }

    public void setDate_hired(Class_Persons_Date date_hired) {
        this.date_hired = date_hired;
    }

    public int getWorking_hours() {
        return working_hours;
    }

    public Double getSalary_per_hour() {
        return salary_per_hour;
    }

    public Class_Persons_Date getDate_hired() {
        return date_hired;
    }

}
