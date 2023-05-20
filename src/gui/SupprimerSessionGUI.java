package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Admin;
import model.Session;
import dao.SessionDAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SupprimerSessionGUI {

	private JFrame frame;
	private Session session;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Session session = new Session(0, "", "", "", "", "", "","","",0);
					Admin ad = new Admin(0,"0","0","0","0");
					SupprimerSessionGUI window = new SupprimerSessionGUI(session,ad);
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
	public SupprimerSessionGUI(Session session, Admin ad) {
		initialize(session,ad);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Session session, Admin ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 586, 389);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JLabel NameChamp = new JLabel("Nom du session ");
		NameChamp.setForeground(new Color(139, 0, 0));
		NameChamp.setBounds(21, 107, 138, 14);
		choicePnl.add(NameChamp);
		
		JButton btnNewButton = new JButton("DELETE SESSION");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				SessionDAO sessionDAO = new SessionDAO();
				int returnValue=sessionDAO.delete(session.getIdsession()); 
				if(returnValue!=0) {
					JOptionPane.showMessageDialog(null, "Suppression reussi");
				}
				else {
					JOptionPane.showMessageDialog(null, "Suppression raté");
				}
				frame.dispose();
				GestionMatiereGUI ff = new GestionMatiereGUI(ad);
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
				GestionMatiereGUI ff = new GestionMatiereGUI(ad);			}
			
		});
		btnNewButton_1.setForeground(new Color(139, 0, 0));
		btnNewButton_1.setFont(new Font("Verdana Pro Semibold", Font.PLAIN, 11));
		btnNewButton_1.setBackground(new Color(135, 206, 250));
		btnNewButton_1.setBounds(288, 302, 92, 23);
		choicePnl.add(btnNewButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Voulez-vous vraiment supprimer ce session ?");
		lblNewLabel_1_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 21));
		lblNewLabel_1_1.setForeground(new Color(139, 0, 0));
		lblNewLabel_1_1.setBounds(67, 11, 448, 37);
		choicePnl.add(lblNewLabel_1_1);
		
		JLabel NamesuppLabel = new JLabel(session.getName());
		NamesuppLabel.setBounds(179, 107, 266, 14);
		choicePnl.add(NamesuppLabel);
		
		JLabel CoursLabl = new JLabel("Cours");
		CoursLabl.setForeground(new Color(139, 0, 0));
		CoursLabl.setBounds(21, 146, 138, 14);
		choicePnl.add(CoursLabl);
		
		JLabel courssuppLabel = new JLabel(session.getMatiere());
		courssuppLabel.setBounds(179, 146, 266, 14);
		choicePnl.add(courssuppLabel);
		
		JLabel lblSession = new JLabel("Session");
		lblSession.setForeground(new Color(139, 0, 0));
		lblSession.setBounds(21, 199, 138, 14);
		choicePnl.add(lblSession);
		
		JLabel sesssupplabel = new JLabel(session.getStart()+""+session.getEnd());
		sesssupplabel.setBounds(179, 199, 266, 14);
		choicePnl.add(sesssupplabel);
		
		
		
		
	}
}
