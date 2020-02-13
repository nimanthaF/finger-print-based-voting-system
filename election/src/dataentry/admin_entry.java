package dataentry;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import mysqllogin.login;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class admin_entry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					admin_entry frame = new admin_entry();
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
	public admin_entry() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 750);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("add candidate");
		btnNewButton.setBackground(new Color(211, 211, 211));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addcandidate info=new addcandidate();
				addcandidate.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton.setBounds(117, 269, 267, 120);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("add election");
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				addelection info =new addelection();
				addelection.main(null);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 35));
		btnNewButton_1.setBounds(565, 269, 331, 120);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("log out");
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login info=new login();
				login.main(null);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton_3.setBounds(614, 536, 243, 76);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel(" election manager 1.0");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 44));
		lblNewLabel.setBounds(263, 36, 532, 87);
		contentPane.add(lblNewLabel);
	}
}
