
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
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class frame extends JFrame implements ActionListener {
    
        
    JLabel l1, l2, l3;
	 JTextField t1;
	 JButton b1,b2;
	 JPasswordField p1;
	frame() {
	  JFrame frame = new JFrame("CITY Bank");
          frame.setLayout(null);
          frame.setBackground(Color.BLUE);
	  l1 = new JLabel("Welcome!");
	  l1.setForeground(Color.blue);
	 
	  l2 = new JLabel("username");
	  l3 = new JLabel("passward");
	  t1 = new JTextField();
	  p1 = new JPasswordField();
	  b1 = new JButton("Login");
	  
	 
	  l1.setBounds(100, 30, 400, 30);
	  l2.setBounds(80, 70, 200, 30);
	  l3.setBounds(80, 110, 200, 30);
	  t1.setBounds(250, 70, 200, 30);
	  p1.setBounds(250, 110, 200, 30);
	  b1.setBounds(50, 200, 150, 40);
	 
	  frame.add(l1);
	  frame.add(l2);
	  frame.add(t1);
	  frame.add(l3);
	  frame.add(p1);
	  frame.add(b1);
	  
	 
	 frame.setVisible(true);
         frame.setSize(500,500);
	b2=new JButton("New User");
	b2.setBounds(250, 200, 150, 40);
	frame.add(b2);
	b1.addActionListener(this);
	b2.addActionListener(this);
        frame.setResizable(false);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	
	
	
	

}

     @Override
    public void actionPerformed(ActionEvent ae) 
    {    
         if(ae.getSource()==b1)
	 {
			try
			{
				String u=t1.getText();
                                String p=p1.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/bank","root","parallgram@1");
				PreparedStatement ps=conn.prepareStatement("select userName,passward from record where username=?");
                                ps.setString(1,u);
                                ResultSet rs=ps.executeQuery();
                                String orgUname = "", orPass = "";
				
                                    while(rs.next())
                                    {
                                        orgUname =rs.getString("username");
                                
                                        orPass=rs.getString("passward");
                                    }
                                    if(orPass.equals(p))
                                    {
                                         bank ba=new bank();
		                         ba.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 		
                                    }
                                    else
                                    {
                                        JOptionPane.showMessageDialog(null,"login faild ..try again later...");
                                        dispose();
                                    }
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		 
		
	 } 
       else
        if(ae.getSource()==b2)
	 {
		 NewCustomer nc=new NewCustomer();
			
			nc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                               
	 }
	 	
  
     
    }

}
