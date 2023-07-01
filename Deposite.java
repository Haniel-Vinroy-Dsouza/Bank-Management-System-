package com.haroy.bankmanagementsystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposite extends JFrame implements ActionListener{

    JTextField amount;
    JButton deposite, back;
    String pinNumber;

    Deposite(String pinNumber){

        this.pinNumber = pinNumber;

        ImageIcon i1 = new ImageIcon("com\\haroy\\icons\\atm.jpg");
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel l1 = new JLabel("Enter the Amount you want to deposite:");
        l1.setForeground(Color.white);
        l1.setFont(new Font("System", Font.BOLD, 16));
        l1.setBounds(170, 300, 400, 20);
        image.add(l1);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 18));
        amount.setBounds(170, 350, 300, 25);
        image.add(amount);

        deposite = new JButton("Deposite");
        deposite.setBounds(355, 485, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setLayout(null);
        setLocation(300, 0);
        setSize(900, 900);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Deposite("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == back){
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(e.getSource() == deposite){
            String a = amount.getText();
            if(a.equals("")){
                JOptionPane.showMessageDialog(null, "Error Invalid: Enter Valid Amonunt");
            }
            else{
                Date date = new Date();
                String type = "Deposite";
                String query = "insert into bank values('"+ pinNumber +"', '"+ date +"', '"+ type +"', '"+ a +"')";

                try{

                    Conn c = new Conn();
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs. " + a + " deposite.");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);

                }catch(Exception expection){
                    System.out.println(expection);
                }
            }
             

        }
    }
}
