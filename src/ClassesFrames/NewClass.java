/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ClassesFrames;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author DANIYAL ZAFAR
 */
public class NewClass extends JFrame{

    public NewClass() {
    setLayout(new BorderLayout());

        JLabel enterYourName = new JLabel("Enter Your Name Here:");
        JTextField textBoxToEnterName = new JTextField(21);
        JPanel panelTop = new JPanel();
        panelTop.add(enterYourName);
        panelTop.add(textBoxToEnterName);

        JButton submit = new JButton("Submit");
        submit.addActionListener(new SubmitButton(textBoxToEnterName));
        submit.addKeyListener(new SubmitButton(textBoxToEnterName));
        JPanel panelBottom = new JPanel();
        panelBottom.add(submit);

        //Add panelTop to JFrame
        add(panelTop, BorderLayout.NORTH);
        add(panelBottom, BorderLayout.SOUTH);

        //JFrame set-up
        setTitle("Name Prompt Program");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

    }
    public class SubmitButton implements ActionListener, KeyListener {

    JTextField nameInput;


    public SubmitButton(JTextField textfield){
        nameInput = textfield;
    }

    @Override
    public void actionPerformed(ActionEvent submitClicked) {

        Component frame = new JFrame();
        JOptionPane.showMessageDialog(frame , "You've Submitted the name " + nameInput.getText());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ENTER){
            System.out.println("Hello");
        }
        Component frame = new JFrame();
        JOptionPane.showMessageDialog(frame , "You've Submitted the name " + nameInput.getText());

    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }
}

    
    
    public static void main(String[] args) {
        
        
        NewClass a=new NewClass();
        a.setVisible(true);
        
        
//        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
//        Date date=new Date();
//        String[] arr=sdf.format(date).split("/");
//        System.out.println(sdf.format(date));
//        ArrayList<Class_Items> list=Generic_Methods.readAllData("Items.ser");
//        for (Class_Items i: list) {
//            if(i.getCategory().equalsIgnoreCase("Pizza")){
//            Class_Items_Pizza pz=(Class_Items_Pizza) i;
//                pz.setQuantity(5);
//                pz.setSize("small");
//                System.out.println("Bill: "+pz.calAmount()*pz.getQuantity());
//            }
//        }
        
    }
}
