package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import dao.TeacherDAO;
import model.Admin;
import model.Group;
import model.Student;
import model.Teacher;

public class ModifierENSGUI {

	private JFrame frame;
	private JTextField nameText;
	private Teacher teach;
	private JTextField phoneText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher teach = new Teacher(0,"","","","","");
					Admin ad = new Admin(0,"0","0","0","0");
					ModifierENSGUI window = new ModifierENSGUI(teach,ad);
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
	public ModifierENSGUI(Teacher teach, Admin ad) {
		initialize(teach,ad);
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Teacher teach, Admin ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 349);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		
		JTextField firstnameText = new JTextField(teach.getFirstName());
		firstnameText.setBounds(168, 74, 86, 20);
		choicePnl.add(firstnameText);
		firstnameText.setColumns(10);
		
		GroupDAO groupDAO = new GroupDAO();
		ArrayList<Group> listGroup = groupDAO.getList();
		for (int i = 0; i < listGroup.size(); i++) {
			
		}

		JButton Update = new JButton("UPDATE TEACHER");
		Update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teach.setName(nameText.getText());
				teach.setFirstName(firstnameText.getText());
				teach.setPhoneNumber(phoneText.getText());
				System.out.println("fff");
				
				String mail= teach.getFirstName()+"."+teach.getName()+"@groupe-esigelec.org";
				teach.setMail(mail);
				// Method to generate a random alphanumeric password of a specific length
				
			
				teach.display();
				TeacherDAO teachDAO = new TeacherDAO();
				if(teach.getName().length() == 0 || teach.getFirstName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom et le prénom");
				}
				else {
					int returnValue=teachDAO.update(teach); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Modification reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Modification raté");
					}
					frame.dispose();
					GestionENSGUI GD = new GestionENSGUI(ad);
				}
				
				
			}
		});
		Update.setBackground(new Color(224, 255, 255));
		Update.setForeground(new Color(178, 34, 34));
		Update.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		Update.setBounds(106, 245, 216, 23);
		choicePnl.add(Update);
		
		
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(89, 45, 69, 14);
		choicePnl.add(nameLabel);
		
		JLabel firstnameLabel = new JLabel("Firstname");
		firstnameLabel.setBounds(89, 77, 69, 14);
		choicePnl.add(firstnameLabel);
		
		
		
		
		
		nameText = new JTextField(teach.getName());
		nameText.setColumns(10);
		nameText.setBounds(168, 42, 86, 20);
		choicePnl.add(nameText);
		
		JLabel lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(72, 108, 86, 14);
		choicePnl.add(lblPhoneNumber);
		
		phoneText = new JTextField(teach.getPhoneNumber());
		phoneText.setColumns(10);
		phoneText.setBounds(168, 105, 86, 20);
		choicePnl.add(phoneText);
	}
}
