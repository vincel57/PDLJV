package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionELGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionELGUI window = new GestionELGUI();
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
	public GestionELGUI() {
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("AJOUTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AjouterELGUI gp = new AjouterELGUI();
			}
		});
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(183, 74, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SUPPRIMER");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				SupprimerELGUI gj = new SupprimerELGUI();
			}
		});
		btnNewButton_2_1.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 11));
		btnNewButton_2_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1.setBounds(183, 167, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1);
		
		
		JButton btnNewButton_2_1_1 = new JButton("MODIFIER");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				ModifieELGUI gh = new ModifieELGUI();
			}
			
		});
		btnNewButton_2_1_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_1.setBounds(183, 119, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION ELEVE");
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 28));
		lblNewLabel_1.setBackground(new Color(175, 238, 238));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(123, 11, 208, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
	}

}
