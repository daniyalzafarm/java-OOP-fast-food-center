package Classes.Frames;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame_Manage_Items extends JFrame {

    JPanel main_panel, p1, p2, p3, p4, p5, p6, p7, p8, p9;
    JButton b1, b2, b3, b4, b5;
    JLabel l1, l2;

    public Frame_Manage_Items() throws HeadlessException {
        super("Manage Persons");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocation(500, 150);
        setVisible(true);

        
        //main_panel = new JPanel(new GridLayout(6,1));
        p1 = new JPanel(new GridLayout(6, 1));
        add(p1, BorderLayout.CENTER);

        p2 = new JPanel(new FlowLayout());
        p1.add(p2);

        l1 = new JLabel("Manage Items");
        Font f1 = new Font("Serif", Font.BOLD, 70);
        l1.setFont(f1);
        p2.add(l1);

        p4 = new JPanel(new FlowLayout());
        p1.add(p4);
        b1 = new JButton("Button 1");
        b1.setSize(100, 20);
        b1.setText("Manage Items");
        p4.add(b1);

        p5 = new JPanel(new FlowLayout());
        p1.add(p5);
        b2 = new JButton("Button 1");
        p5.add(b2);

        p6 = new JPanel(new FlowLayout());
        p1.add(p6);
        b3 = new JButton("Button 1");
        p6.add(b3);

        p7 = new JPanel(new FlowLayout());
        p1.add(p7);
        b4 = new JButton("Button 1");
        p7.add(b4);

        p8 = new JPanel(new FlowLayout());
        p1.add(p8);
        b5 = new JButton("Button 1");
        p8.add(b5);
    }

    public static void main(String[] args) {
        Frame_Manage_Items p1 = new Frame_Manage_Items();
        p1.setResizable(false);
    }
}
