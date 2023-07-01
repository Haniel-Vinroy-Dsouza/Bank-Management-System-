package com.haroy.bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.*;

public class BalanceEnquiry extends JFrame implements ActionListener {

    JButton back;
    String pin ;

    public BalanceEnquiry(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com\\haroy\\icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);


        int balance = 0;
        Conn c = new Conn();

        try {
            ResultSet rs = c.s.executeQuery("Select * from bank where pin ='"+ pin +"'");

            while(rs.next()){
                if(rs.getString("type").equals("Deposite")){
                    balance += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance -= Integer.parseInt(rs.getString("amount"));
                } 
            }
        }catch(Exception exception){
            System.out.println(exception);
        }
        
        JLabel l1 = new JLabel("Your current account balance is Rs." + balance);
        l1.setForeground(Color.white);
        l1.setBounds(170, 300, 400, 30);
        image.add(l1);

        setUndecorated(true);
        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);

    }
    
    public static void main(String[] args) {
        new BalanceEnquiry("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);
        new Transactions(pin).setVisible(true);

    }
}

