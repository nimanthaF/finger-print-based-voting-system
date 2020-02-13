package mysqllogin;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dataentry.admin_entry;
import dataentry.useradmin_entry;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 850);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Election Manager 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(208, 191, 524, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(84, 389, 220, 48);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(445, 407, 287, 39);
		contentPane.add(textField);
		Font font = new Font("Courier", Font.BOLD,20);
		textField.setFont(font);
	//	textField.setColumns();
		
		
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_2.setBounds(84, 513, 220, 55);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
					Statement stmt=con.createStatement();
					String sql="Select * from login where username='"+textField.getText()+"'and password='"+passwordField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					//String uername= textField.getText();
					if(rs.next()) {
					 	//JOptionPane.showMessageDialog(null, "Login succcefully!");
						String s1=rs.getString("username");
						String username= textField.getText();
						if(username.equalsIgnoreCase("nimantha")&& s1.equalsIgnoreCase("nimantha")) {
							admin_entry info=new admin_entry();
							admin_entry.main(null);
						}else {
							useradmin_entry info=new useradmin_entry();
							useradmin_entry.main(null);
						}
				
						
					}
					else {
						JOptionPane.showMessageDialog(null, "Incorrect username or password!");
					}
					con.close();
					dispose();
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input!check again!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnNewButton.setBounds(475, 689, 182, 55);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(445, 529, 287, 39);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\election\\src\\dataentry\\38475996-sri-lanka-election-ba.jpg"));
		lblNewLabel_3.setBounds(419, 88, 132, 90);
		contentPane.add(lblNewLabel_3);
	}
}
