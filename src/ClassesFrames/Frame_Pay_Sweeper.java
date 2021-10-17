package ClassesFrames;

import Exceptions.Exception_Date;
import Exceptions.Exception_IdNotFound;
import Exceptions.Exception_Salary;
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

public class Frame_Pay_Sweeper extends JFrame {

    JPanel p1;
    JButton b1, back, pay;
    JTextField t1, t2, t3, day, month, year;

    public Frame_Pay_Sweeper() throws HeadlessException {
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
        ImageIcon background_image = new ImageIcon("sweeper2.jpg");

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

        JLabel header = new JLabel("Pay to Sweeper");
        header.setFont(f1);
        header.setForeground(new Color(225, 222, 173));
        header.setBounds(200, 25, 400, 50);
        light.add(header);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 330, 400, 500);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        JLabel l1 = new JLabel("Enter Id ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 80, 100, 30);
        p1.add(l1);
        t1 = new JTextField();
        t1.setFont(f2);
        t1.setBounds(150, 80, 220, 30);
        t1.setBackground(new Color(225, 222, 173));
        p1.add(t1);

        JLabel l2 = new JLabel("Name ");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 140, 100, 30);
        p1.add(l2);
        t2 = new JTextField();
        t2.setFont(f2);
        t2.setBounds(150, 140, 220, 30);
        t2.setBackground(new Color(225, 222, 173));
        p1.add(t2);

        JLabel l3 = new JLabel("Salary ");
        l3.setFont(f2);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(30, 200, 100, 30);
        p1.add(l3);
        t3 = new JTextField();
        t3.setFont(f2);
        t3.setBounds(150, 200, 220, 30);
        t3.setBackground(new Color(225, 222, 173));
        p1.add(t3);

        ImageIcon fetc=new ImageIcon("fetch.png");
        b1 = new JButton("Get Salary",fetc);
        b1.setFont(f2);
        b1.setBounds(100, 350, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        ImageIcon check=new ImageIcon("pay.png");
        pay = new JButton("Pay Now",check);
        pay.setFont(f2);
        pay.setBounds(100, 430, 200, 50);
        pay.setBackground(new Color(225, 222, 173));
        p1.add(pay);

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
        pay.addActionListener(a);
        back.addActionListener(a);

        t1.setText("SW-");
        pay.setEnabled(false);
        day.setEnabled(false);
        month.setEnabled(false);
        year.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Get Salary")) {

                ArrayList<Class_Persons_Sweeper> list = Generic_Methods.readAllData("Sweeper.ser");
                try {

                    int index = -1;
                    if (!list.isEmpty()) {
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId().equalsIgnoreCase(t1.getText())) {
                                index = i;
                                break;
                            }
                        }
                        if (index != -1) {
                            pay.setEnabled(true);
                            day.setEnabled(true);
                            month.setEnabled(true);
                            year.setEnabled(true);
                            t2.setEnabled(true);
                            t3.setEnabled(true);
                            t1.setEditable(false);
                            t2.setEditable(false);
                            t2.setText(list.get(index).getName());
                            t3.setText(String.valueOf(list.get(index).getSalary()));
                            b1.setEnabled(false);
                        } else {
                            throw new Exception_IdNotFound();
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "No Sweeper in Record!");
                        dispose();
                        Frame_Sweeper s1 = new Frame_Sweeper();
                        s1.setResizable(false);
                    //    s1.setResizable(true);
                    }
                } catch (Exception_IdNotFound ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            } else if (ae.getActionCommand().equals("Pay Now")) {
                ArrayList<Class_Pay> array = Generic_Methods.readAllData("Pay.ser");
                boolean check = true;
                for (Class_Pay p : array) {
                    if (t1.getText().equalsIgnoreCase(p.getId()) && Integer.parseInt(month.getText()) == p.getDate().getMonth()) {
                        check = false;
                    }
                }
                if (check) {
                    ArrayList<Class_Persons_Sweeper> list = Generic_Methods.readAllData("Sweeper.ser");
                    int index = -1;
                    Class_Persons_Date dat = null;
                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).getId().equalsIgnoreCase(t1.getText())) {
                            index = i;

                            break;
                        }
                    }

                    try {

                        int a = Integer.parseInt(day.getText());
                        int b = Integer.parseInt(month.getText());
                        int c = Integer.parseInt(year.getText());

                        if (Generic_Methods.checkDate(day.getText(), month.getText(), year.getText())) {

                            dat = new Class_Persons_Date(a, b, c);
                        } else {
                            throw new Exception_Date();
                        }

                        Class_Pay p1 = new Class_Pay(t1.getText(), t2.getText(), Double.parseDouble(t3.getText()), dat);

                        Generic_Methods.writeObjectToFile(p1, "Pay.ser");
                        JOptionPane.showMessageDialog(new JFrame(), (t2.getText() + " Payed to " + list.get(index).getName() + " Successfully!"));
                        Frame_Pay_Sweeper s1 = new Frame_Pay_Sweeper();
                        s1.setResizable(false);

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "You have payed this Employer this month!");
                }
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Sweeper s = new Frame_Sweeper();
                s.setResizable(false);
            }
        }
    }

    public static void main(String[] args) throws Exception_Salary {
        Frame_Pay_Sweeper l = new Frame_Pay_Sweeper();
        l.setResizable(false);
        // l.setResizable(true);

    }

}
