package com.haroy.bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class PinChange extends JFrame implements ActionListener{
    
    String pin;
    JButton change, back;
    JPasswordField newPin1, newPin2;
    
    public PinChange(String pin){
        this.pin = pin;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com\\haroy\\icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel label = new JLabel("Change Your Pin");
        label.setForeground(Color.white);
        label.setFont(new Font("system", Font.BOLD, 16));
        label.setBounds(250, 280, 500, 35);
        image.add(label);

        JLabel pinText1 = new JLabel("New Pin:");
        pinText1.setForeground(Color.white);
        pinText1.setFont(new Font("system", Font.BOLD, 16));
        pinText1.setBounds(165, 320, 180, 25);
        image.add(pinText1);

        newPin1  = new JPasswordField(4);
        newPin1.setFont(new Font("Raleway", Font.BOLD, 16));
        newPin1.setBounds(330, 320, 180, 25);
        image.add(newPin1);


        JLabel pinText2 = new JLabel("Re-Enter New Pin:");
        pinText2.setForeground(Color.white);
        pinText2.setFont(new Font("system", Font.BOLD, 16));
        pinText2.setBounds(165, 360, 180, 25);
        image.add(pinText2);

        newPin2  = new JPasswordField(4);
        newPin2.setFont(new Font("Raleway", Font.BOLD, 16));
        newPin2.setBounds(330, 360, 180, 25);
        image.add(newPin2);

        change = new JButton("Change");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setLocation(300, 0);
        setSize(900, 900);
        setVisible(true);

    }

    public static void main(String[] args) {
        new PinChange("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == change){
            String pin1 = newPin1.getText().toString();
            String pin2 = newPin2.getText().toString();

            if(pin1.equals(pin2)){

                if(pin1.equals("")){
                    JOptionPane.showMessageDialog(null, "Please enter Pin");
                    return;
                }

               
    

                try {

                    Conn c = new Conn();
                    String q1 = "update bank set pin = '"+pin1+"' where pin = '"+pin+"' ";
                    String q2 = "update login set pin = '"+ pin1 +"' where pin = '"+ pin +"'";
                    String q3 = "update signupthree set pinno = '"+ pin1 +"' where pinno = '"+ pin +"'";
                    c.s.executeUpdate(q1);
                    c.s.executeUpdate(q2);
                    c.s.executeUpdate(q3);

                    setVisible(false);
                    new Transactions(pin1).setVisible(true);

                } catch (Exception exception) {

                    System.out.println(exception.getMessage());

                }
                

                JOptionPane.showMessageDialog(null, "Pin changed successfully");

            }
            else{
                JOptionPane.showMessageDialog(null,"The re-entered pin does not match.");
            }
            
    
        }
        else{
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }
}