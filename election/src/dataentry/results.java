package dataentry;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class results extends JFrame {

	JDesktopPane desktopPane=new JDesktopPane();
	JInternalFrame intFrame=new JInternalFrame("JInternalFrame results");
	private JTextField textField;
	private JPasswordField passwordField;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					results frame = new results();
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
	public results() {
		setBounds(100, 100, 578, 462);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Secondary  Level Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(101, 30, 428, 61);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(53, 150, 177, 27);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(242, 153, 264, 28);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(53, 241, 177, 27);
		getContentPane().add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(242, 241, 264, 27);
		getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeff","root","0313313510");
					Statement stmt=con.createStatement();
					String sql="Select * from dblogin where username='"+textField.getText()+"'and password_log='"+passwordField.getText().toString()+"'";
					ResultSet rs=stmt.executeQuery(sql);
					if(rs.next()) {
						//JOptionPane.showMessageDialog(null, "Login succcefully!");
						show_results info=new show_results();
						show_results.main(null);
				
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(199, 328, 156, 35);
		getContentPane().add(btnNewButton);

	}
}
