package ClassesFrames;

import static ClassesFrames.Generic_Methods.readAllData;
import Exceptions.Exception_Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Frame_Add_Employee extends JFrame {

    JPanel p1, p2;
    JButton b1, back;
    JTextField id, name, phone, email, address, city, date, salary, day, month, year, designation;
    JLabel header, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, d, m, y, date_hired;
    JRadioButton r1, r2, r3, r4;

    public Frame_Add_Employee() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
    //    setLocation(500, 100);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
        Font dat = new Font("Serif", Font.PLAIN, 18);
//Background
        ImageIcon background_image = new ImageIcon("emp.jpg");

        Image image = background_image.getImage();
        Image temp_image = image.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_image);

        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1920, 1080);
        add(background);

//Heading
        JPanel light = new JPanel();
        light.setBackground(new Color(0, 0, 0, 220));
        light.setBounds(0, 0, 1920, 120);

        header = new JLabel("Add Employee");
        header.setFont(f1);
        header.setForeground(new Color(225, 222, 173));
        header.setBounds(200, 30, 400, 50);
        light.add(header);

        background.add(light);
//Add Employee Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(500, 280, 830, 600);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

//Back Button

        ImageIcon back1=new ImageIcon("back.png");
        back = new JButton("Back",back1);
        back.setFont(f2);
        back.setBounds(30, 10, 150, 30);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);

//Information
        l1 = new JLabel("Id");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 80, 100, 30);
        p1.add(l1);
        id = new JTextField();
        id.setFont(f2);
        id.setBounds(120, 80, 250, 30);
        id.setBackground(new Color(225, 222, 173));
        p1.add(id);

        l2 = new JLabel("Phone");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 160, 100, 30);
        p1.add(l2);
        phone = new JTextField();
        phone.setFont(f2);
        phone.setBounds(120, 160, 250, 30);
        phone.setBackground(new Color(225, 222, 173));
        p1.add(phone);

        l3 = new JLabel("Address");
        l3.setFont(f2);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(30, 240, 100, 30);
        p1.add(l3);
        address = new JTextField();
        address.setFont(f2);
        address.setBounds(120, 240, 250, 30);
        address.setBackground(new Color(225, 222, 173));
        p1.add(address);

        l4 = new JLabel("Job Title");
        l4.setFont(f2);
        l4.setForeground(new Color(225, 222, 173));
        l4.setBounds(30, 320, 100, 30);
        p1.add(l4);
        designation = new JTextField();
        designation.setFont(f2);
        designation.setBounds(120, 320, 250, 30);
        designation.setBackground(new Color(225, 222, 173));
        p1.add(designation);

        l6 = new JLabel("Name");
        l6.setFont(f2);
        l6.setForeground(new Color(225, 222, 173));
        l6.setBounds(430, 80, 100, 30);
        p1.add(l6);
        name = new JTextField();
        name.setFont(f2);
        name.setBounds(550, 80, 250, 30);
        name.setBackground(new Color(225, 222, 173));
        p1.add(name);

        l8 = new JLabel("E-mail");
        l8.setFont(f2);
        l8.setForeground(new Color(225, 222, 173));
        l8.setBounds(430, 160, 100, 30);
        p1.add(l8);
        email = new JTextField();
        email.setFont(f2);
        email.setBounds(550, 160, 250, 30);
        email.setBackground(new Color(225, 222, 173));
        p1.add(email);

        l9 = new JLabel("City");
        l9.setFont(f2);
        l9.setForeground(new Color(225, 222, 173));
        l9.setBounds(430, 240, 100, 30);
        p1.add(l9);
        city = new JTextField();
        city.setFont(f2);
        city.setBounds(550, 240, 250, 30);
        city.setBackground(new Color(225, 222, 173));
        p1.add(city);

        l10 = new JLabel("Salary");
        l10.setFont(f2);
        l10.setForeground(new Color(225, 222, 173));
        l10.setBounds(430, 320, 100, 30);
        p1.add(l10);
        salary = new JTextField();
        salary.setFont(f2);
        salary.setBounds(550, 320, 250, 30);
        salary.setBackground(new Color(225, 222, 173));
        p1.add(salary);

//Hire Date
        date_hired = new JLabel("Date hired :");
        date_hired.setFont(f2);
        date_hired.setForeground(new Color(225, 222, 173));
        date_hired.setBounds(30, 400, 200, 30);
        p1.add(date_hired);

        d = new JLabel("Day");
        d.setFont(dat);
        d.setForeground(new Color(225, 222, 173));
        d.setBounds(190, 370, 50, 30);
        p1.add(d);

        day = new JTextField(2);
        day.setFont(f2);
        day.setBackground(new Color(225, 222, 173));
        day.setBounds(190, 400, 30, 30);
        p1.add(day);

        m = new JLabel("Month");
        m.setFont(dat);
        m.setForeground(new Color(225, 222, 173));
        m.setBounds(240, 370, 50, 30);
        p1.add(m);

        month = new JTextField(2);
        month.setFont(f2);
        month.setBackground(new Color(225, 222, 173));
        month.setBounds(245, 400, 30, 30);
        p1.add(month);

        y = new JLabel("Year");
        y.setFont(dat);
        y.setForeground(new Color(225, 222, 173));
        y.setBounds(310, 370, 50, 30);
        p1.add(y);

        year = new JTextField(4);
        year.setFont(f2);
        year.setBackground(new Color(225, 222, 173));
        year.setBounds(300, 400, 60, 30);
        p1.add(year);

        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        String[] arr=sdf.format(date).split("/");
        day.setText(arr[0]);
        month.setText(arr[1]);
        year.setText(arr[2]);
//Button
        ImageIcon add=new ImageIcon("C:\\OOP_Project\\Icons\\add user.png");
        JButton b1 = new JButton("ADD",add);
        b1.setFont(f2);
        b1.setBounds(325, 500, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        Listner a = new Listner();
        back.addActionListener(a);
        b1.addActionListener(a);

//Generate ID
        String ID = generateId("Employee.ser");
        if (ID != null) {
            id.setText(ID);
        } else {
            id.setText("EP-1");
        }
        id.setEditable(false);
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Employee s = new Frame_Employee();
                s.setResizable(false);
            } else if (ae.getActionCommand().equals("ADD")) {
                Class_Persons_Date dat = null;
                Class_Persons_Address add = null;
                Class_Persons_Employee emp = null;
                try {
                    int a = Integer.parseInt(day.getText());
                    int b = Integer.parseInt(month.getText());
                    int c = Integer.parseInt(year.getText());
                    if (Generic_Methods.checkDate(day.getText(), month.getText(), year.getText())) {
                        dat = new Class_Persons_Date(a, b, c);
                    } else {
                        throw new Exception_Date();
                    }

                    add = new Class_Persons_Address(address.getText(), city.getText());

                    emp = new Class_Persons_Employee(id.getText(), designation.getText(), Double.parseDouble(salary.getText()),
                            dat, name.getText(), phone.getText(), email.getText(), add);

                    Generic_Methods.writeObjectToFile(emp, "Employee.ser");

                    JOptionPane.showMessageDialog(new JFrame(), (emp.getName() + " is Added Successfully!"));
                    dispose();
                    Frame_Employee e1 = new Frame_Employee();
                    e1.setResizable(false);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }
        }
    }

    public static String generateId(String filename) {
        ArrayList<Class_Persons_Employee> list = readAllData(filename);
        String final_id = null;
        if (list.size() != 0) {
            Class_Persons_Employee last = list.get(list.size() - 1);
            String Id = last.getId();
            String[] arr = Id.split("-");
            int num = Integer.parseInt(arr[1]);
            num++;
            final_id = arr[0] + "-" + String.valueOf(num);
        }
        return final_id;
    }

    public static void main(String[] args) {
        Frame_Add_Employee l = new Frame_Add_Employee();
        l.setResizable(false);
    //    l.setResizable(true);
    }

}
