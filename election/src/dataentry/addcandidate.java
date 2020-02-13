package dataentry;

import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addcandidate extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addcandidate frame = new addcandidate();
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
	public addcandidate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1075, 804);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add candidate");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(348, 48, 396, 103);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCandidateName = new JLabel("candidate id");
		lblCandidateName.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblCandidateName.setBounds(109, 251, 322, 59);
		getContentPane().add(lblCandidateName);
		
		Font font = new Font("Courier", Font.BOLD,20);
		
		textField = new JTextField();
		textField.setBounds(550, 251, 373, 52);
		getContentPane().add(textField);
		textField.setFont(font);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("candidate name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_1.setBounds(109, 359, 373, 44);
		getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(550, 360, 373, 44);
		getContentPane().add(textField_1);
		textField_1.setFont(font);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("address");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_2.setBounds(109, 461, 332, 38);
		getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(550, 459, 373, 44);
		getContentPane().add(textField_2);
		textField_2.setFont(font);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
					PreparedStatement statement = conn.prepareStatement("INSERT INTO  candidate(candidate_id,candidate_name,address) VALUES (?,?,?)");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnNewButton.setBounds(165, 633, 258, 68);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		btnNewButton_1.setBounds(586, 633, 268, 68);
		contentPane.add(btnNewButton_1);
	}
}
