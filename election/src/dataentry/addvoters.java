package dataentry;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addvoters extends JFrame {

	/**
	 * Launch the application.
	 */
	JDesktopPane desktopPane=new JDesktopPane();
	JInternalFrame intFrame=new JInternalFrame("JInternalFrame demo");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addvoters frame = new addvoters();
					frame.setSize(886,799);
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addvoters() {
		setBackground(new Color(0, 255, 255));
		setBounds(100, 100, 886, 799);
		intFrame.setBounds(0, 0, 0, 0);
		intFrame.setVisible(true);
		desktopPane.setBackground(new Color(230, 230, 250));
		desktopPane.setLayout(null);

		desktopPane.add(intFrame);
		getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Add Voters");
		lblNewLabel.setBounds(307, 40, 366, 76);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Voter ID");
		lblNewLabel_1.setBounds(75, 199, 187, 34);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 43));
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(437, 199, 342, 34);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Voter Name");
		lblNewLabel_2.setBounds(71, 275, 234, 44);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 43));
		desktopPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(437, 285, 342, 34);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setBounds(71, 366, 234, 45);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 43));
		desktopPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(437, 383, 342, 34);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBounds(539, 574, 211, 61);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeff","root","0313313510");
					PreparedStatement statement = conn.prepareStatement("INSERT INTO  voters(voter_id,voter_name,address) VALUES (?,?,?)");
					statement.setString(1,textField.getText());
					statement.setString(2,textField_1.getText());
					statement.setString(3,textField_2.getText());
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted succesfully!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input!");
				}
			}
		});
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 43));
		desktopPane.add(btnNewButton);
	}

}
