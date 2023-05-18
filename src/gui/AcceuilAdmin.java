package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import model.Admin;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class AcceuilAdmin {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin ad = new Admin(0,"0","0","0","0");
					AcceuilAdmin window = new AcceuilAdmin(ad);
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
	public AcceuilAdmin(Admin ad) {
		initialize(ad);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad) {
	
		frame = new JFrame();
		frame.setBounds(100, 100, 647, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 64, 128));
		panel.setForeground(new Color(0, 0, 0));
		panel.setBounds(10, 11, 611, 67);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\esigelec-irseem-squarelogo-1455621802282.png"));
		lblNewLabel_2.setBounds(10, 11, 104, 28);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MENU ADMIN");
		lblNewLabel_3.setLabelFor(frame);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana Pro Black", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(237, 11, 260, 38);
		panel.add(lblNewLabel_3);
		
		JLabel Labelcone = new JLabel("");
		Labelcone.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\user_21980.png"));
		Labelcone.setBounds(20, 81, 106, 112);
		frame.getContentPane().add(Labelcone);
		
		JLabel NameLabel = new JLabel(ad.getName());
		NameLabel.setBounds(136, 108, 86, 14);
		frame.getContentPane().add(NameLabel);
		
		JLabel firstnameLabel = new JLabel(ad.getFirstName());
		firstnameLabel.setBounds(136, 147, 73, 14);
		frame.getContentPane().add(firstnameLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(10, 204, 611, 269);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("GESTION DES ELEVES");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(179, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionELGUI GD = new GestionELGUI(ad);
			}
		});
		btnNewButton.setBounds(10, 22, 171, 23);
		panel_1.add(btnNewButton);
		
		JButton btnAbsences = new JButton("GESTION DES ENSEIGNANTS");
		btnAbsences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionENSGUI GE  = new GestionENSGUI(ad);
			}
		});
		btnAbsences.setForeground(new Color(0, 0, 0));
		btnAbsences.setBackground(new Color(179, 255, 255));
		btnAbsences.setBounds(219, 22, 204, 23);
		panel_1.add(btnAbsences);
		
		JButton btnAnticiper = new JButton("GESTION DES COURS");
		btnAnticiper.setForeground(new Color(0, 0, 0));
		btnAnticiper.setBackground(new Color(179, 255, 255));
		btnAnticiper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnticiper.setBounds(443, 22, 158, 23);
		panel_1.add(btnAnticiper);
		
		JButton btnNewButton_1 = new JButton("GESTION DES ABSENCES");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(new Color(179, 255, 255));
		btnNewButton_1.setBounds(62, 107, 187, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GESTION DES GROUPES");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterGroup gg = new AjouterGroup();
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setBackground(new Color(179, 255, 255));
		btnNewButton_2.setBounds(351, 107, 187, 23);
		panel_1.add(btnNewButton_2);
		
		JButton btnLogOut = new JButton("LOG OUT");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ConnectionGUI fg = new ConnectionGUI();
			}
		});
		btnLogOut.setForeground(Color.BLACK);
		btnLogOut.setBackground(new Color(179, 255, 255));
		btnLogOut.setBounds(220, 510, 171, 23);
		frame.getContentPane().add(btnLogOut);
	}
}
