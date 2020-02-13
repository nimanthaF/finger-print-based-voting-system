package voterVerify;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Base64;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class fingerprintmatch extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fingerprintmatch frame = new fingerprintmatch();
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
	public fingerprintmatch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(353, 111, 183, 177);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(107, 164, 116, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("fingerprint");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f=chooser.getSelectedFile();
				String filename=f.getAbsolutePath();
				
				Image getAbsolutePath=null;
				ImageIcon icon=new ImageIcon(filename);
				Image image=icon.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
				String base64ImageString = encoder(filename);
				textField.setText(base64ImageString);
				lblNewLabel.setIcon(icon);
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
			
		});
		btnNewButton.setBounds(107, 107, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("match");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/elctiondb","root","");
					
					String sql="Select * from voters where fingerprint=?";
					PreparedStatement pst = con.prepareStatement(sql);
					pst.setString(1,textField.getText() );
					ResultSet rs = pst.executeQuery();
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "verified!");
					}else {
						JOptionPane.showMessageDialog(null, "access denied!");
					}
				}catch(Exception arg0) {
					JOptionPane.showMessageDialog(null, "Invalid Input!");
				}
			}
		});
		btnNewButton_1.setBounds(136, 330, 97, 25);
		contentPane.add(btnNewButton_1);
		
		
		
		
	}
}
