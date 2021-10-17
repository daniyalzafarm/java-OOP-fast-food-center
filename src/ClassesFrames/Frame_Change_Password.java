package ClassesFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame_Change_Password extends JFrame {

    JPanel p1;
    JButton b1, back, pay;
    JTextField t1, t3;
    JPasswordField t2, t4, t5;

    public Frame_Change_Password() throws HeadlessException {
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
        ImageIcon background_image = new ImageIcon("pass.jpg");

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

        JLabel header = new JLabel("Change Password");
        header.setFont(f1);
        header.setForeground(new Color(225, 222, 173));
        header.setBounds(200, 25, 400, 50);
        light.add(header);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(720, 330, 500, 550);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

        JLabel l1 = new JLabel("Current Username ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 80, 200, 30);
        p1.add(l1);
        t1 = new JTextField();
        t1.setFont(f2);
        t1.setBounds(250, 80, 220, 30);
        t1.setBackground(new Color(225, 222, 173));
        p1.add(t1);

        JLabel l2 = new JLabel("Current Password ");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 150, 200, 30);
        p1.add(l2);
        t2 = new JPasswordField();
        t2.setFont(f2);
        t2.setBounds(250, 150, 220, 30);
        t2.setBackground(new Color(225, 222, 173));
        p1.add(t2);

        JLabel l3 = new JLabel("New Username ");
        l3.setFont(f2);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(30, 220, 200, 30);
        p1.add(l3);
        t3 = new JTextField();
        t3.setFont(f2);
        t3.setBounds(250, 220, 220, 30);
        t3.setBackground(new Color(225, 222, 173));
        p1.add(t3);

        JLabel l4 = new JLabel("New Password ");
        l4.setFont(f2);
        l4.setForeground(new Color(225, 222, 173));
        l4.setBounds(30, 290, 200, 30);
        p1.add(l4);
        t4 = new JPasswordField();
        t4.setFont(f2);
        t4.setBounds(250, 290, 220, 30);
        t4.setBackground(new Color(225, 222, 173));
        p1.add(t4);

        JLabel l5 = new JLabel("Re-type Password ");
        l5.setFont(f2);
        l5.setForeground(new Color(225, 222, 173));
        l5.setBounds(30, 360, 200, 30);
        p1.add(l5);
        t5 = new JPasswordField();
        t5.setFont(f2);
        t5.setBounds(250, 360, 220, 30);
        t5.setBackground(new Color(225, 222, 173));
        p1.add(t5);

        ImageIcon submit=new ImageIcon("submit.png");
        JButton b1 = new JButton("Submit",submit);
        b1.setFont(f2);
        b1.setBounds(150, 450, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        ImageIcon back1=new ImageIcon("back.png");
        back = new JButton("Back",back1);
        back.setFont(f2);
        back.setBounds(30, 20, 150, 30);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);

        Listner a = new Listner();
        b1.addActionListener(a);
//        pay.addActionListener(a);
        back.addActionListener(a);

        File file = new File("Password.ser");
        if (!file.exists()) {
        t1.setText("admin");
        t1.setEditable(false);
        t2.setText("admin");
        t2.setEditable(false);
        }
        }

        class Listner implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent ae) {
                try {
                    File file = new File("Password.ser");
                    if (ae.getActionCommand().equals("Submit")) {
                        if (file.exists()) {
                            ArrayList<Class_Login_Info> list = Generic_Methods.readAllData("Password.ser");
                            if (t1.getText().equals(list.get(0).getUsername()) && t2.getText().equals(list.get(0).getPassword())) {
                                if (t4.getText().equals(t5.getText())) {
                                    Generic_Methods.flushFile("Password.ser");
                                    Class_Login_Info newlogin = new Class_Login_Info(t3.getText(), t4.getText());
                                    Generic_Methods.writeObjectToFile(newlogin, "Password.ser");
                                    JOptionPane.showMessageDialog(new JFrame(), "Password Changed Successfully!");
                                } else {
                                    JOptionPane.showMessageDialog(new JFrame(), "New Passwords does not match!");
                                }
                            } else {
                                JOptionPane.showMessageDialog(new JFrame(), "Current Username or Password is Wrong!");
                            }
                        } else {
                            if (t4.getText().equals(t5.getText())) {
                                Generic_Methods.flushFile("Password.ser");
                                Class_Login_Info newlogin = new Class_Login_Info(t3.getText(), t4.getText());
                                Generic_Methods.writeObjectToFile(newlogin, "Password.ser");
                                JOptionPane.showMessageDialog(new JFrame(), "Password Changed Successfully!");
                            } else {
                                JOptionPane.showMessageDialog(new JFrame(), "New Passwords does not match!");
                            }
                        }
                        if (t2.getText().equalsIgnoreCase(t3.getText())) {
                        }
                    } else if (ae.getActionCommand().equals("Back")) {
                        dispose();
                        Frame_Admin s = new Frame_Admin();
                        s.setResizable(false);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            }
        }

    

    public static void main(String[] args) {
        Frame_Change_Password l = new Frame_Change_Password();
        l.setResizable(false);
        //   l.setResizable(true);
    }

}
