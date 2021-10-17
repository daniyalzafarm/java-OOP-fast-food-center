package ClassesFrames;

import Exceptions.Exception_Salary;
import java.io.Serializable;

public class Class_Pay implements Serializable{
    private String id;
    private String name;
    private Double salary;
    private Class_Persons_Date date;

    public Class_Pay(String id, String name, Double salary, Class_Persons_Date date) throws Exception_Salary {
        this.id = id;
        this.name = name;
        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new Exception_Salary();
        }
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Class_Persons_Date getDate() {
        return date;
    }

    public void setDate(Class_Persons_Date date) {
        this.date = date;
    }
        public static void main(String[] args) throws Exception_Salary {


        Class_Pay p = new Class_Pay("id", "name", 8.0, new Class_Persons_Date(01, 02, 2019));
        Generic_Methods.writeObjectToFile(p, "Pay.ser");

    }
    
}
