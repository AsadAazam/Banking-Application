
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


public class Deposit extends JFrame implements ActionListener 
{      JLabel l1, l2,l3;
	 JTextField t1;
         JTextField t2;
	 JButton b1;
	
	Deposit() {
	  JFrame frame = new JFrame("CITY Bank");
          frame.setLayout(null);
          frame.setBackground(Color.BLUE);
	  l1 = new JLabel("Welcome!");
	  l1.setForeground(Color.blue);
	 
	  l2 = new JLabel("Account number");
          l3 = new JLabel("amount deposit");
	  t1 = new JTextField();
          t2 = new JTextField();
          b1 = new JButton("Enter");
	  
          l1.setBounds(100, 30, 400, 30);
	  l2.setBounds(40, 100, 200, 30);
          l3.setBounds(40, 150, 200, 30);
          l3.setBounds(40, 150, 200, 30);
	  t1.setBounds(250, 100, 200, 30);
          t2.setBounds(250, 150, 200, 30);
          b1.setBounds(50, 200, 150, 40);
	 
	  frame.add(l1);
	  frame.add(l2);
          frame.add(l3);
	  frame.add(t1);
          frame.add(t2);
          frame.add(b1);
	  

	  
	 
	 frame.setVisible(true);
         frame.setSize(500,500);
	
	
	b1.addActionListener(this);
	
        frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }	

    
@Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==b1){
        try{
        
        String acc=t1.getText();
        String d =t2.getText();
        
         
         int accn =Integer.parseInt(acc);
         int d1 =Integer.parseInt(d);
         
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","parallgram@1");
      PreparedStatement ps = conn.prepareStatement("SELECT passward, accnumber,balance FROM record WHERE accnumber = "+accn+"");
                ResultSet RS = ps.executeQuery();
                if(RS.next()){
                 int currentbal = RS.getInt(3);
                int newbalance = currentbal+d1;
                 
                  PreparedStatement ps1 =conn.prepareStatement("UPDATE record SET balance = "+newbalance+" WHERE passward = "+ RS.getInt(1)+"");
                 ps1.executeUpdate();
                        JOptionPane.showMessageDialog( null,"you have made a deposit to "+accn);
                  } else {
                        JOptionPane.showMessageDialog( null,"Invalid Account Number");
                    }
                 
            }      
        catch(Exception e1)
        {
            System.out.println( e1.getMessage( ) );
        }
    }
    }
    
    
    
}
