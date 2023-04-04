package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Admin;
import model.Student;
import dao.StudentDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerELGUI {

	private JFrame frame;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SupprimerELGUI window = new SupprimerELGUI();
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
	public SupprimerELGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JTextField textField = new JTextField();
		textField.setBounds(169, 104, 86, 20);
		choicePnl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Entrer le nom de l'eleve ");
		lblNewLabel.setForeground(new Color(139, 0, 0));
		lblNewLabel.setBounds(21, 107, 138, 14);
		choicePnl.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("DELETE STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDAO studentDAO = new StudentDAO();
				int returnValue= studentDAO.delete(textField.getText(), textField_1.getText());
				if(returnValue!=0) {
					JOptionPane.showMessageDialog(null, "Suppression reussi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Suppression raté");
				}
				
			}
		});
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Verdana Pro Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(286, 133, 138, 23);
		choicePnl.add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(169, 157, 86, 20);
		choicePnl.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("Entrer le prénom de l'eleve ");
		lblNewLabel_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1.setBounds(21, 160, 138, 14);
		choicePnl.add(lblNewLabel_1);
	}
}
