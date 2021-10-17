
package ClassesFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Display_Items extends JPanel {

    JTable table;

    public Display_Items() {
        Font f = new Font("Serif", Font.PLAIN, 20);
        Font f1 = new Font("Serif", Font.BOLD, 25);
        ArrayList<Class_Items> StudentList = Generic_Methods.readAllData("Items.ser");
        String[] columns = {"Item Id", "Item Name", "Category", "Price"};
        String[][] data = new String[StudentList.size()][4];
        for (int i = 0; i < StudentList.size(); i++) {

            data[i][0] = StudentList.get(i).getId();
            data[i][1] = StudentList.get(i).getName();
            data[i][2] = StudentList.get(i).getCategory();
            data[i][3] = String.valueOf(StudentList.get(i).getPrice());

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
        for (int i = 0; i < StudentList.size(); i++) {
            table.setRowHeight(i,30);
        }
        JScrollPane jps = new JScrollPane(table);
        add(jps);

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        Display_Items t = new Display_Items();
        
        jf.setTitle("Available Items");
        jf.setSize(1920, 1080);
        jf.setVisible(true);
        jf.add(t);

    }

}
