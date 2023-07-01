package com.haroy.bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


public class Transactions extends JFrame implements ActionListener{

    JButton deposite, withdrawal, ministatement, balanceenquiry, exit, fastcash, pinchange;
    String pin;

    public Transactions(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com\\haroy\\icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please select your Transactions");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("Deposite");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Fast Cash");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        ministatement = new JButton("Mini Statement");
        ministatement.setBounds(355, 450, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);
        
        pinchange = new JButton("Pin Change");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        balanceenquiry = new JButton("Balance Enquire");
        balanceenquiry.setBounds(355, 485, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);

        exit = new JButton("Exit");
        exit.setBounds(355, 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setLayout(null);
        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == exit){
            System.exit(0);
        }
        else if(e.getSource() == deposite){
            setVisible(false);
            new Deposite(pin).setVisible(true);
        }
        else if(e.getSource() == withdrawal){
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }
        else if(e.getSource() == fastcash){
            setVisible(false);
            new FastCash(pin).setVisible(true);
        }
        else if(e.getSource() == pinchange){
            setVisible(false);
            new PinChange(pin).setVisible(true);
        }
        else if(e.getSource() == balanceenquiry){
            setVisible(false);
            new BalanceEnquiry(pin).setVisible(true);
        }
        else if(e.getSource() == ministatement){
            new MiniStatement(pin).setVisible(true);
        }
    }
   
    public static void main(String[] args) {
        new Transactions("");
    }
}