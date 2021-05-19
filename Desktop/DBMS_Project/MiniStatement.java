package ASimulatorSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener{
 
    JTable t1;
    JButton b1,b4;
    String x[] = {"Deposit","Withdraw","Balance"};
    String y[][] = new String[20][5];
    int i=0, j=0;
    
    MiniStatement(){
        super("Mini Statement");
        setSize(1200,650);
        setLocation(200,200);
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter Password", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        String pinn = new String(pf.getPassword());
        try{
            conn c1  = new conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM bank where pin = '" + pinn + "'order by no");
          //  String s1 = "select * from bank";
          //  ResultSet rs  = c1.s.executeQuery(s1);
            while(rs.next()){
                y[i][j++]=rs.getString("deposit");
                y[i][j++]=rs.getString("withdrawal");
                y[i][j++]=rs.getString("balance");
                i++;
                j=0;
            }
            t1 = new JTable(y,x);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        b1 = new JButton("Print");
        b1.setBounds(500,400,300,60);
        b1.addActionListener(this);
        JScrollPane sp = new JScrollPane(t1);
        add(sp);
        b1.addActionListener(this);
        b4 = new JButton("Back");
        b4.setBounds(240,400,300,60);
        b4.addActionListener(this);
        add(b4);
        add(b1);
        JScrollPane sp1 = new JScrollPane(t1);
        add(sp1);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
    	if(ae.getSource()==b1){try{
            t1.print();
        }catch(Exception e){}
    	}
        if(ae.getSource()==b4){ 
            
        	new Transcations().setVisible(true);
            setVisible(false);
            
        }
    }
    
    public static void main(String[] args){
        new MiniStatement().setVisible(true);
    }
    
}
