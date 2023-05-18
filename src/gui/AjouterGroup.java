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

import dao.GroupDAO;
import dao.StudentDAO;
import model.Group;
import model.Student;

public class AjouterGroup {

	private JFrame frame;
	private JTextField numero;
	private JTextField capacity;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					AjouterGroup window = new AjouterGroup();
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
	public AjouterGroup() {
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

		numero = new JTextField();
		numero.setBounds(168, 42, 86, 20);
		choicePnl.add(numero);
		numero.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("numero");
		lblNewLabel_1.setBounds(85, 45, 75, 17);
		choicePnl.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Capacité");
		lblNewLabel_2.setBounds(101, 76, 58, 14);
		choicePnl.add(lblNewLabel_2);

	

		JButton btnNewButton = new JButton("ADD GROUP ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Group group = new Group(0,0);
				group.setGroup_number(Integer.parseInt(numero.getText()));
				group.setCapacity(Integer.parseInt(capacity.getText()));
				
				GroupDAO groupDAO = new GroupDAO();
				if(group.getGroup_number()<=0 || group.getCapacity()<= 0) {
					JOptionPane.showMessageDialog(null, "Numero ou capacoté Negative e,trer une valeur positive");
				}
				else {
					int returnValue=groupDAO.add(group); 
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

		capacity = new JTextField();
		capacity.setColumns(10);
		capacity.setBounds(168, 73, 86, 20);
		choicePnl.add(capacity);

	

	}

}
