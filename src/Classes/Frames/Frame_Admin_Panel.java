package Classes.Frames;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Frame_Admin_Panel extends JFrame {

    JPanel main_panel, p1, p2, p3, p4, p5, p6, p7, p8, p9;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2;

    public Frame_Admin_Panel() throws HeadlessException {
        super("Admin Panel");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocation(500, 150);
        setVisible(true);

        //main_panel = new JPanel(new GridLayout(6,1));
        p1 = new JPanel(new GridLayout(5, 1));
        add(p1, BorderLayout.CENTER);

        p2 = new JPanel(new FlowLayout());
        p1.add(p2);

        l1 = new JLabel("Admin Panel");
        Font f1 = new Font("Serif", Font.BOLD, 70);
        l1.setFont(f1);
        p2.add(l1);

        p4 = new JPanel(new FlowLayout());
        p1.add(p4);
        b1 = new JButton("Button 1");
        b1.setSize(100, 20);
        b1.setText("Manage Staff");
        p4.add(b1);

        p5 = new JPanel(new FlowLayout());
        p1.add(p5);
        b2 = new JButton("Manage Items ");
        p5.add(b2);
        
        Date d=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("mm-dd-yyyy");
        System.out.println(sdf.format(d));
        
        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Manage Staff")) {
                dispose();
                Frame_Manage_Staff p1 = new Frame_Manage_Staff();
                p1.setResizable(false);
            } else if (ae.getActionCommand().equals("Manage Items")) {
                dispose();
                Frame_Manage_Items p1 = new Frame_Manage_Items();
                p1.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Admin_Panel p1 = new Frame_Admin_Panel();
        p1.setResizable(false);
    }
}
