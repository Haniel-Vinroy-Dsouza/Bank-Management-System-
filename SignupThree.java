package com.haroy.bankmanagementsystem;

import javax.lang.model.util.ElementScanner14;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener{

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;

    SignupThree(String formno){

        this.formno = formno;

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type:");
        type.setFont(new Font("Raleway", Font.BOLD, 20));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.white);
        r1.setBounds(100, 180, 150, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.white);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.white);
        r3.setBounds(100, 220, 250, 20);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.white);
        r4.setBounds(350, 220, 250, 20);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1);
        buttonGroup.add(r2);
        buttonGroup.add(r3);
        buttonGroup.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 20));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-8142");
        number.setFont(new Font("Raleway", Font.BOLD, 20));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetails = new JLabel("This is your 16 digits card number.");
        carddetails.setFont(new Font("Raleway", Font.BOLD,12));
        carddetails.setBounds(100, 330, 300, 20);
        add(carddetails);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 20));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 20));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pindetails = new JLabel("This is your 4 digit pin number.");
        pindetails.setFont(new Font("Raleway", Font.BOLD,12));
        pindetails.setBounds(100, 400, 300, 20);
        add(pindetails);

        JLabel services = new JLabel("Service Required:");
        services.setFont(new Font("Raleway", Font.BOLD,20));
        services.setBounds(100, 450, 200, 30);
        add(services);

        c1 = new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.white);
        c1.setBounds(100, 500, 200, 30);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.white);
        c2.setBounds(350, 500, 200, 30);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.white);
        c3.setBounds(100, 550, 200, 30);
        add(c3);

        c4 = new JCheckBox("Email and SMS alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.white);
        c4.setBounds(350, 550, 200, 30);
        add(c4);

        c5 = new JCheckBox("Check Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.white);
        c5.setBounds(100, 600, 200, 30);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.white);
        c6.setBounds(350, 600, 200, 30);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBounds(100, 640, 520, 20);
        add(c7);


        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 12));
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(220, 670, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 12));
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(420, 670, 100, 30);
        cancel.addActionListener(this);
        add(cancel);


        setSize(850, 820);
        setLocation(350, 0);
        setLayout(null);
        setUndecorated(true);
        getContentPane().setBackground(Color.white);
        setVisible(true);
    }

    public static void main(String[] args) {
        new SignupThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == submit){
            String accountType = null;
            if(r1.isSelected()){
                accountType = "Savings Account";
            }
            else if(r2.isSelected()){
                accountType = "Fixed Deposit Account";
            }
            else if(r3.isSelected()){
                accountType = "Current Account";
            }
            else if(r4.isSelected()){
                accountType = "Recurring Deposit Account";
            }

            Random random = new Random();

            String cardNumber = "" + (Math.abs(random.nextLong() % 9000l) + 5040936000000000l);
            String cardno = cardNumber.substring(0, 16);
            String pinNumber = "" + Math.abs(random.nextLong() % 9000l) + 1000l;
            String pinno = cardNumber.substring(0, 4);

            String facility = null;
            if(c1.isSelected()){
                facility += "ATM Card ";
            }
            else if(c2.isSelected()){
                facility += "Internet Banking ";
            }
            else if(c3.isSelected()){
                facility += "Mobile Banking ";
            }
            else if(c4.isSelected()){
                facility += "Email and SMS alerts ";
            }
            else if(c5.isSelected()){
                facility += "Cheque Book ";
            }
            else if(c6.isSelected()){
                facility += "E-Statement ";
            }

           
            try {
                Conn c = new Conn();
                String q1 = "insert into signupthree values('"+formno+"','"+accountType+"', '"+cardno+"',' "+pinno+"',' "+facility+"')";
                String q2 = "insert into login values('"+formno+"','"+cardno+"','"+pinno+"')";
                // c.s.executeQuery(query);
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

            setVisible(false);
            new Login().setVisible(true);
        }
        else if(e.getSource() == cancel){
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
}
