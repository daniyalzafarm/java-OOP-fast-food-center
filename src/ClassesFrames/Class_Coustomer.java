/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesFrames;

import Exceptions.Exception_Phone;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author DANIYAL ZAFAR
 */
public class Class_Coustomer implements Serializable{

    private String Name;
    private String phone;
    private Class_Persons_Date Date;
 //   private Double bill;
    private ArrayList<Class_Items> array;

    public Class_Coustomer(String Name, String phone, Class_Persons_Date dat,ArrayList<Class_Items> list) throws Exception_Phone {
        this.Name = Name;
        if (Class_Persons.checkPhone(phone)) {
            this.phone = phone;
        } else {
            throw new Exception_Phone();
        }
        this.Date=dat;
//        this.bill = Class_Coustomer.calculateBill();
        this.array=list;
    }

    public ArrayList<Class_Items> getList() {
        return array;
    }

    public void setList(ArrayList<Class_Items> list) {
        this.array = list;
        
    }

    public Class_Persons_Date getDate() {
        return Date;
    }

    public void setDate(Class_Persons_Date Date) {
        this.Date = Date;
    }

//    public static Double calculateBill() {
//        ArrayList<Class_Items> cart = Generic_Methods.readAllData("Cart.ser");
//        Double bill = null;
//        for (int i = 0; i < cart.size(); i++) {
//            bill = bill + cart.get(i).getPrice();
//        }
//        return bill;
//    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

//    public Double getBill() {
//        return bill;
//    }
//
//    public void setBill(Double bill) {
//        this.bill = bill;
//    }
    public double bill() {
        double total = 0;
        for (int i = 0; i < this.array.size(); i++) {
            total=total+array.get(i).getPrice();
//            if (array.get(i).getCategory().equalsIgnoreCase("Pizza")) {
//                Class_Items_Pizza pz = (Class_Items_Pizza) array.get(i);
//                total = total + (pz.calAmount(pz.getSize()) * array.get(i).getQuantity());
//            } else if (array.get(i).getCategory().equalsIgnoreCase("Burger/Shawarma")) {
//                Class_Items_burger_shawarma pz = (Class_Items_burger_shawarma) array.get(i);
//                total = total + (pz.calCOST() * array.get(i).getQuantity());
//            } else if (array.get(i).getCategory().equalsIgnoreCase("French Fries")) {
//                Class_Items_French_Fries pz = (Class_Items_French_Fries) array.get(i);
//                total = total + (pz.calCost(pz.getSize()) * array.get(i).getQuantity());
//            } else if (array.get(i).getCategory().equalsIgnoreCase("Other Items")) {
//                Class_Items_French_Fries pz = (Class_Items_French_Fries) array.get(i);
//                total = total + (array.get(i).getPrice() * array.get(i).getQuantity());
//            }
        }
        return total;
    }

}
