/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesFrames;

import Exceptions.Exception_Bills;
import java.io.Serializable;

/**
 *
 * @author DANIYAL ZAFAR
 */
public class Class_Bills implements Serializable{

    private double electricity;
    private double utility;
    private double gas;
    private Class_Persons_Date Date;

    public Class_Bills(double electricity, double utility, double gas,Class_Persons_Date dat) throws Exception_Bills {
        if (electricity >= 0 && utility >= 0 && gas >= 0) {
            this.electricity = electricity;
            this.utility = utility;
            this.gas = gas;
        } else {
            throw new Exception_Bills();
        }
        this.Date=dat;
    }

    public Class_Persons_Date getDate() {
        return Date;
    }

    public void setDate(Class_Persons_Date Date) {
        this.Date = Date;
    }

    public double getElectricity() {
        return electricity;
    }

    public void setElectricity(double electricity) throws Exception_Bills {
        if (electricity >= 0) {
            this.electricity = electricity;
            
        } else {
            throw new Exception_Bills();
        }
    }

    public double getUtility() {
        return utility;
    }

    public void setUtility(double utility) throws Exception_Bills {
        if (utility >= 0 ) {
            this.utility = utility;
        } else {
            throw new Exception_Bills();
        }
    }

    public double getGas() {
        return gas;
    }

    public void setGas(double gas) throws Exception_Bills {
        if (gas >= 0) {
            this.gas = gas;
        } else {
            throw new Exception_Bills();
        }
    }

}
