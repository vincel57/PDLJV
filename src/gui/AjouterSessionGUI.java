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
import dao.SessionDAO;
import model.Admin;
import model.Course;
import model.Group;
import model.Teacher;
import model.Session;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;

import com.toedter.calendar.JCalendar;

public class AjouterSessionGUI {

	private JFrame frame;
	private JTextField nomText;
	private JTextField salleText;
	private JTextField dateText;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin ad = new Admin(0,"0","0","0","0");
					Course cours = new Course(0, "", "", "", "", "", "","");

					AjouterSessionGUI window = new AjouterSessionGUI(ad,cours);
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
	public AjouterSessionGUI(Admin ad, Course cours) {
		initialize(ad,cours);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad, Course cours) {
		frame = new JFrame();
		frame.setBounds(100, 100, 868, 601);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel choicePnl = new JPanel();
		frame.getContentPane().add(choicePnl);
		choicePnl.setLayout(null);
		
		JCalendar calendar = new JCalendar();
		calendar.setBounds(342, 316, 205, 153);
		choicePnl.add(calendar);

		nomText = new JTextField();
		nomText.setBounds(170, 29, 86, 20);
		choicePnl.add(nomText);
		nomText.setColumns(10);
		//"Matiere", "totalTime", "examTime", "tDtime", "tPtime", "amphiTime","Enseignant"

		JLabel nomLabel = new JLabel("Nom");
		nomLabel.setBounds(114, 32, 46, 14);
		choicePnl.add(nomLabel);

		JLabel debutLabel = new JLabel("Heure de debut");
		debutLabel.setBounds(75, 75, 97, 14);
		choicePnl.add(debutLabel);

		
		JComboBox sessionTypeText = new JComboBox();
		sessionTypeText.setBounds(170, 168, 86, 20);
		choicePnl.add(sessionTypeText);
		
		sessionTypeText.addItem("Cours Magistral");
		sessionTypeText.addItem("TP");
		sessionTypeText.addItem("TD");
		sessionTypeText.addItem("Examen");
		sessionTypeText.addItem("Rattrapage");
		
		
		SessionDAO sessionDAO = new SessionDAO();
		ArrayList<Session> listSession = sessionDAO.getList();
		
	
		
		JComboBox list_group = new JComboBox();
		list_group.setBounds(170, 199, 88, 20);
		choicePnl.add(list_group);

		GroupDAO groupDAO = new GroupDAO();
		ArrayList<Group> listGroup = groupDAO.getList();
		for (int i = 0; i < listGroup.size(); i++) {
			list_group.addItem(listGroup.get(i).getGroup_number());
		}
		
		JComboBox list_debut = new JComboBox();
		list_debut.setBounds(168, 72, 86, 20);
		choicePnl.add(list_debut);
		
		list_debut.addItem("08:30");
		list_debut.addItem("09:00");
		list_debut.addItem("09:30");
		list_debut.addItem("10:00");
		list_debut.addItem("10:30");
		list_debut.addItem("11:00");
		list_debut.addItem("11:30");
		list_debut.addItem("12:00");
		list_debut.addItem("12:30");
		list_debut.addItem("13:00");
		list_debut.addItem("13:30");
		list_debut.addItem("14:00");
		list_debut.addItem("14:30");
		list_debut.addItem("15:00");
		list_debut.addItem("15:30");
		list_debut.addItem("16:00");
		list_debut.addItem("16:30");
		list_debut.addItem("17:00");
		list_debut.addItem("17:30");
		list_debut.addItem("18:00");
		list_debut.addItem("18:30");
		list_debut.addItem("19:00");
		list_debut.addItem("19:30");
		
		
		JComboBox list_fin = new JComboBox();
		list_fin.setBounds(168, 103, 86, 20);
		choicePnl.add(list_fin);
		
		
		list_fin.addItem("08:30");
		list_fin.addItem("09:00");
		list_fin.addItem("09:30");
		list_fin.addItem("10:00");
		list_fin.addItem("10:30");
		list_fin.addItem("11:00");
		list_fin.addItem("11:30");
		list_fin.addItem("12:00");
		list_fin.addItem("12:30");
		list_fin.addItem("13:00");
		list_fin.addItem("13:30");
		list_fin.addItem("14:00");
		list_fin.addItem("14:30");
		list_fin.addItem("15:00");
		list_fin.addItem("15:30");
		list_fin.addItem("16:00");
		list_fin.addItem("16:30");
		list_fin.addItem("17:00");
		list_fin.addItem("17:30");
		list_fin.addItem("18:00");
		list_fin.addItem("18:30");
		list_fin.addItem("19:00");
		list_fin.addItem("19:30");
		
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(calendar.getDate());
				Calendar cal = Calendar.getInstance();
			int day=cal.get(Calendar.DAY_OF_MONTH);
			System.out.println(calendar.getDayChooser());

	
				SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
				String date = format1.format(calendar.getDate());
				dateText.setText(""+date);
				
				
				
		
				
			}
		});

		JButton SessionAddButton = new JButton("ADD SESSION ");
		SessionAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
				Session session = new Session(0, "", "", "", "", "", "","","",0);
				session.setName(nomText.getText());
				session.setStart(""+list_debut.getSelectedItem());
				session.setEnd(""+list_fin.getSelectedItem());
				session.setRoom(salleText.getText());
				session.setDate(dateText.getText());
				session.setType(""+(sessionTypeText.getSelectedIndex()+1));
				session.setMatiere(""+cours.getIdcours());
				session.setGroupe_number(Integer.parseInt(list_group.getSelectedItem().toString()));
				
				
				
				
			
				


			int drapeau=0;
				//session.set
				System.out.println(list_group.getSelectedItem().toString());;
				SessionDAO sessionDAO = new SessionDAO();
				if(list_debut.getSelectedIndex()>= list_fin.getSelectedIndex() ) {
					JOptionPane.showMessageDialog(null, " l'heure de fin doit etre superieure à celle du debut ");
					drapeau++;
				}
				else {
					LocalTime heuredebut = LocalTime.parse(session.getStart()+":00");
					LocalTime heurefin = LocalTime.parse(session.getEnd()+":00");
					for (int i = 0; i < listSession.size(); i++) {
						LocalTime startHour = LocalTime.parse(listSession.get(i).getStart()+":00");
						LocalTime endHour = LocalTime.parse(listSession.get(i).getEnd()+":00");
						if((heuredebut.isAfter(startHour) && heuredebut.isBefore(endHour)) && (heurefin.isAfter(startHour) && heurefin.isBefore(endHour)) && (session.getGroupe_number()== listSession.get(i).getGroupe_number()) && (session.getDate().equals(listSession.get(i).getDate())) ) {
							JOptionPane.showMessageDialog(null, " Creneau non disponible pour ce groupe ");
							drapeau++;

							i =  listSession.size()+20;
						}
						

					}
					
				}
				if (drapeau==0){
					int returnValue=sessionDAO.add(session); 
					if(returnValue!=0) {
						JOptionPane.showMessageDialog(null, "Enregistrement reussi");
					}
					else {
						JOptionPane.showMessageDialog(null, "Enregistrement raté");
					}
					
					frame.dispose();
					Planning p = new Planning();
				}
				

			}
		});
		SessionAddButton.setBackground(new Color(224, 255, 255));
		SessionAddButton.setForeground(new Color(178, 34, 34));
		SessionAddButton.setFont(new Font("Verdana Pro Cond Semibold", Font.PLAIN, 15));
		SessionAddButton.setBounds(331, 477, 216, 23);
		choicePnl.add(SessionAddButton);

		JLabel finLabel = new JLabel("Heure de fin ");
		finLabel.setBounds(75, 106, 85, 14);
		choicePnl.add(finLabel);

		JLabel groupeLabel = new JLabel("Groupe");
		groupeLabel.setBounds(114, 202, 46, 14);
		choicePnl.add(groupeLabel);
		
		salleText = new JTextField();
		salleText.setColumns(10);
		salleText.setBounds(168, 135, 86, 20);
		choicePnl.add(salleText);
		
		dateText = new JTextField(""+cours.getName());
		dateText.setEditable(false);
		dateText.setColumns(10);
		dateText.setBounds(413, 285, 86, 20);
		choicePnl.add(dateText);
		
		JLabel salleLabel = new JLabel("Salle");
		salleLabel.setBounds(114, 138, 46, 14);
		choicePnl.add(salleLabel);
		
		JLabel sessionLabel = new JLabel("Choisir la date ");
		sessionLabel.setBounds(318, 291, 85, 14);
		choicePnl.add(sessionLabel);
		
		JLabel typeLabel = new JLabel("type de session");
		typeLabel.setBounds(75, 171, 86, 14);
		choicePnl.add(typeLabel);
		
		
		
	
		
		

	}
}
