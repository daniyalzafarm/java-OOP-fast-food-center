package ClassesFrames;

import Exceptions.Exception_Price;
import Exceptions.Exception_Size;
import java.io.Serializable;

public class Class_Items_French_Fries extends Class_Items implements Serializable{
    private String size;
    private Double Price;

    public Class_Items_French_Fries( String id, String name, double price,String categ,String size) throws Exception_Size, Exception_Price {
        super(id, name, price,categ);
        if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
            size = size;
        } else {
            throw new Exception_Size();
        }
    }

    public Double getprice() {
        return Price;
    }

    public void setPrice(Double price) throws Exception_Price {
        if (price > 0) {
            this.Price = price;
        }else{
        throw new Exception_Price();
        }
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) throws Exception_Size {
        if (size.equalsIgnoreCase("small") || size.equalsIgnoreCase("medium") || size.equalsIgnoreCase("large")) {
            this.size = size;
        } else {
            throw new Exception_Size();
        }
    }

    

public double calCost(String s) {
        double total=0;
        if (s.equalsIgnoreCase("small")) {
            total=this.getPrice();
        } else if (s.equalsIgnoreCase("medium")) {
            total=this.getPrice()+50;
        } else if (s.equalsIgnoreCase("large")){
            total=this.getPrice()+100;
        }
        return total;
    }
    
    
}
