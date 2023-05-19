package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import dao.AdminDAO;
import dao.GroupDAO;
import dao.TeacherDAO;
import dao.CourseDAO;
import model.Admin;
import model.Group;
import model.Teacher;
import model.Course;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import java.util.ArrayList;

public class AjouterCoursGUI {

	private JFrame frame;
	private JTextField matiereText;
	private JTextField totalTimeText;
	private JTextField examTimeText;
	private JTextField tdTimeText;
	private JTextField tpTimeText;
	private JTextField amphiTimeText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin ad = new Admin(0,"0","0","0","0");
					AjouterCoursGUI window = new AjouterCoursGUI(ad);
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
	public AjouterCoursGUI(Admin ad) {
		initialize(ad);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 361);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);

		matiereText = new JTextField();
		matiereText.setBounds(168, 42, 86, 20);
		choicePnl.add(matiereText);
		matiereText.setColumns(10);
		//"Matiere", "totalTime", "examTime", "tDtime", "tPtime", "amphiTime","Enseignant"

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
		

		JButton CourseAddButton = new JButton("ADD COURSE ");
		CourseAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*int idcours, String name, String totalTime, String examTime, String tDtime, String tPtime,
				String amphiTime, String teach_name*/
				Course cours = new Course(8, "", "", "", "", "", "","");
				cours.setName(matiereText.getText());
				cours.setTotalTime(totalTimeText.getText());
				cours.setExamTime(tdTimeText.getText());
				cours.setTDtime(tdTimeText.getText());
				cours.setTPtime(tpTimeText.getText());
				cours.setAmphiTime(amphiTimeText.getText());
			
				List_teach.getSelectedIndex();
				cours.setTeach_name(""+listTeacher.get(List_teach.getSelectedIndex()).getId());


			
				//cours.set
				System.out.println(List_teach.getSelectedItem().toString());;
				CourseDAO coursDAO = new CourseDAO();
				if(cours.getName().length() == 0) {
					JOptionPane.showMessageDialog(null, " Entrez le nom de la matiere");
				}
				else {
					int returnValue=coursDAO.add(cours); 
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

	

		totalTimeText = new JTextField();
		totalTimeText.setColumns(10);
		totalTimeText.setBounds(168, 73, 86, 20);
		choicePnl.add(totalTimeText);

		JLabel examTimeLabel = new JLabel("examtime");
		examTimeLabel.setBounds(114, 107, 46, 14);
		choicePnl.add(examTimeLabel);

		JLabel teacherLabel = new JLabel("Teacher");
		teacherLabel.setBounds(114, 240, 46, 14);
		choicePnl.add(teacherLabel);
		
		examTimeText = new JTextField();
		examTimeText.setColumns(10);
		examTimeText.setBounds(168, 104, 86, 20);
		choicePnl.add(examTimeText);
		
		tdTimeText = new JTextField();
		tdTimeText.setColumns(10);
		tdTimeText.setBounds(168, 135, 86, 20);
		choicePnl.add(tdTimeText);
		
		tpTimeText = new JTextField();
		tpTimeText.setColumns(10);
		tpTimeText.setBounds(168, 166, 86, 20);
		choicePnl.add(tpTimeText);
		
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
		
		amphiTimeText = new JTextField();
		amphiTimeText.setColumns(10);
		amphiTimeText.setBounds(168, 206, 86, 20);
		choicePnl.add(amphiTimeText);

	}
}
