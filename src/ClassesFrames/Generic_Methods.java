package ClassesFrames;

import Exceptions.Exception_Date;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Generic_Methods<T> {

    public static <T> ArrayList<T> readAllData(String Filename) {
        ArrayList<T> EmployeeList = new ArrayList<T>(0);
        ObjectInputStream inputStream = null;
        try {
            inputStream = new ObjectInputStream(new FileInputStream(Filename));

            boolean EOF = false;
            while (!EOF) {
                try {
                    T myObj = (T) inputStream.readObject();
                    EmployeeList.add(myObj);
                } catch (ClassNotFoundException e) {
                } catch (EOFException end) {
                    EOF = true;
                }
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                System.out.println("IO Exception while closing file");
            }
        }
        return EmployeeList;
    }

    public static <T> void writeObjectToFile(T s, String Filename) {
        ObjectOutputStream outputStream = null;
        try {
            ArrayList<T> EmployeeList = readAllData(Filename);
            EmployeeList.add(s);
            outputStream = new ObjectOutputStream(new FileOutputStream(Filename));
            for (int i = 0; i < EmployeeList.size(); i++) {
                outputStream.writeObject(EmployeeList.get(i));
            }
        } catch (IOException exp) {
            System.out.println("IO Exception while opening file");
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException exp) {
                System.out.println("IO Exception while closing file");
            }
        }
    }

    public static boolean checkDate(String day, String month, String year) throws Exception {
        int a = Integer.parseInt(day);
        int b = Integer.parseInt(month);
        int c = Integer.parseInt(year);
        boolean h = false;

        if ((day.length() == 2 || day.length() == 1) && (month.length() == 2 || month.length() == 1) && (year.length() == 4)) {
            if ((a > 0 && a <= 31) && (b > 0 && b <= 12 && (c > 2018 && c <= 2020))) {
                h = true;
            } else {
                throw new Exception_Date();
            }
        } else {
            throw new Exception_Date();
        }
        return h;
    }

//    public static <T> double checkEarning(int month, ArrayList<Class_Coustomer> array, ArrayList<Class_Pay> pay,ArrayList<Class_Bills> bill) {
//        double earning = 0;
//        for (Class_Coustomer c : array) {
//            if (c.getDate().getMonth() == month) {
//                earning = earning + c.bill();
//            }
//        }
//        for (Class_Pay p : pay) {
//            if (p.getDate().getMonth() == month) {
//                earning = earning - p.getSalary();
//            }
//        }
//        
//        for (Class_Bills b : bill) {
//            if (b.getDate().getMonth() == month) {
//                earning = earning - (b.getElectricity()+b.getGas()+b.getUtility());
//            }
//        }
//        return earning;
//    }

    
    public static <T> void flushFile(String Filename) throws FileNotFoundException, IOException {
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(Filename));
        outputStream.flush();
    }

}
