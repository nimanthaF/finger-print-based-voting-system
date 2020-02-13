package dataentry;
import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class show_results extends JFrame {

	JDesktopPane desktopPane=new JDesktopPane();
	JInternalFrame intFrame=new JInternalFrame();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					show_results frame = new show_results();
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
	public show_results() {
		getContentPane().setBackground(new Color(230, 230, 250));
		setBounds(100, 100, 1004, 677);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("View Results");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 32));
		lblNewLabel.setBounds(54, 44, 339, 46);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Election ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(54, 138, 140, 40);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(206, 151, 116, 22);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Election");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(422, 146, 192, 24);
		getContentPane().add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(562, 151, 206, 22);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("candidate 1");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(54, 231, 140, 22);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("candidate 2");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_4.setBounds(231, 231, 140, 22);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("candidate 3");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(413, 231, 128, 22);
		getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("candidate 4");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(590, 232, 116, 22);
		getContentPane().add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("candidate 5");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_7.setBounds(785, 231, 116, 23);
		getContentPane().add(lblNewLabel_7);
		
		textField_2 = new JTextField();
		textField_2.setBounds(54, 283, 116, 22);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(231, 283, 116, 22);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(413, 283, 116, 22);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(590, 283, 116, 22);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(785, 283, 116, 22);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("End Date");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel_8.setBounds(612, 423, 116, 22);
		getContentPane().add(lblNewLabel_8);
		
		textField_7 = new JTextField();
		textField_7.setBounds(767, 423, 152, 26);
		getContentPane().add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("winner");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_9.setBounds(612, 482, 116, 22);
		getContentPane().add(lblNewLabel_9);
		
		textField_8 = new JTextField();
		textField_8.setBounds(767, 482, 152, 26);
		getContentPane().add(textField_8);
		textField_8.setColumns(10);
		
		JButton btnNewButton = new JButton("load ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(385, 51, 192, 34);
		getContentPane().add(btnNewButton);

	}
}
