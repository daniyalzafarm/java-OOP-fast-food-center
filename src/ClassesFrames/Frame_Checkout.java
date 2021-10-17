package ClassesFrames;

import Exceptions.Exception_Date;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Checkout extends JFrame {

    JPanel p1, p2;
    JButton b1,b2;
    JTextField name, phone, day, month, year;

    public Frame_Checkout() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
        Font dat = new Font("Serif", Font.PLAIN, 18);
//Background
        ImageIcon background_image = new ImageIcon("checkout.jpg");

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

        JLabel l3 = new JLabel("Checkout");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 320, 400, 540);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        Font log = new Font("Serif", Font.BOLD, 30);
        JLabel login = new JLabel("Coustomer Information");
        login.setBounds(50, 10, 300, 50);
        login.setForeground(new Color(225, 222, 173));
        login.setFont(log);
        p1.add(login);

        JLabel l1 = new JLabel("Name");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 100, 120, 30);
        p1.add(l1);
        name = new JTextField();
        name.setFont(f2);
        name.setBounds(160, 100, 210, 30);
        name.setBackground(new Color(225, 222, 173));
        p1.add(name);

        JLabel l2 = new JLabel("Phone");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 180, 100, 30);
        p1.add(l2);
        phone = new JTextField();
        phone.setFont(f2);
        phone.setBounds(160, 180, 210, 30);
        phone.setBackground(new Color(225, 222, 173));
        p1.add(phone);
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

        ImageIcon check=new ImageIcon("pay.png");
        JButton b1 = new JButton("Checkout",check);
        b1.setFont(f2);
        b1.setBounds(100, 360, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);
        
        ImageIcon back1=new ImageIcon("back.png");
        b2 = new JButton("Back",back1);
        b2.setFont(f2);
        b2.setBounds(100, 450, 200, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);

    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Checkout")) {
                if (name.getText().isEmpty() && phone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(new JFrame(), "Fields Cannot be Empty");
                } else {
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
                        Class_Coustomer c1 = new Class_Coustomer(name.getText(), phone.getText(), dat, Generic_Methods.readAllData("Cart.ser"));
                        Generic_Methods.writeObjectToFile(c1, "Customer.ser");
                        JFrame jf = new JFrame();
                        Display_Reciept t = new Display_Reciept(c1);
                        jf.setTitle("Items in Cart");
                        jf.setBounds(300, 150, 1100, 900);
                        //jf.setSize(1200, 800);
                        jf.setVisible(true);
                        jf.add(t);
                        Generic_Methods.flushFile("Cart.ser");
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
                    }
                }
            }else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Buy_Items s = new Frame_Buy_Items();
                s.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Checkout l = new Frame_Checkout();
        l.setResizable(false);
    }

}
