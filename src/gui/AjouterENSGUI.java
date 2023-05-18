package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.GroupDAO;
import dao.TeacherDAO;
import model.Admin;
import model.Group;
import model.Teacher;

public class AjouterENSGUI {

	private JFrame frame;
	private JTextField name;
	private JTextField firstname;
	private JTextField phoneN;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin ad = new Admin(0,"0","0","0","0");
					AjouterENSGUI window = new AjouterENSGUI(ad);
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
	public AjouterENSGUI(Admin ad) {
		initialize(ad);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad ) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 319);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);

		name = new JTextField();
		name.setBounds(168, 42, 86, 20);
		choicePnl.add(name);
		name.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(114, 45, 46, 14);
		choicePnl.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(101, 76, 58, 14);
		choicePnl.add(lblNewLabel_2);

		JButton btnNewButton = new JButton("ADD TEACHER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Teacher teacher = new Teacher(0, "", "", "", "", "");
				teacher.setName(name.getText());
				teacher.setFirstName(firstname.getText());
				teacher.setPhoneNumber(phoneN.getText());
			
				System.out.println("fff");

				
				String mail= teacher.getFirstName()+"."+teacher.getName()+"@groupe-esigelec.org";
				teacher.setMail(mail);
				// Method to generate a random alphanumeric password of a specific length
				int len = 5;

				// ASCII range – alphanumeric (0-9, a-z, A-Z)
				final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

				SecureRandom random = new SecureRandom();
				StringBuilder sb = new StringBuilder();

				// each iteration of the loop randomly chooses a character from the given
				// ASCII range and appends it to the `StringBuilder` instance

				for (int i = 0; i < len; i++) {
					int randomIndex = random.nextInt(chars.length());
					sb.append(chars.charAt(randomIndex));
				}
				teacher.setPassword(sb.toString());
				teacher.display();
				TeacherDAO teacherDAO = new TeacherDAO();
				if(teacher.getName().length() == 0 || teacher.getFirstName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom et le prénom");
				}
				else {
					int returnValue=teacherDAO.add(teacher); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Enregistrement reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enregistrement raté");
					}
					
					frame.dispose();
				GestionENSGUI GD = new GestionENSGUI(ad); 
				}
				

			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(103, 196, 216, 23);
		choicePnl.add(btnNewButton);

		

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(168, 73, 86, 20);
		choicePnl.add(firstname);
		
		phoneN = new JTextField();
		phoneN.setColumns(10);
		phoneN.setBounds(168, 109, 86, 20);
		choicePnl.add(phoneN);
		
		JLabel phone = new JLabel("PhoneNumber");
		phone.setBounds(84, 112, 76, 14);
		choicePnl.add(phone);
	}
}
