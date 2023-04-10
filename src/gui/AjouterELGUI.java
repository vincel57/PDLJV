package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.AdminDAO;
import dao.GroupDAO;
import dao.StudentDAO;
import model.Group;
import model.Student;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import java.util.ArrayList;

public class AjouterELGUI {

	private JFrame frame;
	private JTextField name;
	private JTextField firstname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AjouterELGUI window = new AjouterELGUI();
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
	public AjouterELGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);

		name = new JTextField();
		name.setBounds(168, 42, 86, 20);
		choicePnl.add(name);
		name.setColumns(10);

		JComboBox List_groups = new JComboBox();
		List_groups.setBounds(182, 165, 72, 20);
		choicePnl.add(List_groups);

		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(114, 45, 46, 14);
		choicePnl.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Firstname");
		lblNewLabel_2.setBounds(101, 76, 58, 14);
		choicePnl.add(lblNewLabel_2);

		JComboBox List_parcours = new JComboBox();
		List_parcours.setBounds(182, 196, 72, 20);
		choicePnl.add(List_parcours);

		List_parcours.addItem("Classique");
		List_parcours.addItem("Apprenti");

		JButton btnNewButton = new JButton("ADD STUDENT ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Student student = new Student(0, "", "", "", "", 0, "");
				student.setName(name.getText());
				student.setFirstName(firstname.getText());
				student.setSector(List_parcours.getSelectedItem().toString());
				System.out.println("fff");
				System.out.println(Integer.parseInt(List_groups.getSelectedItem().toString()));
				student.setGroup(Integer.parseInt(List_groups.getSelectedItem().toString()));
				String mail= student.getFirstName()+"."+student.getName()+"@groupe-esigelec.org";
				student.setMail(mail);
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
				student.setPassword(sb.toString());
				student.display();
				StudentDAO studentDAO = new StudentDAO();
				if(student.getName().length() == 0 || student.getFirstName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom et le prénom");
				}
				else {
					int returnValue=studentDAO.add(student); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Enregistrement reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enregistrement raté");
					}
					
					frame.dispose();
					GestionELGUI GD = new GestionELGUI(); 
				}
				

			}
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		btnNewButton.setBounds(101, 274, 216, 23);
		choicePnl.add(btnNewButton);

		GroupDAO groupDAO = new GroupDAO();
		ArrayList<Group> listGroup = groupDAO.getList();
		for (int i = 0; i < listGroup.size(); i++) {
			List_groups.addItem(listGroup.get(i).getGroup_number());

		}

		firstname = new JTextField();
		firstname.setColumns(10);
		firstname.setBounds(168, 73, 86, 20);
		choicePnl.add(firstname);

		JLabel lblNewLabel_1_4 = new JLabel("Group");
		lblNewLabel_1_4.setBounds(114, 168, 46, 14);
		choicePnl.add(lblNewLabel_1_4);

		JLabel lblNewLabel_1_4_1 = new JLabel("Sector");
		lblNewLabel_1_4_1.setBounds(114, 199, 46, 14);
		choicePnl.add(lblNewLabel_1_4_1);

	}
}
