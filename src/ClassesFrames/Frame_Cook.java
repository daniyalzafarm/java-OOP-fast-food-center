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

public class Frame_Cook extends JFrame {

    JPanel p1, p2;
    JButton b1, b2, b3, b4, b5,update;

    public Frame_Cook() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
      //  setLocation(500, 100);
        setVisible(true);

        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("Image2.jpg");

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

        JLabel l3 = new JLabel("Manage Cooks");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);

//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 250, 400, 645);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));


        b1 = new JButton("Add Cook");
        b1.setFont(f2);
        b1.setBounds(50, 50, 300, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        b2 = new JButton("Remove Cook");
        b2.setFont(f2);
        b2.setBounds(50, 150, 300, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        update = new JButton("Update Cook");
        update.setFont(f2);
        update.setBounds(50, 250, 300, 50);
        update.setBackground(new Color(225, 222, 173));
        p1.add(update);
        b3 = new JButton("Display all Cooks");
        b3.setFont(f2);
        b3.setBounds(50, 350, 300, 50);
        b3.setBackground(new Color(225, 222, 173));
        p1.add(b3);

        b4 = new JButton("Pay to Cook");
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
            if (ae.getActionCommand().equals("Add Cook")) {
                dispose();
                Frame_Add_Cook e = new Frame_Add_Cook();
                e.setResizable(false);
           //     e.setResizable(true);
            } else if (ae.getActionCommand().equals("Remove Cook")) {
                dispose();
                Frame_Remove_Cook e = new Frame_Remove_Cook();
                e.setResizable(false);
           //     e.setResizable(true);
            } else if (ae.getActionCommand().equals("Update Cook")) {
                dispose();
                Frame_Update_Cook e = new Frame_Update_Cook();
                e.setResizable(false);
           //     e.setResizable(true);
            } else if (ae.getActionCommand().equals("Display all Cooks")) {
                JFrame jf = new JFrame();
                Display_Cooks t = new Display_Cooks();
                jf.setTitle("Cooks Data");
                jf.setSize(1920, 1080);
                jf.setResizable(false);
           //     jf.setResizable(true);
                jf.setVisible(true);
                jf.add(t);
            } else if (ae.getActionCommand().equals("Pay to Cook")) {
                dispose();
                Frame_Pay_Cook a = new Frame_Pay_Cook();
                a.setResizable(false);
            //    a.setResizable(true);
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Manage_Staff a = new Frame_Manage_Staff();
                a.setResizable(false);
           //     a.setResizable(true);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Cook l = new Frame_Cook();
        l.setResizable(false);
     //   l.setResizable(true);
    }
}
