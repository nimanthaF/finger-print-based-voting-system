package dataentry;

import java.sql.*;
import java.util.Base64;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import mysqllogin.login;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class useradmin_entry extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
		
	String s;
	private JTextField textField_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					useradmin_entry frame = new useradmin_entry();
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
	public useradmin_entry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1248, 874);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Voters");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel.setBounds(473, 69, 301, 55);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Voters ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_1.setBounds(207, 191, 285, 67);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(652, 206, 314, 52);
		contentPane.add(textField);
		Font font = new Font("Courier", Font.BOLD,20);
		textField.setFont(font);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Voters Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_2.setBounds(207, 319, 285, 55);
		contentPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(652, 319, 314, 55);
		contentPane.add(textField_1);
		textField_1.setFont(font);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 45));
		lblNewLabel_3.setBounds(207, 430, 285, 55);
		contentPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(652, 434, 314, 51);
		contentPane.add(textField_2);
		textField_2.setFont(font);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(703, 532, 200, 201);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(192, 679, 314, 34);
		contentPane.add(textField_3);
		textField_3.setFont(font);
		textField_3.setColumns(10);
		
	//	static String base64ImageString;
		JButton btnNewButton_2 = new JButton("fingerprint");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				
				Image getAbsolutePath=null;
				ImageIcon icon=new ImageIcon(filename);
				Image image=icon.getImage().getScaledInstance(lblNewLabel_4.getWidth(), lblNewLabel_4.getHeight(), Image.SCALE_SMOOTH);
				String base64ImageString = encoder(filename);
				 textField_3.setText(base64ImageString);
				lblNewLabel_4.setIcon(icon);
			}

			

			public String encoder(String filename) {
			    String base64Image = "";
			    File file = new File(filename);
			    try (FileInputStream imageInFile = new FileInputStream(file)) {
			      // Reading a Image file from file system
			      byte imageData[] = new byte[(int) file.length()];
			      imageInFile.read(imageData);
			      base64Image = Base64.getEncoder().encodeToString(imageData);
			    } catch (FileNotFoundException e) {
			      System.out.println("Image not found" + e);
			    } catch (IOException ioe) {
			      System.out.println("Exception while reading the Image " + ioe);
			    }
			    return base64Image;
			  }

			//String img=base64Image;
			
			
		});
		 
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton_2.setBounds(233, 580, 209, 55);
		contentPane.add(btnNewButton_2);
		
		
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
					PreparedStatement statement = conn.prepareStatement("INSERT INTO  voters(voter_id,voter_name,address,fingerprint) VALUES (?,?,?,?)");
					
					String image=textField_3.getText();
					image=image.replace("\\", "\\\\");
					
					
					statement.setString(1,textField.getText());
					statement.setString(2,textField_1.getText());
					statement.setString(3,textField_2.getText());
					statement.setString(4,textField_3.getText());
					statement.executeUpdate();
					JOptionPane.showMessageDialog(null, "Inserted succesfully!");
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Invalid Input!");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnNewButton.setBounds(220, 758, 261, 55);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("log out");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login info=new login();
				login.main(null);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnNewButton_1.setBounds(918, 759, 236, 53);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("clear");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 45));
		btnNewButton_3.setBounds(585, 759, 209, 52);
		contentPane.add(btnNewButton_3);
		
		btnNewButton_3.addActionListener(new ActionListener(){
		    public void actionPerformed(ActionEvent e){
		        textField.setText("");
		        textField_1.setText("");
		        textField_2.setText("");
		        textField_3.setText("");
		        lblNewLabel_4.setIcon(null);;
		        //textfield.setText(null); //or use this
		    }
		});
		
		
	
		
	}
}
