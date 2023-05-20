package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.AbsenceTypeDAO;
import dao.StudentDAO;
import model.Group;
import model.Student;
import model.AbsenceType;

public class AjouterAbsenceType {

	private JFrame frame;
	private JTextField id;
	private JTextField type;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AjouterAbsenceType window = new AjouterAbsenceType();
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
	public AjouterAbsenceType() {
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

		id = new JTextField();
		id.setBounds(168, 42, 86, 20);
		choicePnl.add(id);
		id.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("id");
		lblNewLabel_1.setBounds(114, 45, 46, 14);
		choicePnl.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Type");
		lblNewLabel_2.setBounds(101, 76, 58, 14);
		choicePnl.add(lblNewLabel_2);

	

		JButton btnNewButton = new JButton("ADD TYPE ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AbsenceType abs = new AbsenceType(0,"");
				abs.setId(Integer.parseInt(id.getText()));
				abs.setType(type.getText());
				
				AbsenceTypeDAO absdao = new AbsenceTypeDAO();
				if(abs.getType().length() <=0) {
					JOptionPane.showMessageDialog(null, "Entrer un type");
				}
				else {
					int returnValue=absdao.add(abs); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Enregistrement reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enregistrement raté");
					}
					
					frame.dispose();
				//	AcceuilAdmin gf = new AcceuilAdmin();
				}
				

			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 274, 216, 23);
		choicePnl.add(btnNewButton);

		type = new JTextField();
		type.setColumns(10);
		type.setBounds(168, 73, 86, 20);
		choicePnl.add(type);

	

	}

}
