
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Delaccount extends JFrame implements ActionListener{
    
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    JPasswordField pf2;
    
    
    Delaccount(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DELETE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (7*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DELETE");
        
        
        l1 = new JLabel("ARE YOU SURE YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DELETE ACCOUNT");
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        l3 = new JLabel("Enter Pin");
        l3.setFont(new Font("System", Font.BOLD, 14));

        pf2 = new JPasswordField(15);
        
        b1 = new JButton("DELETE");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.WHITE);
        b1.setForeground(Color.BLACK);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.WHITE);
        b2.setForeground(Color.BLACK);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.WHITE);
        b3.setForeground(Color.BLACK);
        
        
        setLayout(null);
        
        l3.setBounds(550,10,80,30);
        add(l3);
        
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(620,10,80,30);
        add(pf2);
        
        l1.setBounds(170,150,800,60);
        add(l1);
        
        l2.setBounds(210,210,800,60);
        add(l2);
        

        
        b1.setBounds(260,380,125,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.LIGHT_GRAY);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
       
        try{        
           
            String b = pf2.getText();
            	
            
            
            
            if(ae.getSource()==b2){
                
                new Transcations().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
            else if(pf2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter your pin");
            }else if(ae.getSource()==b1){
            	conn c1 = new conn();
            	String q1= "DELETE FROM bank WHERE pin = " +b+ ";";
                c1.s.executeUpdate(q1);
                q1= "DELETE FROM login WHERE pin = " +b+ ";";
                c1.s.executeUpdate(q1);
                JOptionPane.showMessageDialog(null, "Deleted Successfully");
                System.exit(0);
            }

            	
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }
    
    public static void main(String[] args){
        new Delaccount().setVisible(true);
    }

    
}
