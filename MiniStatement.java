package com.haroy.bankmanagementsystem;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class MiniStatement extends JFrame {

    public MiniStatement(String pin){

        JLabel text = new JLabel();
        text.setBounds(20, 140, 400, 200);
        add(text);

        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        JLabel bank = new JLabel("Indian Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20, 80, 300, 20);
        add(card);

        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from login where pin = '"+ pin +"'" );
            while(rs.next()){
                card.setText("Card Numer: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));
            }

        }catch(Exception exception){
            System.out.println(exception);
        }

        try{
            Conn c = new Conn();
            int bal = 0;
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+ pin +"'" );
            while(rs.next()){
                 text.setText(text.getText() + "<html>"+rs.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount") + "<br><br><html>");
                if(rs.getString("type").equals("Deposite")){
                    bal += Integer.parseInt(rs.getString("amount"));
                }
                else{
                    bal -= Integer.parseInt(rs.getString("amount"));
                } 
            }

            balance.setText("Total Amount = " + bal);
  
        }catch(Exception exception){
            System.out.println(exception);
        }

        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);
        getContentPane().setBackground(Color.white);
        setVisible(true);

    }

    public static void main(String[] args) {
        new MiniStatement("");
    }
}
