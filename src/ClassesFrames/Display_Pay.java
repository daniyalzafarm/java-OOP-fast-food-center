
package ClassesFrames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Display_Pay extends JPanel {

    JTable table;

    public Display_Pay() {
        Font f = new Font("Serif", Font.PLAIN, 20);
        Font f1 = new Font("Serif", Font.BOLD, 25);
        ArrayList<Class_Pay> StudentList = Generic_Methods.readAllData("Pay.ser");
        String[] columns = { "Date","Id", "Name", "Salary"};
        String[][] data = new String[StudentList.size()][4];
        for (int i = 0; i < StudentList.size(); i++) {

            data[i][0] = String.valueOf(StudentList.get(i).getDate().getDay())+"-"+
                    String.valueOf(StudentList.get(i).getDate().getMonth())+"-"+
                    String.valueOf(StudentList.get(i).getDate().getYear());
            data[i][1] = StudentList.get(i).getId();
            data[i][2] = StudentList.get(i).getName();
            data[i][3] = String.valueOf(StudentList.get(i).getSalary());

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
        Display_Pay t = new Display_Pay();
        
        jf.setTitle("Payed to Employees");
        jf.setSize(1920, 1080);
        jf.setVisible(true);
        jf.add(t);

    }

}
