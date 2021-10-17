package ClassesFrames;

import Exceptions.Exception_Phone;

import java.io.Serializable;

public class Class_Persons implements Serializable {

    public static Double Earning;
    private String id;
    private String Name;
    private String phone;
    private Class_Persons_Address add;

    public Class_Persons(String id, String Name, String phone, Class_Persons_Address add) throws Exception {
        this.id = id;
        this.Name = Name;
        if ((phone.startsWith("923") && phone.length() == 12) || (phone.startsWith("+923") && phone.length() == 13)
                || (phone.startsWith("03") && phone.length() == 11)) {
            this.phone = phone;
        } else {
            throw new Exception_Phone();
        }

        this.add = add;
    }

    public void setPhone(String phone) throws Exception_Phone {
        if (checkPhone(phone)) {
            this.phone = phone;
        } else {
            throw new Exception_Phone();
        }
    }

    public static boolean checkPhone(String phone) {
        if ((phone.startsWith("923") && phone.length() == 12) || (phone.startsWith("+923") && phone.length() == 13)
                || (phone.startsWith("03") && phone.length() == 11)) {
            return true;
        } else {
            return false;
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String f) {
        Name = f;
    }

    public void setAdd(Class_Persons_Address a) {
        add = a;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return Name;
    }

    public Class_Persons_Address getAdd() {
        return add;
    }

    public String getPhone() {
        return phone;
    }

    public static Double getEarning() {
        return Earning;
    }

    public static void setEarning(Double Earning) {
        Class_Persons.Earning = Earning;
    }

}
