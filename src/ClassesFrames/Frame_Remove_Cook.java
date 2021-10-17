package ClassesFrames;

import Exceptions.Exception_IdNotFound;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Frame_Remove_Cook extends JFrame {

    JPanel p1, p2;
    JButton b1,back;
    JTextField t1;

    public Frame_Remove_Cook() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
       // setLocation(500, 100);
        setVisible(true);
        
//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);        
//Background
        ImageIcon background_image = new ImageIcon("cook.jpg");

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

        JLabel l3 = new JLabel("Remove Cook");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 350, 400, 350);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        JLabel l1 = new JLabel("Enter Id ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 100, 100, 30);
        p1.add(l1);
        t1 = new JTextField();
        t1.setFont(f2);
        t1.setBounds(150, 100, 220, 30);
        t1.setBackground(new Color(225, 222, 173));
        p1.add(t1);
        
        ImageIcon remove=new ImageIcon("remove user.png");
        JButton b1 = new JButton("Remove",remove);
        b1.setFont(f2);
        b1.setBounds(100, 200, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

//Back Button
        ImageIcon back1=new ImageIcon("back.png");
        back = new JButton("Back",back1);
        back.setFont(f2);
        back.setBounds(100, 280, 200, 50);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);
        
        Listner a = new Listner();
        b1.addActionListener(a);
        back.addActionListener(a);
        t1.setText("CK-");
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Remove")) {
                try {
                    ArrayList<Class_Persons_Cook> list = Generic_Methods.readAllData("Cook.ser");
                    if (!list.isEmpty()) {
                        int index = -1;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId().equalsIgnoreCase(t1.getText())) {
                                index = i;
                                break;
                            }
                        }
                        if (index != -1) {
                            JOptionPane.showMessageDialog(new JFrame(), list.get(index).getName() + " Removed Successfully!");
                            list.remove(index);
                            ObjectOutputStream outputStream = null;
                            try {
                                outputStream = new ObjectOutputStream(new FileOutputStream("Cook.ser"));
                                outputStream.flush();
                                for (int i = 0; i < list.size(); i++) {
                                    outputStream.writeObject(list.get(i));
                                }
                            } catch (IOException exp) {
                                System.out.println("IO Exception while opening file");
                            } finally {
                                try {
                                    if (outputStream != null) {
                                        outputStream.close();
                                    }
                                } catch (IOException exp) {
                                    System.out.println("IO Exception while closing file");
                                }
                            }
                        } else {
                            throw new Exception_IdNotFound();
                        }
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "No Cook in Record!");
                        dispose();
                        Frame_Cook s1 = new Frame_Cook();
                        s1.setResizable(false);
                    }
                } catch (Exception_IdNotFound ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Cook s = new Frame_Cook();
                s.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Remove_Cook l = new Frame_Remove_Cook();
        l.setResizable(false);
    //    l.setResizable(true);
    }

}
