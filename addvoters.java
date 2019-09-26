package dataentry;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class addvoters extends JFrame {

	/**
	 * Launch the application.
	 */
	JDesktopPane desktopPane=new JDesktopPane();
	JInternalFrame intFrame=new JInternalFrame("JInternalFrame demo");
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addvoters frame = new addvoters();
					frame.setSize(640,650);
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
		setBounds(100, 100, 595, 609);
		intFrame.setBounds(0, 0, 0, 0);
		intFrame.setVisible(true);
		desktopPane.setBackground(new Color(176, 196, 222));
		desktopPane.setLayout(null);

		desktopPane.add(intFrame);
		getContentPane().add(desktopPane);
		
		JLabel lblNewLabel = new JLabel("Add Voters");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(71, 39, 166, 54);
		desktopPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Voter ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_1.setBounds(71, 151, 127, 29);
		desktopPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(293, 151, 187, 30);
		desktopPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Voter Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setBounds(71, 217, 127, 29);
		desktopPane.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(293, 216, 187, 30);
		desktopPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Address");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_3.setBounds(71, 278, 166, 29);
		desktopPane.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(295, 278, 185, 30);
		desktopPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(167, 344, 138, 126);
		desktopPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.setBackground(new Color(152, 251, 152));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 22));
		btnNewButton.setBounds(336, 490, 127, 44);
		desktopPane.add(btnNewButton);
	}

}
