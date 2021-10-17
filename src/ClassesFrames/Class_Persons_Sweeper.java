package ClassesFrames;

import Exceptions.Exception_Salary;

public class Class_Persons_Sweeper extends Class_Persons {

    private Class_Persons_Date date_hired;
    private Double salary;
    private String shift;
    

    public Class_Persons_Sweeper(String id, Class_Persons_Date date_hired,Double salary, String Name, String phone, Class_Persons_Address add,String shft) throws Exception {
        super(id, Name, phone, add);
        this.date_hired = date_hired;
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new Exception_Salary();
        }
        this.shift=shft;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shft) {
        this.shift = shft;
    }



    public void setSalary(Double salary) throws Exception_Salary {
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new Exception_Salary();
        }
    }

    public void setDate_hired(Class_Persons_Date date_hired) {
        this.date_hired = date_hired;
    }

    public Class_Persons_Date getDate_hired() {
        return date_hired;
    }

    public Double getSalary() {
        return salary;
    }


}
