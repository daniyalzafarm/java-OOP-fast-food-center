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

public class Frame_Sweeper extends JFrame {

    JPanel p1, p2;
    JButton b1, b2, b3, b4, b5, update;

    public Frame_Sweeper() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        //      setLocation(500, 100);
        setVisible(true);

        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("sweeper3.jpg");

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

        JLabel l3 = new JLabel("Manage Sweepers");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);

//Login Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 250, 400, 645);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        b1 = new JButton("Add Sweeper");
        b1.setFont(f2);
        b1.setBounds(50, 50, 300, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        b2 = new JButton("Remove Sweeper");
        b2.setFont(f2);
        b2.setBounds(50, 150, 300, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        update = new JButton("Update Sweeper");
        update.setFont(f2);
        update.setBounds(50, 250, 300, 50);
        update.setBackground(new Color(225, 222, 173));
        p1.add(update);

        b3 = new JButton("Display all Sweepers");
        b3.setFont(f2);
        b3.setBounds(50, 350, 300, 50);
        b3.setBackground(new Color(225, 222, 173));
        p1.add(b3);

        b4 = new JButton("Pay to Sweeper");
        b4.setFont(f2);
        b4.setBounds(50, 450, 300, 50);
        b4.setBackground(new Color(225, 222, 173));
        p1.add(b4);

        ImageIcon back1=new ImageIcon("back.png");
        b5 = new JButton("Back",back1);
        b5.setFont(f2);
        b5.setBounds(50, 550, 300, 50);
        b5.setBackground(new Color(225, 222, 173));
        p1.add(b5);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        update.addActionListener(a);
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Add Sweeper")) {
                dispose();
                Frame_Add_Sweeper e = new Frame_Add_Sweeper();
                e.setResizable(false);
            } else if (ae.getActionCommand().equals("Remove Sweeper")) {
                dispose();
                Frame_Remove_Sweeper e = new Frame_Remove_Sweeper();
                e.setResizable(false);
            } else if (ae.getActionCommand().equals("Update Sweeper")) {
                dispose();
                Frame_Update_Sweeper l = new Frame_Update_Sweeper();
                l.setResizable(false);
            } else if (ae.getActionCommand().equals("Display all Sweepers")) {
                JFrame jf = new JFrame();
                Display_Sweepers t = new Display_Sweepers();
                jf.setTitle("Cooks Data");
                jf.setSize(1920, 1080);
                jf.setVisible(true);
                jf.setResizable(false);
            //    jf.setResizable(true);
                jf.add(t);
            } else if (ae.getActionCommand().equals("Pay to Sweeper")) {
                dispose();
                Frame_Pay_Sweeper a = new Frame_Pay_Sweeper();
                a.setResizable(false);
               // a.setResizable(true);
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Manage_Staff a = new Frame_Manage_Staff();
                a.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Sweeper l = new Frame_Sweeper();
        l.setResizable(false);
    //    l.setResizable(true);
    }
}
