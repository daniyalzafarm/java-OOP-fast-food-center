package ClassesFrames;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
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

public class Frame_Buy_Items extends JFrame {

    JPanel p1;
    JButton b1, b2, b3, b4, b5, back;
    JTextField id, quan, size, price;

    public Frame_Buy_Items() throws HeadlessException {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1920, 1080);
        //  setLocation(500, 100);
        setVisible(true);

//Font
        Font f1 = new Font("Serif", Font.BOLD, 80);
        Font f2 = new Font("Serif", Font.BOLD, 23);
//Background
        ImageIcon background_image = new ImageIcon("Item5.jpg");

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

        JLabel h = new JLabel("Buy Item");
        h.setFont(f1);
        h.setForeground(new Color(225, 222, 173));
        h.setBounds(200, 25, 400, 50);
        light.add(h);

        background.add(light);
// Background
        p1 = new JPanel();
        background.add(p1);
        p1.setBounds(750, 310, 400, 610);
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 0, 220));

//Information
        JLabel l1 = new JLabel("Enter Id ");
        l1.setFont(f2);
        l1.setForeground(new Color(225, 222, 173));
        l1.setBounds(30, 75, 100, 30);
        p1.add(l1);
        id = new JTextField();
        id.setFont(f2);
        id.setBounds(150, 75, 220, 30);
        id.setBackground(new Color(225, 222, 173));
        p1.add(id);

        JLabel l2 = new JLabel("Quantity ");
        l2.setFont(f2);
        l2.setForeground(new Color(225, 222, 173));
        l2.setBounds(30, 150, 100, 30);
        p1.add(l2);
        quan = new JTextField();
        quan.setFont(f2);
        quan.setBounds(150, 150, 220, 30);
        quan.setBackground(new Color(225, 222, 173));
        p1.add(quan);

//Buttons
        ImageIcon cart = new ImageIcon("cart.png");
        b1 = new JButton("Add to Cart", cart);
        b1.setFont(f2);
        b1.setBounds(100, 220, 200, 50);
        b1.setBackground(new Color(225, 222, 173));
        p1.add(b1);

        ImageIcon display = new ImageIcon("display.png");
        b2 = new JButton("Display Cart", display);
        b2.setFont(f2);
        b2.setBounds(100, 300, 200, 50);
        b2.setBackground(new Color(225, 222, 173));
        p1.add(b2);

        ImageIcon pay = new ImageIcon("pay.png");
        b3 = new JButton("Checkout", pay);
        b3.setFont(f2);
        b3.setBounds(100, 380, 200, 50);
        b3.setBackground(new Color(225, 222, 173));
        p1.add(b3);

        ImageIcon clear = new ImageIcon("clear.png");
        b4 = new JButton("Clear Cart", clear);
        b4.setFont(f2);
        b4.setBounds(100, 460, 200, 50);
        b4.setBackground(new Color(225, 222, 173));
        p1.add(b4);

        ImageIcon item = new ImageIcon("display.png");
        b5 = new JButton("All Items", item);
        b5.setFont(f2);
        b5.setBounds(100, 540, 200, 50);
        b5.setBackground(new Color(225, 222, 173));
        p1.add(b5);

        ImageIcon back1 = new ImageIcon("back.png");
        back = new JButton("Back", back1);
        back.setFont(f2);
        back.setBounds(30, 20, 150, 30);
        back.setBackground(new Color(225, 222, 173));
        p1.add(back);

        Listner a = new Listner();
        b1.addActionListener(a);
        b2.addActionListener(a);
        b3.addActionListener(a);
        b4.addActionListener(a);
        b5.addActionListener(a);
        back.addActionListener(a);

        ArrayList<Class_Cart> arr = Generic_Methods.readAllData("Cart.ser");
        if (arr.isEmpty()) {
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
        }
        id.setText("Item-");

    }

    class Listner implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            try {
                if (ae.getActionCommand().equalsIgnoreCase("Add to Cart")) {
                    if (checkId(id.getText())) {
                        if (checkIdinCart(id.getText(), "Cart.ser") != -1) {
                            JOptionPane.showMessageDialog(new JFrame(), "Item already in cart");

                            ArrayList<Class_Items> list = Generic_Methods.readAllData("Cart.ser");

                            int index = checkIdinCart(id.getText(), "Cart.ser");
                            String q = JOptionPane.showInputDialog("Enter quantity to add in existing quantity : ");
                            Class_Items i = list.get(index);
                            double price = i.getPrice() / i.getQuantity();
                            i.setQuantity(Integer.parseInt(q) + list.get(index).getQuantity());
                            i.setPrice(price * i.getQuantity());
                            ObjectOutputStream outputStream = null;
                            try {
                                outputStream = new ObjectOutputStream(new FileOutputStream("Cart.ser"));
                                for (int x = 0; x < list.size(); x++) {
                                    outputStream.writeObject(list.get(x));
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
                            JOptionPane.showMessageDialog(new JFrame(), "Quantity Updated!\nName : "
                                    + list.get(index).getName() + "\nQuantity : " + list.get(index).getQuantity());
                        } else {
                            ArrayList<Class_Items> list = Generic_Methods.readAllData("Items.ser");

                            int quantity = Integer.parseInt(quan.getText());
                            if (list != null) {

                                for (Class_Items i : list) {
                                    if (id.getText().equalsIgnoreCase(i.getId())) {
                                        if (i.getCategory().equalsIgnoreCase("Pizza")) {
                                            i.setQuantity(quantity);
                                            Class_Items_Pizza newObject = (Class_Items_Pizza) i;
                                            String s = JOptionPane.showInputDialog(new JFrame(), "Enter Pizza Size Small | Medium | Large");
                                            newObject.setSize(s);
                                            newObject.setPrice(newObject.calAmount(s) * quantity);
                                        } else if (i.getCategory().equalsIgnoreCase("French Fries")) {
                                            i.setQuantity(quantity);
                                            Class_Items_French_Fries newObject = (Class_Items_French_Fries) i;
                                            String s = JOptionPane.showInputDialog(new JFrame(), "Enter Fries Size Small | Medium | Large");
                                            newObject.setSize(s);
                                            newObject.setPrice(newObject.calCost(s) * quantity);
                                        } else if (i.getCategory().equalsIgnoreCase("Burger/Shawarma")) {
                                            Class_Items_burger_shawarma newObject = (Class_Items_burger_shawarma) i;
                                            newObject.setQuantity(quantity);
                                            newObject.setPrice(newObject.calCOST() * quantity);
                                        } else if (i.getCategory().equalsIgnoreCase("Other Items")) {
                                            i.setQuantity(quantity);
                                            i.setPrice(i.calCOST() * quantity);
                                        }
                                        Generic_Methods.writeObjectToFile(i, "Cart.ser");
                                        JOptionPane.showMessageDialog(new JFrame(), i.getName() + " Added in cart");
                                        b2.setEnabled(true);
                                        b3.setEnabled(true);
                                        b4.setEnabled(true);
                                        id.setText("Item-");
                                        quan.setText("");
                                        break;
                                    }
                                }
                            } else {
                                JOptionPane.showMessageDialog(new JFrame(), "No Item in shop!");
                            }
                        }

                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "Invalid Id");
                        id.setText("");
                    }
                } else if (ae.getActionCommand().equals("Display Cart")) {
                    JFrame jf = new JFrame();
                    Display_Cart t = new Display_Cart();
                    jf.setTitle("Items in Cart");
                    jf.setSize(1920, 1080);
                    jf.setVisible(true);
                    jf.add(t);
                } else if (ae.getActionCommand().equals("Checkout")) {
                    dispose();
                    Frame_Checkout c = new Frame_Checkout();
                    c.setResizable(false);
                } else if (ae.getActionCommand().equals("Clear Cart")) {
                    Generic_Methods.flushFile("Cart.ser");
                    b2.setEnabled(false);
                    b3.setEnabled(false);
                    b4.setEnabled(false);
                    JOptionPane.showMessageDialog(new JFrame(), "Cart Cleared!");
                } else if (ae.getActionCommand().equals("All Items")) {
                    Display_Items table = new Display_Items();
                    JFrame frame = new JFrame();
                    frame.setTitle("Available Items");
                    frame.setSize(1920, 1080);
                    frame.setBackground(new Color(225, 222, 173));
                    frame.setVisible(true);
                    frame.setResizable(false);
                    frame.setResizable(true);
                    frame.add(table);
                } else if (ae.getActionCommand().equals("Back")) {
                    dispose();
                    Frame_Admin s = new Frame_Admin();
                    s.setResizable(false);
                    //    s.setResizable(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(new JFrame(), e.getMessage());
            }
        }
    }

    public static int checkIdinCart(String id, String filename) {
        int a = -1;
        File file = new File(filename);
        if (file.exists()) {
            ArrayList<Class_Items> list = Generic_Methods.readAllData(filename);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getId().equalsIgnoreCase(id)) {
                    a = i;
                    break;
                }
            }
        }
        return a;
    }

    public static boolean checkId(String id) {

        if ((id.startsWith("ITEM-") || id.startsWith("Item-") || id.startsWith("item-")) && id.length() <= 7) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Frame_Buy_Items l = new Frame_Buy_Items();
        l.setResizable(false);
        //     l.setResizable(true);
    }

}
