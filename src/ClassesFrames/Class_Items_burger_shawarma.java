package ClassesFrames;

import Exceptions.Exception_Price;
import java.io.Serializable;

public class Class_Items_burger_shawarma extends Class_Items implements Serializable{

    public Class_Items_burger_shawarma(String id, String name, double price,String categ) throws Exception_Price {
        super(id, name, price,categ);
    }


    public double calCOST() {
        return this.getPrice();
    }
    
    
}
