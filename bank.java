
package mybank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class bank extends JFrame implements ActionListener {
    JLabel l1;
	 JTextField tf1;
	 JButton b1,b2,b3,b5,b6;
	 bank() {
	  JFrame frame = new JFrame("Banking-Secured Login!!");
	  l1 = new JLabel("Below are the available banking operations!!");
	  l1.setForeground(Color.blue);
	  b1 = new JButton("Deposit");
	  b2 = new JButton("Withdraw");
	  b3 = new JButton("Buy Cheque");
	
	  b5 = new JButton("Check Balance");
	  
	 
	  l1.setBounds(100, 30, 300, 30);
	  b1.setBounds(80, 70, 300, 30);
	  b2.setBounds(80, 110, 300, 30);
	  b3.setBounds(80, 150, 300, 30);
	  b5.setBounds(80, 190, 300, 30);

	  
	  frame.add(l1);
	  frame.add(b1);
	  frame.add(b2);
	  frame.add(b3);
	
	  frame.add(b5);
	 
	  frame.setSize(500, 500);
	  frame.setLayout(null);
	  frame.setVisible(true);
	  b1.addActionListener(this);
	  b2.addActionListener(this);
	  b3.addActionListener(this);
          b5.addActionListener(this);
}

@Override
public void actionPerformed(ActionEvent e) 
{
	 if(e.getSource()==b1)
	 {
	  Deposit d=new Deposit();
          d.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                
	 }
	 else if(e.getSource()==b2)
	 {
          Withdraw w=new Withdraw();
          w.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                 	
	 }
	 else if(e.getSource()==b3)
	 {
	   Buy_Cheque b=new Buy_Cheque();
            b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	
	 else if(e.getSource()==b5)
	 {
             Check_Balance c=new Check_Balance();
             c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         }
}
}
    

