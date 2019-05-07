
package mybank;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class NewCustomer extends JFrame implements ActionListener  {
    Random r = new Random();
    JLabel l1, l2, l3,l4,l5;
	 JTextField t4,t2,t5;
	 JButton b1,b2;
	 JPasswordField p3;
         int accno=r.nextInt(100000);
	 NewCustomer() {
	  JFrame frame = new JFrame("New User,SignUp !!");
	  l1 = new JLabel("Please fill below details!!");
	  l1.setForeground(Color.blue);
	 
	  l2 = new JLabel("Username:");
	  l3 = new JLabel("Password:");
	  l4 = new JLabel("Mobile(Account No.):");
	  l5 = new JLabel("Opening Balance:");
	  t2 = new JTextField();
	  t4 = new JTextField();
	  t5 = new JTextField();
	  p3 = new JPasswordField();
	  b1 = new JButton("Login");
	  
	 
	  l1.setBounds(100, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  l4.setBounds(80, 150, 200, 30);
	  l5.setBounds(80, 190, 200, 30);
	  t2.setBounds(250, 70, 200, 30);
	  t4.setBounds(250, 150, 200, 30);
	  t5.setBounds(250, 190, 200, 30);
	  p3.setBounds(250, 110, 200, 30);
	  b1.setBounds(50, 250, 200, 30);
	 
	  frame.add(l1);

	  frame.add(l2);
	  frame.add(l3);
	  frame.add(l4);
	  frame.add(l5);

	  frame.add(t2);frame.add(t4);frame.add(t5);
	  frame.add(p3);
	  frame.add(b1);
	 
	  frame.setSize(500, 500);
	  frame.setLayout(null);
	  frame.setVisible(true);
	b1.addActionListener(this);

	
}

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==b1)
		{     try{
                         accno=accno+1;
                         String u=t2.getText();
                         String p=p3.getText();
                         String b=t5.getText();
                         String n=t4.getText();
                         Class.forName("com.mysql.jdbc.Driver");
		         Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","parallgram@1");
		         PreparedStatement ps=conn.prepareStatement("INSERT INTO record (passward,username,balance,cheque,number,accnumber) values (?, ?, ?,?,?,?)");
                         ps.setString(1,p);
                         ps.setString(2,u);
                         ps.setString(3,b);
                         ps.setInt(4,10);
                         ps.setString(5,n);
                         ps.setInt(6,accno);
                        int row = ps.executeUpdate();
                        if (row > 0) {
                         JOptionPane.showMessageDialog(null,"you successfully create a accounr,your account number"+accno);
                         dispose();
                        }
			conn.close();
                }
                catch(Exception e1){
                     e1.printStackTrace();
                }
		}
     
    }

    
}
