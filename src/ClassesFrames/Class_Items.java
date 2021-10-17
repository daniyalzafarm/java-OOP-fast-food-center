package ClassesFrames;

import Exceptions.Exception_Price;
import Exceptions.Exception_Quantity;
import java.io.Serializable;
import java.util.ArrayList;

public class Class_Items implements Serializable {

    private String id;
    private String name;
    private double price;
    private String Category;
    private int quantity;

    public Class_Items(String id, String name, double price, String Category) throws Exception_Price {
        this.id = id;
        this.name = name;
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception_Price();
        }
        this.Category = Category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) throws Exception_Quantity {
        if (quantity > 0) {
            this.quantity = quantity;
        } else {
            throw new Exception_Quantity();
        }
    }

    public static int searchById(String id) {
        ArrayList<Class_Items> list = Generic_Methods.readAllData("Items.ser");
        int index = -1;
        if (!list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    index = i;
                    break;
                }
            }
        }
        return index;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double calCOST() {
        return this.getPrice();
    }
}
