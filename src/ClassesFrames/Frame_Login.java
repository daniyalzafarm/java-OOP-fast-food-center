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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Frame_Login extends JFrame {

    JPanel p1, p2;
    JButton b1;
    JTextField username;
    JPasswordField password;

    public Frame_Login() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        //setLocation(500, 100);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("login1.jpg");

        Image image = background_image.getImage();
        Image temp_image = image.getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_image);

        JLabel background = new JLabel(" ", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1920, 1080);
        add(background);

//Heading
        JPanel light = new JPanel();
        light.setBackground(new Color(0, 0, 0, 230));
        light.setBounds(0, 0, 1920, 120);

        JLabel l3 = new JLabel("Fast Food Corner");
        l3.setFont(f1);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(200, 25, 400, 50);
        light.add(l3);

        background.add(light);
//Login Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 350, 400, 350);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 230));

        Font log = new Font("Serif", Font.BOLD, 30);
        JLabel login = new JLabel("LOG IN");
        login.setBounds(145, 10, 150, 50);
        login.setForeground(new Color(225, 222, 173));
        login.setFont(log);
        p1.add(login);

        JLabel l1 = new JLabel("Username");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 100, 120, 30);
        p1.add(l1);
        username = new JTextField();
        username.setFont(f2);
        username.setBounds(160, 100, 210, 30);
        username.setBackground(new Color(225, 222, 173));
        p1.add(username);

        JLabel l2 = new JLabel("Password");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 180, 100, 30);
        p1.add(l2);
        password = new JPasswordField();
        password.setFont(f2);
        password.setBounds(160, 180, 210, 30);
        password.setBackground(new Color(225, 222, 173));
        p1.add(password);

        JButton b1 = new JButton("Sign In");
        b1.setFont(f2);
        b1.setBounds(125, 260, 150, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        Listner a = new Listner();
        b1.addActionListener(a);

    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getActionCommand().equals("Sign In")) {
                File file = new File("Password.ser");
                if (file.exists()) {
                    ArrayList<Class_Login_Info> list = Generic_Methods.readAllData("Password.ser");
                    if (username.getText().equals(list.get(0).getUsername()) && password.getText().equals(list.get(0).getPassword())) {
                        dispose();
                        Frame_Admin a = new Frame_Admin();
                        a.setResizable(false);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Username or Password!");
                    }
                } else {
                    if (username.getText().equals("admin") && password.getText().equals("admin")) {
                        dispose();
                        Frame_Admin a = new Frame_Admin();
                        a.setResizable(false);
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Username or Password!");
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Frame_Login l = new Frame_Login();
        l.setResizable(false);
    //    l.setResizable(true);
    }

}
