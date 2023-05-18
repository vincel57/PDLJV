package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Teacher;

public class AcceuilTeacher {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher teach = new Teacher(0,"","","","","");
					AcceuilTeacher window = new AcceuilTeacher(teach);
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
	public AcceuilTeacher(Teacher teach) {
		initialize(teach);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Teacher teach) {
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
		
		JLabel lblNewLabel_3 = new JLabel("MENU TEACHER");
		lblNewLabel_3.setLabelFor(frame);
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana Pro Black", Font.PLAIN, 28));
		lblNewLabel_3.setBounds(237, 11, 260, 38);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\esigelec-irseem-squarelogo-1455621802282.png"));
		lblNewLabel_2.setBounds(10, 11, 104, 28);
		panel.add(lblNewLabel_2);
		
		JLabel Labelcone = new JLabel("");
		Labelcone.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\user_21980.png"));
		Labelcone.setBounds(20, 81, 106, 112);
		frame.getContentPane().add(Labelcone);
		
		JLabel lblNewLabel = new JLabel(teach.getFirstName());
		lblNewLabel.setBounds(136, 108, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel(teach.getName());
		lblNewLabel_1.setBounds(136, 147, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setForeground(Color.BLACK);
		panel_1.setBackground(new Color(128, 0, 0));
		panel_1.setBounds(10, 204, 611, 67);
		frame.getContentPane().add(panel_1);
		
		JButton btnNewButton = new JButton("Planning");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(179, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(10, 22, 89, 23);
		panel_1.add(btnNewButton);
		
		JButton btnAbsences = new JButton("Appel");
		btnAbsences.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbsences.setForeground(new Color(0, 0, 0));
		btnAbsences.setBackground(new Color(179, 255, 255));
		btnAbsences.setBounds(257, 22, 89, 23);
		panel_1.add(btnAbsences);
		
		JButton btnAnticiper = new JButton("Synthèse");
		btnAnticiper.setForeground(new Color(0, 0, 0));
		btnAnticiper.setBackground(new Color(179, 255, 255));
		btnAnticiper.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAnticiper.setBounds(512, 22, 89, 23);
		panel_1.add(btnAnticiper);
	}

}
