package ClassesFrames;

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
import javax.swing.JTextField;

public class Frame_Pay_Bills extends JFrame {

    JPanel p1;
    JButton b1, back, pay;
    JTextField t1, t2, t3, day, month, year;

    public Frame_Pay_Bills() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
        Font dat = new Font("Serif", Font.PLAIN, 18);
//Background
        ImageIcon background_image = new ImageIcon("bills.jpg");

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

        JLabel header = new JLabel("Pay Bills");
        header.setFont(f1);
        header.setForeground(new Color(225, 222, 173));
        header.setBounds(200, 25, 400, 50);
        light.add(header);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 330, 400, 450);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        JLabel l1 = new JLabel("Electricity ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 80, 200, 30);
        p1.add(l1);
        t1 = new JTextField();
        t1.setFont(f2);
        t1.setBounds(150, 80, 220, 30);
        t1.setBackground(new Color(225, 222, 173));
        p1.add(t1);

        JLabel l2 = new JLabel("Gas ");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 140, 100, 30);
        p1.add(l2);
        t2 = new JTextField();
        t2.setFont(f2);
        t2.setBounds(150, 140, 220, 30);
        t2.setBackground(new Color(225, 222, 173));
        p1.add(t2);

        JLabel l3 = new JLabel("Utility ");
        l3.setFont(f2);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(30, 200, 100, 30);
        p1.add(l3);
        t3 = new JTextField();
        t3.setFont(f2);
        t3.setBounds(150, 200, 220, 30);
        t3.setBackground(new Color(225, 222, 173));
        p1.add(t3);

        ImageIcon check=new ImageIcon("pay.png");
        JButton b1 = new JButton("Pay Now",check);
        b1.setFont(f2);
        b1.setBounds(100, 350, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        ImageIcon back1=new ImageIcon("back.png");
        back = new JButton("Back",back1);
        back.setFont(f2);
        back.setBounds(30, 20, 150, 30);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);
//Hire Date
        JLabel date_hired = new JLabel("Current Date ");
        date_hired.setFont(f2);
        date_hired.setForeground(new Color(225, 222, 173));
        date_hired.setBounds(30, 280, 200, 30);
        p1.add(date_hired);

        JLabel d = new JLabel("Day");
        d.setFont(dat);
        d.setForeground(new Color(225, 222, 173));
        d.setBounds(190, 250, 50, 30);
        p1.add(d);

        day = new JTextField(2);
        day.setFont(f2);
        day.setBackground(new Color(225, 222, 173));
        day.setBounds(190, 280, 30, 30);
        p1.add(day);

        JLabel m = new JLabel("Month");
        m.setFont(dat);
        m.setForeground(new Color(225, 222, 173));
        m.setBounds(240, 250, 50, 30);
        p1.add(m);

        month = new JTextField(2);
        month.setFont(f2);
        month.setBackground(new Color(225, 222, 173));
        month.setBounds(245, 280, 30, 30);
        p1.add(month);

        JLabel y = new JLabel("Year");
        y.setFont(dat);
        y.setForeground(new Color(225, 222, 173));
        y.setBounds(310, 250, 50, 30);
        p1.add(y);

        year = new JTextField(4);
        year.setFont(f2);
        year.setBackground(new Color(225, 222, 173));
        year.setBounds(300, 280, 60, 30);
        p1.add(year);
        
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
        Date date=new Date();
        String[] arr=sdf.format(date).split("/");
        day.setText(arr[0]);
        month.setText(arr[1]);
        year.setText(arr[2]);

        Listner a = new Listner();
        b1.addActionListener(a);
//        pay.addActionListener(a);
        back.addActionListener(a);

    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Pay Now")) {
                Class_Persons_Date dat = null;
                try {
                    int a = Integer.parseInt(day.getText());
                    int b = Integer.parseInt(month.getText());
                    int c = Integer.parseInt(year.getText());
                    if (Generic_Methods.checkDate(day.getText(), month.getText(), year.getText())) {
                        dat = new Class_Persons_Date(a, b, c);
                    } else {
                        throw new Exception_Date();
                    }
                    boolean check = true;
                    ArrayList<Class_Bills> array = Generic_Methods.readAllData("Bills.ser");
                    for (Class_Bills bill : array) {
                        if (bill.getDate().getMonth() == Integer.parseInt(month.getText())) {
                            check = false;
                        }
                    }
                    if (check) {
                        Class_Bills bill = new Class_Bills(Double.parseDouble(t1.getText()), Double.parseDouble(t2.getText()),
                                Double.parseDouble(t3.getText()), dat);
                        Generic_Methods.writeObjectToFile(bill, "Bills.ser");
                        JOptionPane.showMessageDialog(new JFrame(), "Bills Paid Successfullu!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Admin s = new Frame_Admin();
                s.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Pay_Bills l = new Frame_Pay_Bills();
        l.setResizable(false);
        //   l.setResizable(true);
    }

}
