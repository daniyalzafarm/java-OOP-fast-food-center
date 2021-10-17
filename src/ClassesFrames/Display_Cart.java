package ClassesFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Display_Cart extends JPanel {

    JTable table;

    public Display_Cart() {
        Font f = new Font("Serif", Font.PLAIN, 20);
        Font f1 = new Font("Serif", Font.BOLD, 25);
        ArrayList<Class_Items> List = Generic_Methods.readAllData("Cart.ser");
        String[] columns = {"Item Id", "Item Name", "Category", "Size","Price", "Quantity", "Total"};
        String[][] data = new String[List.size()][7];
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
            data[i][4] = String.valueOf(List.get(i).getPrice()/List.get(i).getQuantity());
            data[i][5] = String.valueOf(List.get(i).getQuantity());
            data[i][6] = String.valueOf(List.get(i).getPrice());
//            if (List.get(i).getCategory().equalsIgnoreCase("Pizza")) {
//                Class_Items_Pizza pz = (Class_Items_Pizza) List.get(i);
//                data[i][5] = String.valueOf(pz.calAmount(pz.getSize()));
//            } else if (List.get(i).getCategory().equalsIgnoreCase("French Fries")) {
//                Class_Items_French_Fries pz = (Class_Items_French_Fries) List.get(i);
//                data[i][5] = String.valueOf(pz.calCost(pz.getSize()));
//            } else {
//                data[i][5] = String.valueOf(List.get(i).getPrice());
//            }

        }
        table = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };

        table.setFont(f);
        table.getTableHeader().setBackground(new Color(225, 222, 173));
        table.getTableHeader().setFont(f1);
        table.setPreferredScrollableViewportSize(new Dimension(1800, 950));
        table.setFillsViewportHeight(false);
        table.setFont(f);
        for (int i = 0; i < List.size(); i++) {
            table.setRowHeight(i, 30);
        }
        JScrollPane jps = new JScrollPane(table);
        add(jps);

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        
        Display_Cart t = new Display_Cart();

        jf.setTitle("Items in Cart");
        jf.setSize(1920, 1080);
        jf.setVisible(true);
        jf.add(t);

    }

}
