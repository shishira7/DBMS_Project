
package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener{
    
    JTextField t1;
    JPasswordField pf2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3,l4;
    
    Withdrawl(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("WITHDRAWAL");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (4*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"WITHDRAWAL");
        
        
        l1 = new JLabel("PLEASE ENTER THE AMOUNT");
        l1.setFont(new Font("System", Font.BOLD, 40));
        
        l2 = new JLabel("YOU WANT TO WITHDRAW");
        l2.setFont(new Font("System", Font.BOLD, 40));
        
        l3 = new JLabel("Ex: 1000");
        l3.setFont(new Font("System", Font.BOLD, 35));
        
        l4 = new JLabel("Enter Pin");
        l4.setFont(new Font("System", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));

        
        b1 = new JButton("WITHDRAW");
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
        
        pf2 = new JPasswordField(15);
        pf2.setFont(new Font("Arial", Font.BOLD, 14));
        pf2.setBounds(620,10,80,30);
        add(pf2);
        
        setLayout(null);
        
        l4.setBounds(550,10,80,30);
        add(l4);
        
        l1.setBounds(90,100,800,60);
        add(l1);
        
        l2.setBounds(120,160,800,60);
        add(l2);
        
        l3.setBounds(310,260,800,60);
        add(l3);
        
        t1.setBounds(210,340,360,50);
        add(t1);
        
        b1.setBounds(220,400,160,50);
        add(b1);
        
        b2.setBounds(400,400,160,50);
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
           
            String a = t1.getText();
            String b = pf2.getText();
            
            
            
            
            if(ae.getSource()==b1){
                if(pf2.getText().equals("")){
                    
                    JOptionPane.showMessageDialog(null, "Please enter your pin");
                
                }else if(t1.getText().equals("")){
                        
                        JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                
                }else{
                    
                    conn c1 = new conn();
                    
                    
                    
                    ResultSet rs = c1.s.executeQuery(" select * from bank where pin = '"+b+"' order by no");
                    
                    double balance = 0;
                    if(rs.next()){
                    	rs.last();
                        String pin = rs.getString("pin");
                        
                        balance = rs.getDouble("balance");
                        
                        double d = Double.parseDouble(a);
                        balance-=d;
                        String q1= "insert into bank(pin,deposit,withdrawal,balance) values('"+pin+"',null,'"+d+"','"+balance+"')";
                    
                        c1.s.executeUpdate(q1);
                    }
                    
                    
                    
                    JOptionPane.showMessageDialog(null, "Rs. "+a+" Debited Successfully");
                    
                    new Transcations().setVisible(true);
                    setVisible(false);
                    
                    
                    
                }
                
            }else if(ae.getSource()==b2){
                
                new Transcations().setVisible(true);
                setVisible(false);
                
            }else if(ae.getSource()==b3){
                
                System.exit(0);
                
            }
        }catch(Exception e){
                e.printStackTrace();
                System.out.println("error: "+e);
        }
            
    }

    
    
    public static void main(String[] args){
        new Withdrawl().setVisible(true);
    }
}
