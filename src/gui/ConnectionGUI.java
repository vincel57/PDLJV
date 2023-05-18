package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import dao.AdminDAO;
import dao.StudentDAO;
import dao.TeacherDAO;
import model.Admin;
import model.Student;
import model.Teacher;


import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class ConnectionGUI {

	private JFrame frame;
	private JTextField textField;
	private JFrame frame2;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectionGUI window = new ConnectionGUI();
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
	public ConnectionGUI() {
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame = new JFrame();
		frame.setTitle("CONNEXION");
		frame.setBounds(100, 100, 515, 335);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JButton btnNewButton = new JButton("LOG IN ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String password = new String(passwordField.getPassword());
				AdminDAO adminDAO = new AdminDAO();
				StudentDAO studentDAO = new StudentDAO();
				TeacherDAO teacherDAO = new TeacherDAO();
				Admin sg = null;
				Student st = null;
				Teacher se = null;
				 sg = adminDAO.get( Integer.parseInt(textField.getText()), password);
				 st = studentDAO.get( Integer.parseInt(textField.getText()), password);
				 se = teacherDAO.get( Integer.parseInt(textField.getText()), password);

				if(sg != null && st == null && se == null) {
					System.out.println("User"+textField.getText());
					System.out.println("MDP"+password); 		
					frame.dispose();
					AcceuilAdmin GG = new AcceuilAdmin(sg);
				}
				else if(st != null && sg==null && se == null)
				{
					System.out.println("User"+textField.getText());
					System.out.println("MDP"+password); 		
					frame.dispose();
					st.display();
					AcceuilStudent GS = new AcceuilStudent(st);
				}
				else if(se != null && sg==null && st == null) {
					System.out.println("User"+textField.getText());
					System.out.println("MDP"+password); 		
					frame.dispose();
					se.display();
					AcceuilTeacher Ge = new AcceuilTeacher(se);
					
				}
				else 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Identifiant ou mot de passe incorect", "Dialog",
							JOptionPane.ERROR_MESSAGE);
				}
		
			}

			private void displayAdmin(int id) {
				// TODO Auto-generated method stub
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setForeground(new Color(178, 34, 34));
		btnNewButton.setBounds(200, 241, 126, 23);
		choicePnl.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\mavin\\Downloads\\esig.png"));
		lblNewLabel_1.setBounds(23, 0, 419, 108);
		choicePnl.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(91, 132, 371, 20);
		choicePnl.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setBounds(55, 135, 32, 14);
		choicePnl.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setBounds(40, 193, 46, 14);
		choicePnl.add(lblNewLabel_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(91, 190, 371, 20);
		choicePnl.add(passwordField);
		
	}
	
	
	
}
