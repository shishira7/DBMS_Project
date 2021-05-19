package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Transcations extends JFrame implements ActionListener{

    JLabel l1;
    JButton b1,b2,b3,b4,b5,b6,b7;
    
    Transcations(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("TRANSACTION");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"TRANSACTION");
    
        l1 = new JLabel("Please Select Your Transaction");
        l1.setFont(new Font("System", Font.BOLD, 38));
    
       
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
    
        b2 = new JButton("CASH WITHDRAWAL");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);

        
        b4 = new JButton("MINI STATEMENT");
        b4.setFont(new Font("System", Font.BOLD, 18));
        b4.setBackground(Color.WHITE);
        b4.setForeground(Color.BLACK);
        
        b5 = new JButton("DELETE ACCOUNT");
        b5.setFont(new Font("System", Font.BOLD, 18));
        b5.setBackground(Color.WHITE);
        b5.setForeground(Color.BLACK);
        
        b7 = new JButton("SIGNOUT");
        b7.setFont(new Font("System", Font.BOLD, 18));
        b7.setBackground(Color.WHITE);
        b7.setForeground(Color.BLACK);
        
        
        setLayout(null);
        
        l1.setBounds(100,100,700,40);
        add(l1);
        
        b1.setBounds(240,200,300,60);
        add(b1);
        
        b2.setBounds(240,300,300,60);
        add(b2);
        
        b4.setBounds(240,400,300,60);
        add(b4);
        
        b5.setBounds(240,500,300,60);
        add(b5);
        
        b7.setBounds(240,600,300,60);
        add(b7);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        b7.addActionListener(this);
        
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){ 
            
            new Deposit().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b2){ 
            
            new Withdrawl().setVisible(true);
            setVisible(false);
            
        }
        else if(ae.getSource()==b4){ 
            
            new MiniStatement().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b5){ 
            
            new Delaccount().setVisible(true);
            setVisible(false);
            
        }else if(ae.getSource()==b7){ 
            
            System.exit(0);
            
        }
        
            
        
        
    }
    
    public static void main(String[] args){
        new Transcations().setVisible(true);
    }
}