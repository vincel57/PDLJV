package gui;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import dao.GroupDAO;
import model.Group;
import model.Teacher;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelectionGroupeGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher teach = new Teacher(0,"","","","","");
					SelectionGroupeGUI window = new SelectionGroupeGUI(teach);
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
	public SelectionGroupeGUI(Teacher teach) {
		initialize(teach);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Teacher teach) {
		frame = new JFrame();
		frame.setBounds(100, 100, 340, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(151, 103, 30, 22);
		frame.getContentPane().add(comboBox);
		
		GroupDAO groupDAO = new GroupDAO();
		ArrayList<Group> listGroup = groupDAO.getList();
		for (int i = 0; i < listGroup.size(); i++) {
			comboBox.addItem(listGroup.get(i).getGroup_number());

		}
		
		JLabel lblNewLabel = new JLabel("Selectionnez le Groupe");
		lblNewLabel.setBounds(92, 72, 117, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("APPEL");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AppelGUI a = new AppelGUI(teach);
			}
		});
		btnNewButton.setBounds(120, 154, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
