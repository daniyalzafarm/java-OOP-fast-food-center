package ClassesFrames;

import Exceptions.Exception_Date;
import Exceptions.Exception_Email;
import Exceptions.Exception_Salary;
import java.io.Serializable;

public class Class_Persons_Employee extends Class_Persons implements Serializable {

    private String email;
    private String Designation;
    private Double salary;
    private Class_Persons_Date date_hired;

    public Class_Persons_Employee(String id, String Designation, Double salary, Class_Persons_Date date_hired, String Name, String phone, String email, Class_Persons_Address add) throws Exception {
        super(id, Name, phone, add);

        this.Designation = Designation;

        if (salary > 0) {
            this.salary = salary;
        } else {
            throw new Exception_Salary();
        }
        if (email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            throw new Exception_Email();
        }
        this.date_hired = date_hired;
    }

    


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws Exception_Email {
        if (email.contains("@") && email.endsWith(".com")) {
            this.email = email;
        } else {
            throw new Exception_Email();
        }
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
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

    public String getDesignation() {
        return Designation;
    }

    public Double getSalary() {
        return salary;
    }

    public Class_Persons_Date getDate_hired() {
        return date_hired;
    }

}
