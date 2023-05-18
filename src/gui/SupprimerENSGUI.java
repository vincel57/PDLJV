package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dao.TeacherDAO;
import model.Admin;
import model.Teacher;

public class SupprimerENSGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher teach = new Teacher(0,"","","","","");
					Admin ad = new Admin(0,"0","0","0","0");
					SupprimerENSGUI window = new SupprimerENSGUI(teach,ad);
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
	public SupprimerENSGUI(Teacher teach, Admin ad) {
		initialize(teach, ad);
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Teacher teach, Admin ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JLabel NameChamp = new JLabel("Nom et prénom de l'Enseignant ");
		NameChamp.setForeground(new Color(139, 0, 0));
		NameChamp.setBounds(21, 107, 138, 14);
		choicePnl.add(NameChamp);
		
		JButton btnNewButton = new JButton("DELETE STUDENT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TeacherDAO teachDAO = new TeacherDAO();
				int returnValue=teachDAO.delete(teach.getId()); 
				if(returnValue!=0) {
					JOptionPane.showMessageDialog(null, "Suppression reussi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Suppression raté");
				}
				frame.dispose();
				GestionENSGUI GD = new GestionENSGUI(ad); 
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
				GestionENSGUI GD = new GestionENSGUI(ad);
			}
			
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Verdana Pro Semibold", Font.PLAIN, 11));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(288, 302, 92, 23);
		choicePnl.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Voulez-vous vraiment supprimer cet Enseignant? ");
		lblNewLabel_1_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 21));
		lblNewLabel_1_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1_1.setBounds(67, 11, 448, 37);
		choicePnl.add(lblNewLabel_1_1);
		
		JLabel NamesuppLabel = new JLabel(teach.getName()+" "+teach.getFirstName());
		NamesuppLabel.setBounds(179, 107, 266, 14);
		choicePnl.add(NamesuppLabel);
		
		JLabel sectorChamp = new JLabel("Phone Number");
		sectorChamp.setForeground(new Color(139, 0, 0));
		sectorChamp.setBounds(21, 146, 138, 14);
		choicePnl.add(sectorChamp);
		
		JLabel sectorsuppLabel = new JLabel(teach.getPhoneNumber());
		sectorsuppLabel.setBounds(179, 146, 266, 14);
		choicePnl.add(sectorsuppLabel);
		
		
		
		

	}

}
