package Classes.Frames;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame_Main extends JFrame{

    JPanel p1;
    JLabel l1;
    public Frame_Main() throws HeadlessException {
        super("Fast Food Corner");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 800);
        setLocation(500, 150);
        setVisible(true);
        p1=new JPanel(new BorderLayout());
        add(p1,BorderLayout.CENTER);
        
        
    }
    
    public static void main(String[] args) {
        Frame_Main m=new Frame_Main();
        m.setResizable(false);
        m.setResizable(true);
    }
    
}
