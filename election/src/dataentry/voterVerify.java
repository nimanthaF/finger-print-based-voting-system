package dataentry;

import javax.swing.*;

import dataentry.fingerprintmatch;

import java.sql.*;
import java.util.Base64;
import java.awt.event.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.Font;
import java.awt.Image;


public class voterVerify extends JFrame implements ActionListener{
    JLabel JL_voter_name,JL_address,JL_id;
    JTextField JT_voter_name,JT_address,JT_fingerprint,JT_id;
    JButton btn_search;
    private JButton btnVerify;
    private JButton btnFingerprint;

      public voterVerify(){
          super("Search");
          JL_id = new JLabel("Enter ID:");
          JL_id.setFont(new Font("Tahoma", Font.PLAIN, 20));
          JL_id.setBounds(69, 117, 200, 20);
          JT_id = new JTextField(20);
          JT_id.setFont(new Font("Times New Roman", Font.PLAIN, 15));
          JT_id.setBounds(229, 122, 239, 33);
          btn_search = new JButton("Search");
          btn_search.setFont(new Font("Tahoma", Font.BOLD, 16));
          btn_search.setBounds(551, 121, 150, 34);
          btn_search.addActionListener(this);
          setVisible(true);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setLocationRelativeTo(null);
          setSize(921,757);
          
          JL_voter_name = new JLabel("Name: ");
          JL_voter_name.setFont(new Font("Tahoma", Font.PLAIN, 20));
          JL_voter_name.setBounds(69, 230, 138, 27);
          JT_voter_name = new JTextField(20);
          JT_voter_name.setFont(new Font("Times New Roman", Font.PLAIN, 15));
          JT_voter_name.setBounds(229, 231, 239, 33);
          JL_address = new JLabel("Address: ");
          JL_address.setFont(new Font("Tahoma", Font.PLAIN, 20));
          JL_address.setBounds(69, 355, 117, 20);
          JT_address = new JTextField(20);
          JT_address.setFont(new Font("Times New Roman", Font.PLAIN, 15));
          JT_address.setBounds(229, 353, 239, 33);
          JT_fingerprint = new JTextField(20);
          JT_fingerprint.setFont(new Font("Times New Roman", Font.PLAIN, 15));
          JT_fingerprint.setBounds(49, 595, 239, 33);
          getContentPane().setLayout(null);
          getContentPane().add(btn_search);
          getContentPane().add(JL_voter_name);
          getContentPane().add(JT_voter_name);
          getContentPane().add(JL_address);
          getContentPane().add(JT_address);
          getContentPane().add(JT_fingerprint);
          getContentPane().add(JL_id);
          getContentPane().add(JT_id);
          
          btnVerify = new JButton("Verify");
          btnVerify.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) {
          		
          	}
          });
          btnVerify.setFont(new Font("Tahoma", Font.BOLD, 16));
          btnVerify.setBounds(460, 593, 150, 34);
          getContentPane().add(btnVerify);
          
          btnFingerprint = new JButton("Fingerprint");
          btnFingerprint.addActionListener(new ActionListener() {
          	public void actionPerformed(ActionEvent e) { 
          		fingerprintmatch info=new 	fingerprintmatch();
          		fingerprintmatch.main(null);
          	}          	
          });
          btnFingerprint.setFont(new Font("Tahoma", Font.BOLD, 16));
          btnFingerprint.setBounds(49, 535, 150, 34);
          getContentPane().add(btnFingerprint);
          
          
    }

    @Override
    public void actionPerformed(ActionEvent e) { 
    Function f = new Function();
    ResultSet rs = null;
   // String fn = "voter_name";
  //  String ln = "address";
    //String ag = "fingerprint";
    
    
    
    
    
    
    rs = f.find(JT_id.getText());
    try{
      if(rs.next()){
          JT_voter_name.setText(rs.getString("voter_name"));
            JT_address.setText(rs.getString("address"));
              JT_fingerprint.setText(rs.getString("fingerprint"));
      }  else{
          JOptionPane.showMessageDialog(null, "NO DATA FOR THIS ID");
      }
    }catch(Exception ex){
           JOptionPane.showMessageDialog(null, ex.getMessage());
            }
    }
   public class Function{
       Connection con = null;						
       ResultSet rs = null;
       PreparedStatement ps = null;
       public ResultSet find(String s){
           try{
        	   Class.forName("com.mysql.jdbc.Driver");
          con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
           ps = con.prepareStatement("select * from voters where voter_id = ?");
           ps.setString(1,s);
           rs = ps.executeQuery();
           
           }catch(Exception ex){
              JOptionPane.showMessageDialog(null, ex.getMessage());
           }
           return rs;
       }
       
   }

    
 public static void main(String[] args){
  new voterVerify();
 }
 
}