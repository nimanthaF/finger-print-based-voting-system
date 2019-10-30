package dataentry;

import java.sql.*;
import java.lang.*;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addelection extends JFrame {

	JDesktopPane desktopPane=new JDesktopPane();
	JInternalFrame intFrame=new JInternalFrame("JInternamlFrame addelection");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addelection frame = new addelection();
					frame.setVisible(true);
					frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					frame.setSize(640,650);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addelection() {
		setBounds(100, 100, 619, 586);
		intFrame.setBounds(0, 0, 0, 0);
		
		intFrame.setVisible(true);
		desktopPane.setBackground(new Color(135, 206, 250));
		desktopPane.setLayout(null);
		
		desktopPane.add(intFrame);
		getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Add Election");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(47, 26, 227, 56);
		desktopPane.add(lblNewLabel);
		
		JLabel lblElectionId = new JLabel("Election ID");
		lblElectionId.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblElectionId.setBounds(40, 123, 154, 32);
		desktopPane.add(lblElectionId);
		
		textField = new JTextField();
		textField.setBounds(274, 123, 245, 31);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Election");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(40, 201, 166, 32);
		desktopPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(274, 201, 245, 31);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("No. of candidates");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(40, 270, 176, 32);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(274, 275, 245, 31);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		int text2=Integer.parseInt(textField_2.getText());
		
		JLabel lblNewLabel_3 = new JLabel("Start date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(40, 353, 166, 27);
		desktopPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(274, 353, 245, 27);
		desktopPane.add(textField_3);
		textField_3.setColumns(10);
		int text3=Integer.parseInt(textField_3.getText());
		
		JLabel lblNewLabel_4 = new JLabel("End Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(47, 422, 126, 21);
		desktopPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(274, 411, 245, 32);
		desktopPane.add(textField_4);
		textField_4.setColumns(10);
		int text4=Integer.parseInt(textField_4.getText());
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/jeff","root","0313313510");
					PreparedStatement statement = conn.prepareStatement("INSERT INTO  addelection(election_id,election,no_of_candidates,start_date,end_date) VALUES (?,?,?,?,?)");
					statement.setString(1,textField.getText());
					statement.setString(2,textField_1.getText());
					statement.setInt(3, text2);
					statement.setInt(4, text3);
					statement.setInt(5, text4);
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted succesfully!");
				}catch(Exception e) {
					System.out.println("Invalid input!");
				}
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(211, 488, 166, 38);
		desktopPane.add(btnNewButton);

	}

}
