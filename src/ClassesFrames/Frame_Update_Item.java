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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Frame_Update_Item extends JFrame {

    JPanel p1;
    JButton b1, back, b2;
    JTextField id, name, p;
    JRadioButton r1, r2, r3, r4;

    public Frame_Update_Item() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        //    setLocation(500, 100);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("Item3.jpg");

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

        JLabel h = new JLabel("Update Item");
        h.setFont(f1);
        h.setForeground(new Color(225, 222, 173));
        h.setBounds(200, 25, 400, 50);
        light.add(h);

        background.add(light);
// Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 250, 400, 700);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

//Information
        JLabel l1 = new JLabel("Enter Id ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 310, 100, 30);
        p1.add(l1);
        id = new JTextField();
        id.setFont(f2);
        id.setBounds(150, 310, 220, 30);
        id.setBackground(new Color(225, 222, 173));
        p1.add(id);

        JLabel l2 = new JLabel("Name ");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 385, 100, 30);
        p1.add(l2);
        name = new JTextField();
        name.setFont(f2);
        name.setBounds(150, 385, 220, 30);
        name.setBackground(new Color(225, 222, 173));
        p1.add(name);

        JLabel l3 = new JLabel("Price ");
        l3.setFont(f2);
        l3.setForeground(new Color(225, 222, 173));
        l3.setBounds(30, 460, 100, 30);
        p1.add(l3);
        p = new JTextField();
        p.setFont(f2);
        p.setBounds(150, 460, 220, 30);
        p.setBackground(new Color(225, 222, 173));
        p1.add(p);

//Category
        JLabel l4 = new JLabel("Category : ");
        l4.setFont(f2);
        l4.setForeground(new Color(225, 222, 173));
        l4.setBounds(30, 70, 150, 30);
        p1.add(l4);

        r1 = new JRadioButton("Pizza", false);
        r1.setFont(f2);
        r1.setBackground(new Color(225, 222, 173));
        r1.setBounds(30, 120, 100, 25);
        p1.add(r1);

        r2 = new JRadioButton("Burger/Shawarma", false);
        r2.setFont(f2);
        r2.setBackground(new Color(225, 222, 173));
        r2.setBounds(30, 160, 230, 25);
        p1.add(r2);

        r3 = new JRadioButton("French Fries", false);
        r3.setFont(f2);
        r3.setBackground(new Color(225, 222, 173));
        r3.setBounds(30, 200, 230, 25);
        p1.add(r3);

        r4 = new JRadioButton("Other Items", false);
        r4.setFont(f2);
        r4.setBackground(new Color(225, 222, 173));
        r4.setBounds(30, 240, 230, 25);
        p1.add(r4);

        ButtonGroup g1 = new ButtonGroup();
        g1.add(r1);
        g1.add(r2);
        g1.add(r3);
        g1.add(r4);
//Buttons

        ImageIcon fetc=new ImageIcon("fetch.png");
        b1 = new JButton("Fetch Data",fetc);
        b1.setFont(f2);
        b1.setBounds(100, 530, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        ImageIcon update=new ImageIcon("update.png");
        b2 = new JButton("Update",update);
        b2.setFont(f2);
        b2.setBounds(100, 620, 200, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        ImageIcon back1=new ImageIcon("back.png");
        back = new JButton("Back",back1);
        back.setFont(f2);
        back.setBounds(30, 20, 150, 30);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        back.addActionListener(a);
        r1.addActionListener(a);
        r2.addActionListener(a);
        r3.addActionListener(a);

        r1.setEnabled(false);
        r2.setEnabled(false);
        r3.setEnabled(false);
        r4.setEnabled(false);
        name.setEnabled(false);
        p.setEnabled(false);
        b2.setEnabled(false);

        id.setText("ITEM-");
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Fetch Data")) {
                try {
                    if (Class_Items.searchById(id.getText()) != -1) {
                        ArrayList<Class_Items> list = Generic_Methods.readAllData("Items.ser");
                        int index = -1;
                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).getId().equalsIgnoreCase(id.getText())) {
                                index = i;
                                break;
                            }
                        }

                        id.setEditable(false);
                        r1.setEnabled(true);
                        r2.setEnabled(true);
                        r3.setEnabled(true);
                        r4.setEnabled(true);
                        name.setEnabled(true);
                        p.setEnabled(true);
                        b2.setEnabled(true);
                        b1.setEnabled(false);

                        if (list.get(index).getCategory().equalsIgnoreCase(r1.getText())) {
                            r1.setSelected(true);
                        } else if (list.get(index).getCategory().equalsIgnoreCase(r2.getText())) {
                            r2.setSelected(true);
                        } else if (list.get(index).getCategory().equalsIgnoreCase(r3.getText())) {
                            r3.setSelected(true);
                        } else if (list.get(index).getCategory().equalsIgnoreCase(r4.getText())) {
                            r4.setSelected(true);
                        }
                        name.setText(list.get(index).getName());
                        p.setText(String.valueOf(list.get(index).getPrice()));
                        b1.setEnabled(false);
                    } else {
                        throw new Exception_IdNotFound();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            } else if (ae.getActionCommand().equals("Update")) {
                ArrayList<Class_Items> list = Generic_Methods.readAllData("Items.ser");
                int index = -1;
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getId().equalsIgnoreCase(id.getText())) {
                        index = i;
                        break;
                    }
                }
                String c = null;
                if (r1.isSelected()) {
                    c = r1.getText();
                } else if (r2.isSelected()) {
                    c = r2.getText();
                } else if (r3.isSelected()) {
                    c = r3.getText();
                } else if (r4.isSelected()) {
                    c = r4.getText();
                }
                list.get(index).setCategory(c);
                list.get(index).setName(name.getText());
                list.get(index).setPrice(Double.parseDouble(p.getText()));

                ObjectOutputStream outputStream = null;
                try {
                    outputStream = new ObjectOutputStream(new FileOutputStream("Items.ser"));
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
                JOptionPane.showMessageDialog(new JFrame(), list.get(index).getName() + " Updated SuccessFully!");
                dispose();
                Frame_Manage_Items m1 = new Frame_Manage_Items();
                m1.setResizable(false);
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Manage_Items s = new Frame_Manage_Items();
                s.setResizable(false);
            }
        }
    }

    public static void main(String[] args) {
        Frame_Update_Item l = new Frame_Update_Item();
        l.setResizable(false);
        //    l.setResizable(true);
    }

}
