package ClassesFrames;

import static ClassesFrames.Generic_Methods.readAllData;
import Exceptions.Exception_Category;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Frame_Add_Item extends JFrame {

    JPanel p1;
    JButton b1, back;
    JTextField id, name, p;
    JRadioButton r1, r2, r3, r4;

    public Frame_Add_Item() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        // setLocation(500, 100);
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

        JLabel h = new JLabel("Add Item");
        h.setFont(f1);
        h.setForeground(new Color(225, 222, 173));
        h.setBounds(200, 25, 400, 50);
        light.add(h);

        background.add(light);
//Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 280, 400, 600);
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

        ImageIcon add=new ImageIcon("add item.png");
        JButton b1 = new JButton("Add",add);
        b1.setFont(f2);
        b1.setBounds(100, 520, 200, 50);
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
        back.addActionListener(a);
        r1.addActionListener(a);
        r2.addActionListener(a);
        r3.addActionListener(a);
//        r4.addActionListener(a);
//Generate ID
        String ID = generateId("Items.ser");
        if (ID != null) {
            id.setText(ID);
        } else {
            id.setText("ITEM-1");
        }
        id.setEditable(false);
    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (ae.getActionCommand().equals("Add")) {
                try {
                    if (r1.isSelected() || r2.isSelected() || r3.isSelected() || r4.isSelected()) {
                        Class_Items item;
                        Class_Items_Pizza pizza;
                        Class_Items_burger_shawarma burger;
                        Class_Items_French_Fries fries;
                        String categ = null;
                        if (r1.isSelected()) {
                            categ = r1.getText();
                            pizza = new Class_Items_Pizza(id.getText(), name.getText(), Double.parseDouble(p.getText()), categ, "small");
                            Generic_Methods.writeObjectToFile(pizza, "Items.ser");
                        } else if (r2.isSelected()) {
                            categ = r2.getText();
                            burger = new Class_Items_burger_shawarma(id.getText(), name.getText(), Double.parseDouble(p.getText()), categ);
                            Generic_Methods.writeObjectToFile(burger, "Items.ser");
                        } else if (r3.isSelected()) {
                            categ = r3.getText();
                            fries = new Class_Items_French_Fries(id.getText(), name.getText(), Double.parseDouble(p.getText()), categ, "small");
                            Generic_Methods.writeObjectToFile(fries, "Items.ser");
                        } else if (r4.isSelected()) {
                            categ = r4.getText();
                            item = new Class_Items(id.getText(), name.getText(), Double.parseDouble(p.getText()), categ);
                            Generic_Methods.writeObjectToFile(item, "Items.ser");
                        }
                        JOptionPane.showMessageDialog(new JFrame(), (name.getText() + "\nNew Item Added Successfully!\nPlease Rememember Item Id : " + id.getText()));
                        dispose();
                        Frame_Manage_Items m = new Frame_Manage_Items();
                        m.setResizable(false);
                    } else {
                        throw new Exception_Category();
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
            } else if (ae.getActionCommand().equals("Back")) {
                dispose();
                Frame_Manage_Items s = new Frame_Manage_Items();
                s.setResizable(false);
            }
        }
    }

    public static String generateId(String filename) {
        ArrayList<Class_Items> list = readAllData(filename);
        String final_id = null;
        if (!list.isEmpty()) {
            Class_Items last = list.get(list.size() - 1);
            String Id = last.getId();
            String[] arr = Id.split("-");
            int num = Integer.parseInt(arr[1]);
            num++;
            final_id = arr[0] + "-" + String.valueOf(num);
        }
        return final_id;
    }

    public static void main(String[] args) {
        Frame_Add_Item l = new Frame_Add_Item();
        l.setResizable(false);
    //    l.setResizable(true);
    }

}
