package ClassesFrames;

import Exceptions.Exception_Price;
import Exceptions.Exception_Size;
import java.io.Serializable;

public class Class_Items_Pizza extends Class_Items implements Serializable {

    private String size;
    private Double price;

    public Class_Items_Pizza(String id, String name, double price, String categ, String size) throws Exception_Size, Exception_Price {
        super(id, name, price, categ);
        if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
            this.size = size;
        } else {
            throw new Exception_Size();
        }
    }

    public Double getprice() {
        return price;
    }

    public void setPrice(Double price) throws Exception_Price {
        if (price > 0) {
            this.price = price;
        } else {
            throw new Exception_Price();
        }
    }

    public void setSize(String Size) throws Exception_Size {
        if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
            this.size = Size;
        } else {
            throw new Exception_Size();
        }
    }

    public String getSize() {
        return size;
    }

    public void getSize(String size) {
        this.size = size;
    }

    public double calAmount(String s ) {
        double total = 0;
        if (s.equalsIgnoreCase("small")) {
            total = this.getPrice();
        }
        if (s.equalsIgnoreCase("medium")) {
            total = this.getPrice() + 250;
        }
        if (s.equalsIgnoreCase("large")) {
            total = this.getPrice() + 500;
        }
        return total;
    }

}
