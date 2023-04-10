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
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student(0, "hhh", "ggg", "uhhh", "nn", 0, "gre");
					SupprimerELGUI window = new SupprimerELGUI(student);
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
	public SupprimerELGUI(Student student) {
		initialize(student);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Student student) {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JLabel NameChamp = new JLabel("Nom et prénom de l'élève ");
		NameChamp.setForeground(new Color(139, 0, 0));
		NameChamp.setBounds(21, 107, 138, 14);
		choicePnl.add(NameChamp);
		
		JButton btnNewButton = new JButton("DELETE STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StudentDAO studentDAO = new StudentDAO();
				int returnValue=studentDAO.delete(student.getId()); 
				if(returnValue!=0) {
					JOptionPane.showMessageDialog(null, "Suppression reussi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Suppression raté");
				}
				frame.dispose();
				GestionELGUI GD = new GestionELGUI(); 
			}
		});
		btnNewButton.setForeground(new Color(139, 0, 0));
		btnNewButton.setFont(new Font("Verdana Pro Semibold", Font.PLAIN, 11));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(397, 302, 138, 23);
		choicePnl.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("RETOUR");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionELGUI GD = new GestionELGUI(); 
			}
			
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Verdana Pro Semibold", Font.PLAIN, 11));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(288, 302, 92, 23);
		choicePnl.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Voulez-vous vraiment supprimer cet élève? ");
		lblNewLabel_1_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 21));
		lblNewLabel_1_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1_1.setBounds(67, 11, 448, 37);
		choicePnl.add(lblNewLabel_1_1);
		
		JLabel NamesuppLabel = new JLabel(student.getName()+" "+student.getFirstName());
		NamesuppLabel.setBounds(179, 107, 266, 14);
		choicePnl.add(NamesuppLabel);
		
		JLabel sectorChamp = new JLabel("Sector");
		sectorChamp.setForeground(new Color(139, 0, 0));
		sectorChamp.setBounds(21, 146, 138, 14);
		choicePnl.add(sectorChamp);
		
		JLabel GroupChamp = new JLabel("Group");
		GroupChamp.setForeground(new Color(139, 0, 0));
		GroupChamp.setBounds(21, 179, 138, 14);
		choicePnl.add(GroupChamp);
		
		JLabel sectorsuppLabel = new JLabel(student.getSector());
		sectorsuppLabel.setBounds(179, 146, 266, 14);
		choicePnl.add(sectorsuppLabel);
		
		JLabel groupsuppLabel = new JLabel(""+student.getGroup());
		groupsuppLabel.setBounds(179, 179, 266, 14);
		choicePnl.add(groupsuppLabel);
		
		
	}
}
