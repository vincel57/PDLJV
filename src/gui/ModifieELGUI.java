package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

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

import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModifieELGUI {

	private JFrame frame;
	private JTextField nameText;
	private Student student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student(0, "hhh", "ggg", "uhhh", "nn", 0, "gre");
					ModifieELGUI window = new ModifieELGUI(student);
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
	public ModifieELGUI(Student student) {
		initialize(student);
		frame.setVisible(true);
		student.display();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Student student) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JComboBox List_parcours = new JComboBox();
		List_parcours.setBounds(182, 159, 72, 20);
		choicePnl.add(List_parcours);
		
		JComboBox List_groups = new JComboBox();
		List_groups.setBounds(182, 121, 72, 20);
		choicePnl.add(List_groups);
		
		List_parcours.addItem("Classique");
		List_parcours.addItem("Apprenti");
		List_parcours.setSelectedItem(student.getSector());
		
		
		JTextField firstnameText = new JTextField(student.getFirstName());
		firstnameText.setBounds(168, 74, 86, 20);
		choicePnl.add(firstnameText);
		firstnameText.setColumns(10);
		
		GroupDAO groupDAO = new GroupDAO();
		ArrayList<Group> listGroup = groupDAO.getList();
		for (int i = 0; i < listGroup.size(); i++) {
			List_groups.addItem(listGroup.get(i).getGroup_number());
			
		}
		List_groups.setSelectedItem(student.getGroup());

		JButton Update = new JButton("UPDATE STUDENT ");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				student.setName(nameText.getText());
				student.setFirstName(firstnameText.getText());
				student.setSector(List_parcours.getSelectedItem().toString());
				System.out.println("fff");
				System.out.println(Integer.parseInt(List_groups.getSelectedItem().toString()));
				student.setGroup(Integer.parseInt(List_groups.getSelectedItem().toString()));
				String mail= student.getFirstName()+"."+student.getName()+"@groupe-esigelec.org";
				student.setMail(mail);
				// Method to generate a random alphanumeric password of a specific length
				
			
				student.display();
				StudentDAO studentDAO = new StudentDAO();
				if(student.getName().length() == 0 || student.getFirstName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom et le prénom");
				}
				else {
					int returnValue=studentDAO.update(student); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Modification reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Modification raté");
					}
					frame.dispose();
					GestionELGUI GD = new GestionELGUI();
				}
				
				
			}
		});
		Update.setBackground(new Color(224, 255, 255));
		Update.setForeground(new Color(178, 34, 34));
		Update.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		Update.setBounds(106, 245, 216, 23);
		choicePnl.add(Update);
		
		
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(112, 45, 46, 14);
		choicePnl.add(nameLabel);
		
		JLabel firstnameLabel = new JLabel("Firstname");
		firstnameLabel.setBounds(112, 77, 46, 14);
		choicePnl.add(firstnameLabel);
		
		
		
		JLabel sectorLabel = new JLabel("sector");
		sectorLabel.setBounds(112, 162, 46, 14);
		choicePnl.add(sectorLabel);
		
		JLabel groupLabel = new JLabel("Group");
		groupLabel.setBounds(112, 121, 46, 14);
		choicePnl.add(groupLabel);
		
		nameText = new JTextField(student.getName());
		nameText.setColumns(10);
		nameText.setBounds(168, 42, 86, 20);
		choicePnl.add(nameText);
		
		
	

	}
}
