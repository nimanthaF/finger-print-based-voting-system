package dataentry;

import java.sql.*;
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
					frame.setSize(930,788);
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
		setBounds(100, 100, 930, 788);
		intFrame.setBounds(0, 0, 0, 0);
		
		intFrame.setVisible(true);
		desktopPane.setBackground(new Color(230, 230, 250));
		desktopPane.setLayout(null);
		
		desktopPane.add(intFrame);
		getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Add Election");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel.setBounds(227, 13, 317, 78);
		desktopPane.add(lblNewLabel);
		
		JLabel lblElectionId = new JLabel("Election ID");
		lblElectionId.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblElectionId.setBounds(68, 134, 232, 46);
		desktopPane.add(lblElectionId);
		
		textField = new JTextField();
		textField.setBounds(527, 134, 266, 46);
		desktopPane.add(textField);
		Font font = new Font("Courier", Font.BOLD,20);
		textField.setFont(font);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Election");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_1.setBounds(68, 228, 232, 46);
		desktopPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(527, 228, 266, 46);
		desktopPane.add(textField_1);
		textField_1.setFont(font);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("No. of candidates");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_2.setBounds(68, 307, 368, 61);
		desktopPane.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(527, 326, 266, 42);
		desktopPane.add(textField_2);
		textField_2.setFont(font);
		textField_2.setColumns(10);
		//String text2s = textField_2.getText();
		//int text2=Integer.parseInt(text2s);
		
		JLabel lblNewLabel_3 = new JLabel("Start date");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_3.setBounds(68, 410, 339, 54);
		desktopPane.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(527, 421, 266, 42);
		desktopPane.add(textField_3);
		textField_3.setFont(font);
		textField_3.setColumns(10);
	//	String text3s=textField_3.getText();
		//int text3=Integer.parseInt(text3s);
		
		JLabel lblNewLabel_4 = new JLabel("End Date");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 44));
		lblNewLabel_4.setBounds(68, 512, 195, 46);
		desktopPane.add(lblNewLabel_4);
		
		textField_4 = new JTextField();
		textField_4.setBounds(527, 512, 266, 46);
		desktopPane.add(textField_4);
		textField_4.setFont(font);
		textField_4.setColumns(10);
		//String text4s=textField_4.getText();
		//int text4=Integer.parseInt(text4s);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
					PreparedStatement statement = conn.prepareStatement("INSERT INTO  addelection(election_id,election,no_of_candidates,start_date,end_date) VALUES (?,?,?,?,?)");
					statement.setString(1,textField.getText());
					statement.setString(2,textField_1.getText());
					statement.setString(3, textField_2.getText());
					statement.setString(4, textField_3.getText());
					statement.setString(5, textField_4.getText());
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted succesfully!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input!");
				}
			}
		});
		btnNewButton.setBackground(new Color(127, 255, 212));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 44));
		btnNewButton.setBounds(98, 645, 248, 63);
		desktopPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("clear");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		btnNewButton_1.setBounds(527, 645, 238, 63);
		desktopPane.add(btnNewButton_1);

	}
}
