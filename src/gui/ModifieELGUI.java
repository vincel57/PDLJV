package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ModifieELGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifieELGUI window = new ModifieELGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ModifieELGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		Component textField = new JTextField();
		textField.setBounds(168, 11, 86, 20);
		choicePnl.add(textField);
		((JTextField) textField).setColumns(10);
		
		Component textField_1 = new JTextField();
		textField_1.setBounds(168, 42, 86, 20);
		choicePnl.add(textField_1);
		((JTextField) textField_1).setColumns(10);
		
		JTextField textField_2 = new JTextField();
		textField_2.setBounds(168, 74, 86, 20);
		choicePnl.add(textField_2);
		textField_2.setColumns(10);
		
		JTextField textField_3 = new JTextField();
		textField_3.setBounds(168, 114, 86, 20);
		choicePnl.add(textField_3);
		textField_3.setColumns(10);
		
		JTextField textField_4 = new JTextField();
		textField_4.setBounds(168, 151, 86, 20);
		choicePnl.add(textField_4);
		textField_4.setColumns(10);
		
		JTextField textField_5 = new JTextField();
		textField_5.setBounds(168, 189, 86, 20);
		choicePnl.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton = new JButton("UPDATE STUDENT ");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(106, 245, 216, 23);
		choicePnl.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Identifiant ");
		lblNewLabel.setBounds(101, 14, 57, 14);
		choicePnl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(112, 45, 46, 14);
		choicePnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(112, 77, 46, 14);
		choicePnl.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		lblNewLabel_3.setBounds(112, 117, 46, 14);
		choicePnl.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setBounds(112, 154, 46, 14);
		choicePnl.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Year");
		lblNewLabel_5.setBounds(112, 189, 46, 14);
		choicePnl.add(lblNewLabel_5);
	}

}
