package ClassesFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Frame_Admin extends JFrame {

    JPanel p1;
    JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10;

    public Frame_Admin() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        //   setLocation(500, 100);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("admi.jpg");

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

        JLabel l3 = new JLabel("Admin Panel");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(550, 250, 800, 650);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        b1 = new JButton("Manage Staff");
        b1.setFont(f2);
        b1.setBounds(100, 50, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        b2 = new JButton("Manage Items");
        b2.setFont(f2);
        b2.setBounds(500, 50, 200, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        b3 = new JButton("Check Earning");
        b3.setFont(f2);
        b3.setBounds(100, 150, 200, 50);
        b3.setBackground(new Color(225, 222, 173));
        p1.add(b3);

        b4 = new JButton("Buy Items");
        b4.setFont(f2);
        b4.setBounds(500, 150, 200, 50);
        b4.setBackground(new Color(225, 222, 173));
        p1.add(b4);

        b5 = new JButton("Customers");
        b5.setFont(f2);
        b5.setBounds(100, 250, 200, 50);
        b5.setBackground(new Color(225, 222, 173));
        p1.add(b5);

        b6 = new JButton("Pay Bills");
        b6.setFont(f2);
        b6.setBounds(500, 250, 200, 50);
        b6.setBackground(new Color(225, 222, 173));
        p1.add(b6);

        b7 = new JButton("Paid Employers");
        b7.setFont(f2);
        b7.setBounds(100, 350, 200, 50);
        b7.setBackground(new Color(225, 222, 173));
        p1.add(b7);

        b8 = new JButton("Paid Bills");
        b8.setFont(f2);
        b8.setBounds(500, 350, 200, 50);
        b8.setBackground(new Color(225, 222, 173));
        p1.add(b8);

        ImageIcon pass=new ImageIcon("pass1.png");
        b9 = new JButton("Change Password",pass);
        b9.setFont(f2);
        b9.setBounds(275, 450, 250, 50);
        b9.setBackground(new Color(225, 222, 173));
        p1.add(b9);

        ImageIcon logout=new ImageIcon("logout2.png");
        b10 = new JButton("Log Out", logout);
        b10.setFont(f2);
        b10.setBounds(275, 550, 250, 50);
        b10.setBackground(new Color(225, 222, 173));
        p1.add(b10);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        b6.addActionListener(a);
        b7.addActionListener(a);
        b8.addActionListener(a);
        b9.addActionListener(a);
        b10.addActionListener(a);
    }

    public static double checkEarning(int month, int year, ArrayList<Class_Coustomer> array, ArrayList<Class_Pay> pay, ArrayList<Class_Bills> bill) {
        double earning = 0;
        for (Class_Coustomer c : array) {
            if (c.getDate().getMonth() == month && c.getDate().getYear() == year) {
                earning = earning + c.bill();
            }
        }
        for (Class_Pay p : pay) {
            if (p.getDate().getMonth() == month && p.getDate().getYear() == year) {
                earning = earning - p.getSalary();
            }
        }

        for (Class_Bills b : bill) {
            if (b.getDate().getMonth() == month && b.getDate().getYear() == year) {
                earning = earning - (b.getElectricity() + b.getGas() + b.getUtility());
            }
        }
        return earning;
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Manage Staff")) {
                dispose();
                Frame_Manage_Staff s = new Frame_Manage_Staff();
                s.setResizable(false);
            } else if (ae.getActionCommand().equals("Manage Items")) {
                dispose();
                Frame_Manage_Items i = new Frame_Manage_Items();
                i.setResizable(false);
                // i.setResizable(true);
            } else if (ae.getActionCommand().equals("Check Earning")) {
                String month = JOptionPane.showInputDialog("Enter month : ");
                String year = JOptionPane.showInputDialog("Enter Year : ");
                int a = Integer.parseInt(month);
                int b = Integer.parseInt(year);
                double earn = 0;
                if (((month.length() == 2 || month.length() == 1) && (a > 0 && a <= 12))
                        && (year.length() == 4) && (b > 2018 && b <= 2020)) {
                    earn = Frame_Admin.checkEarning(a, b, Generic_Methods.readAllData("Customer.ser"),
                            Generic_Methods.readAllData("Pay.ser"), Generic_Methods.readAllData("Bills.ser"));
                    JOptionPane.showMessageDialog(new JFrame(), ("Earning : " + String.valueOf(earn)));
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Invalid Month or Year!");
                }

            } else if (ae.getActionCommand().equals("Buy Items")) {
                dispose();
                Frame_Buy_Items i = new Frame_Buy_Items();
                i.setResizable(false);
            } else if (ae.getActionCommand().equals("Pay Bills")) {
                dispose();
                Frame_Pay_Bills l = new Frame_Pay_Bills();
                l.setResizable(false);
            } else if (ae.getActionCommand().equals("Customers")) {
                JFrame jf = new JFrame();
                Display_Customers t = new Display_Customers();
                jf.setTitle("Customers Data");
                jf.setSize(1920, 1080);
                jf.setVisible(true);
                jf.add(t);
            } else if (ae.getActionCommand().equals("Paid Employers")) {
                JFrame jf = new JFrame();
                Display_Pay t = new Display_Pay();
                jf.setTitle("Payed to Employers");
                jf.setSize(1920, 1080);
                jf.setVisible(true);
                jf.add(t);
            } else if (ae.getActionCommand().equals("Paid Bills")) {
                JFrame jf = new JFrame();
                Display_Bills t = new Display_Bills();
                jf.setTitle("Payed to Bills");
                jf.setSize(1920, 1080);
                jf.setVisible(true);
                jf.add(t);
            } else if (ae.getActionCommand().equals("Change Password")) {
                dispose();
                Frame_Change_Password f = new Frame_Change_Password();
                f.setResizable(false);
            } else if (ae.getActionCommand().equals("Log Out")) {
                dispose();
                Frame_Login f = new Frame_Login();
                f.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Admin l = new Frame_Admin();
        l.setResizable(false);
    //    l.setResizable(true);
    }
}
