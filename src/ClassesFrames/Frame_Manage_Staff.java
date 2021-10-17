package ClassesFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame_Manage_Staff extends JFrame {

    JPanel p1, p2;
    JButton b1, b2, b3, b4;
    JTextField t1;
    JPasswordField password;

    public Frame_Manage_Staff() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
    //    setLocation(500, 100);
        setVisible(true);
        
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("staff.jpg");

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

        
        JLabel l3 = new JLabel("Manage Staff");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);

//Login Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 280, 400, 500);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));


        b1 = new JButton("Employee");
        b1.setFont(f2);
        b1.setBounds(50, 70, 300, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        b2 = new JButton("Cooks");
        b2.setFont(f2);
        b2.setBounds(50, 170, 300, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        b3 = new JButton("Sweepers");
        b3.setFont(f2);
        b3.setBounds(50, 270, 300, 50);
        b3.setBackground(new Color(225, 222, 173));
        p1.add(b3);

        ImageIcon back=new ImageIcon("back.png");
        b4 = new JButton("Back",back);
        b4.setFont(f2);
        b4.setBounds(50, 370, 300, 50);
        b4.setBackground(new Color(225, 222, 173));
        p1.add(b4);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);

    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Employee")) {
                dispose();
                Frame_Employee e=new Frame_Employee();
                e.setResizable(false);
            } else if (ae.getActionCommand().equals("Cooks")) {
                dispose();
                Frame_Cook e=new Frame_Cook();
                e.setResizable(false);
            } else if (ae.getActionCommand().equals("Sweepers")) {
                dispose();
                Frame_Sweeper s=new Frame_Sweeper();
                s.setResizable(false);
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Admin a=new Frame_Admin();
                a.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Manage_Staff l = new Frame_Manage_Staff();
        l.setResizable(false);
    //    l.setResizable(true);
    }
}
