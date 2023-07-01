package com.haroy.bankmanagementsystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

import javax.swing.*;



public class FastCash extends JFrame implements ActionListener{

    JButton deposite, withdrawal, ministatement, balanceenquiry, exit, fastcash, pinchange;
    String pin;

    public FastCash(String pin){

        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com\\haroy\\icons\\atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Select Withdrawal Amount :");
        text.setBounds(210, 300, 700, 35);
        text.setForeground(Color.white);
        text.setFont(new Font("System", Font.BOLD, 16));
        image.add(text);

        deposite = new JButton("Rs. 100");
        deposite.setBounds(170, 415, 150, 30);
        deposite.addActionListener(this);
        image.add(deposite);

        withdrawal = new JButton("Rs. 500");
        withdrawal.setBounds(355, 415, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        fastcash = new JButton("Rs. 1000");
        fastcash.setBounds(170, 450, 150, 30);
        fastcash.addActionListener(this);
        image.add(fastcash);

        balanceenquiry = new JButton("Rs. 2000");
        balanceenquiry.setBounds(355, 450, 150, 30);
        balanceenquiry.addActionListener(this);
        image.add(balanceenquiry);
        
        pinchange = new JButton("Rs. 5000");
        pinchange.setBounds(170, 485, 150, 30);
        pinchange.addActionListener(this);
        image.add(pinchange);

        ministatement = new JButton("Rs. 10000");
        ministatement.setBounds(355, 485, 150, 30);
        ministatement.addActionListener(this);
        image.add(ministatement);

        

        exit = new JButton("Back");
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
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
        else{
            String amount = ((JButton)e.getSource()).getText().substring(4);
            Conn c = new Conn();
            try {

                ResultSet rs = c.s.executeQuery("Select * from bank where pin ='"+ pin +"'");
                int balance = 0;

                while(rs.next()){
                    if(rs.getString("type").equals("Deposite")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    }
                    else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    } 
                }

                if(balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }
                else{
                    Date date = new Date();
                String query = "Insert into bank values('" + pin + "', '" + date + "', 'Withdrawal', '" + amount + "')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Rs." + amount + " Debited");
                }

                setVisible(false);
                new Transactions(pin).setVisible(true);
            } catch (Exception exception) {

                System.out.println(exception);

            }
        }
    }
   
    public static void main(String[] args) {
        new FastCash("");
    }
}