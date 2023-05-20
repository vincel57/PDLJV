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
import dao.TeacherDAO;
import dao.CourseDAO;
import model.Admin;
import model.Group;
import model.Teacher;
import model.Course;

import java.awt.event.ActionListener;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ModifierMatiereGUI {

	private JFrame frame;
	private JTextField nameText;
	private Course cours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Course cours = new Course(8, "", "", "", "", "", "","");
					Admin ad = new Admin(0,"0","0","0","0");
					ModifierMatiereGUI window = new ModifierMatiereGUI(cours, ad);
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
	public ModifierMatiereGUI(Course cours, Admin ad) {
		initialize(cours,ad);
		frame.setVisible(true);
		cours.display();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Course cours, Admin ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);

		JTextField matiereText = new JTextField(cours.getName());
		matiereText.setBounds(168, 42, 86, 20);
		choicePnl.add(matiereText);
		matiereText.setColumns(10);
		

		JTextField totalTimeText = new JTextField(cours.getTotalTime());
		totalTimeText.setColumns(10);
		totalTimeText.setBounds(168, 73, 86, 20);
		choicePnl.add(totalTimeText);
		//"Matiere", "totalTime", "examTime", "tDtime", "tPtime", "amphiTime","Enseignant"
		
		JTextField examTimeText = new JTextField(cours.getExamTime());
		examTimeText.setColumns(10);
		examTimeText.setBounds(168, 104, 86, 20);
		choicePnl.add(examTimeText);
		
		JTextField	tdTimeText = new JTextField(cours.getTDtime());
		tdTimeText.setColumns(10);
		tdTimeText.setBounds(168, 135, 86, 20);
		choicePnl.add(tdTimeText);
		
		JTextField tpTimeText = new JTextField(cours.getTPtime());
		tpTimeText.setColumns(10);
		tpTimeText.setBounds(168, 166, 86, 20);
		choicePnl.add(tpTimeText);
		

		JTextField	amphiTimeText = new JTextField(cours.getAmphiTime());
		amphiTimeText.setColumns(10);
		amphiTimeText.setBounds(168, 206, 86, 20);
		choicePnl.add(amphiTimeText);
		

		JLabel matiereLabel = new JLabel("Matiere");
		matiereLabel.setBounds(114, 45, 46, 14);
		choicePnl.add(matiereLabel);

		JLabel totalTimeLabel = new JLabel("totalTime");
		totalTimeLabel.setBounds(101, 76, 58, 14);
		choicePnl.add(totalTimeLabel);

		JComboBox List_teach = new JComboBox();
		List_teach.setBounds(168, 243, 172, 20);
		choicePnl.add(List_teach);

		TeacherDAO teachDAO = new TeacherDAO();
		ArrayList<Teacher> listTeacher = teachDAO.getList();
		for (int i = 0; i < listTeacher.size(); i++) {
			List_teach.addItem(listTeacher.get(i).getName()+" "+listTeacher.get(i).getFirstName());
		

		}
		

		JButton CourseAddButton = new JButton("UPDATE COURSE ");

		
		CourseAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int idcours, String name, String totalTime, String examTime, String tDtime, String tPtime,
				String amphiTime, String teach_name*/
				Course cours = new Course(8, "", "", "", "", "", "","");
				cours.setName(matiereText.getText());
				cours.setTotalTime(totalTimeText.getText());
				cours.setTDtime(tdTimeText.getText());
				cours.setTPtime(tpTimeText.getText());
				cours.setAmphiTime(amphiTimeText.getText());
				cours.setTeach_name(""+listTeacher.get(List_teach.getSelectedIndex()).getId());
				
			
		

			
				//cours.set
				System.out.println(List_teach.getSelectedItem().toString());;
				CourseDAO coursDAO = new CourseDAO();
				if(cours.getName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom de la matiere");
				}
				else {
					int returnValue=coursDAO.update(cours);
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Enregistrement reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enregistrement raté");
					}
					
					frame.dispose();
					GestionMatiereGUI GD = new GestionMatiereGUI(ad); 
				}
				

			}
		});
		CourseAddButton.setBackground(new Color(224, 255, 255));
		CourseAddButton.setForeground(new Color(178, 34, 34));
		CourseAddButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		CourseAddButton.setBounds(101, 274, 216, 23);
		choicePnl.add(CourseAddButton);

	


		JLabel examTimeLabel = new JLabel("examtime");
		examTimeLabel.setBounds(114, 107, 46, 14);
		choicePnl.add(examTimeLabel);

		JLabel teacherLabel = new JLabel("Teacher");
		teacherLabel.setBounds(114, 240, 46, 14);
		choicePnl.add(teacherLabel);
		
		
		
		JLabel tdTimeLabel = new JLabel("tdtime");
		tdTimeLabel.setBounds(114, 138, 46, 14);
		choicePnl.add(tdTimeLabel);
		
		JLabel tpTimeLabel = new JLabel("tptime");
		tpTimeLabel.setBounds(114, 169, 46, 14);
		choicePnl.add(tpTimeLabel);
		
		JButton TeacherAddButton = new JButton("ADD TEACHER");
		TeacherAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AjouterENSGUI ju = new AjouterENSGUI(ad);
				
			}
		});
		TeacherAddButton.setBounds(300, 28, 110, 23);
		choicePnl.add(TeacherAddButton);
		
		JLabel amphiTimeLabel = new JLabel("AmphiTime");
		amphiTimeLabel.setBounds(101, 205, 59, 14);
		choicePnl.add(amphiTimeLabel);
		
	

	}
}
