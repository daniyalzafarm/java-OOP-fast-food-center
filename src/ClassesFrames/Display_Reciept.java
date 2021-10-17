package ClassesFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Display_Reciept extends JPanel {

    JTable table;

    public Display_Reciept(Class_Coustomer c) {
        Font f = new Font("Serif", Font.PLAIN, 20);
        Font f1 = new Font("Serif", Font.BOLD, 25);
        ArrayList<Class_Items> List = Generic_Methods.readAllData("Cart.ser");
        String[] columns = {"Item Id", "Item Name", "Category", "Size", "Quatity", "Price"};
        String[][] data = new String[List.size()][6];
        for (int i = 0; i < List.size(); i++) {

            data[i][0] = List.get(i).getId();
            data[i][1] = List.get(i).getName();
            data[i][2] = List.get(i).getCategory();
            if (List.get(i).getCategory().equalsIgnoreCase("Pizza")) {
                Class_Items_Pizza pz = (Class_Items_Pizza) List.get(i);
                data[i][3] = pz.getSize();
            } else if (List.get(i).getCategory().equalsIgnoreCase("French Fries")) {
                Class_Items_French_Fries pz = (Class_Items_French_Fries) List.get(i);
                data[i][3] = pz.getSize();
            } else {
                data[i][3] = "Default";
            }
            
            data[i][4] = String.valueOf(List.get(i).getQuantity());
            data[i][5] = String.valueOf(List.get(i).getPrice());


        }
        table = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };

        JLabel l1=new JLabel("Customer Name : "+c.getName()+"                            Phone : "+c.getPhone());
        l1.setFont(f1);
        add(l1);
        table.setFont(f);
        table.getTableHeader().setBackground(new Color(225, 222, 173));
        table.getTableHeader().setFont(f1);
        table.setPreferredScrollableViewportSize(new Dimension(1000, 600));
        table.setFillsViewportHeight(false);
        table.setFont(f);
        for (int i = 0; i < List.size(); i++) {
            table.setRowHeight(i, 30);
        }
        JScrollPane jps = new JScrollPane(table);
        add(jps);
        
        JLabel l=new JLabel("Total bill : "+String.valueOf(c.bill()));
        l.setFont(f1);
        l.setBounds(400, 700, 200, 100);
        add(l);
        

    }

    public static void main(String[] args) {

    }

}
