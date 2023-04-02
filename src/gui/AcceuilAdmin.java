package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
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
					AcceuilAdmin window = new AcceuilAdmin();
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
	public AcceuilAdmin() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 562, 385);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("MENU ADMIN");
		lblNewLabel_2.setLabelFor(frame);
		lblNewLabel_2.setForeground(new Color(0, 128, 128));
		lblNewLabel_2.setFont(new Font("Verdana Pro Black", Font.PLAIN, 28));
		lblNewLabel_2.setBounds(252, 38, 233, 100);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\1519892537247.jpeg"));
		lblNewLabel.setBounds(10, 11, 192, 128);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("GESTION DES ENSEIGNANTS");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_1.setForeground(new Color(178, 34, 34));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(322, 275, 195, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("GESTION DES COURS ");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_2.setBounds(392, 206, 144, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("GESTION DES ABSENCES");
		btnNewButton_3.setForeground(new Color(178, 34, 34));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_3.setBounds(53, 275, 179, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("GESTION DES COURS ");
		btnNewButton_4.setForeground(new Color(178, 34, 34));
		btnNewButton_4.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_4.setBounds(213, 206, 149, 23);
		frame.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("GESTION DES ELEVES");
		btnNewButton_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GestionELGUI GD = new GestionELGUI();
			}
		});
		btnNewButton_4_1.setForeground(new Color(178, 34, 34));
		btnNewButton_4_1.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		btnNewButton_4_1.setBounds(23, 206, 149, 23);
		frame.getContentPane().add(btnNewButton_4_1);
	}
}
