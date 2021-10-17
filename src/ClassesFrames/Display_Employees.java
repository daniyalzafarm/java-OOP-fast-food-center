/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesFrames;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumnModel;

public class Display_Employees extends JPanel {

    JTable table;

    public Display_Employees() {
        Font f = new Font("Serif", Font.PLAIN, 20);
        Font f1 = new Font("Serif", Font.BOLD, 25);
        ArrayList<Class_Persons_Employee> StudentList = Generic_Methods.readAllData("Employee.ser");
        String[] columns = {"Id", "Name", "Phone", "Email", "Address","Date Hired","Designation","Salary"};
        String[][] data = new String[StudentList.size()][8];
        for (int i = 0; i < StudentList.size(); i++) {

            data[i][0] = StudentList.get(i).getId();
            data[i][1] = StudentList.get(i).getName();
            data[i][2] = StudentList.get(i).getPhone();
            data[i][3] = StudentList.get(i).getEmail();
            data[i][4] = String.valueOf(StudentList.get(i).getAdd().getHome())+" "+String.valueOf(StudentList.get(i).getAdd().getTown());
            data[i][5] = String.valueOf(StudentList.get(i).getDate_hired().getDay())+"-"+
                    String.valueOf(StudentList.get(i).getDate_hired().getMonth())+"-"+
                    String.valueOf(StudentList.get(i).getDate_hired().getYear());
            data[i][6] = StudentList.get(i).getDesignation();
            data[i][7] = String.valueOf(StudentList.get(i).getSalary());

        }
        table = new JTable(data, columns) {
            @Override
            public boolean isCellEditable(int data, int columns) {
                return false;
            }
        };

        TableColumnModel c=table.getColumnModel();
        c.getColumn(1).setPreferredWidth(200);
        c.getColumn(3).setPreferredWidth(200);
        c.getColumn(4).setPreferredWidth(300);
        
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
        Display_Employees t = new Display_Employees();
        jf.setTitle("Employee Data");
        jf.setSize(1920, 1080);
        jf.setVisible(true);
        jf.add(t);

    }

}
