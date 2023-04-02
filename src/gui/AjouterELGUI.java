	package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;

public class AjouterELGUI {

	private JFrame frame;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterELGUI window = new AjouterELGUI();
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
	public AjouterELGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(168, 115, 86, 20);
		choicePnl.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(168, 165, 86, 20);
		choicePnl.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton = new JButton("ADD STUDENT ");
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 274, 216, 23);
		choicePnl.add(btnNewButton);
		
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(112, 118, 46, 14);
		choicePnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(100, 168, 58, 14);
		choicePnl.add(lblNewLabel_2);
		
		JComboBox List_parcours = new JComboBox();
		List_parcours.setBounds(178, 206, 72, 22);
		choicePnl.add(List_parcours);
		
		
		List_parcours.addItem("1- Classique");
		List_parcours.addItem("2- Apprenti");
		
		
		
		
	
		
		
		
	
	}
}
