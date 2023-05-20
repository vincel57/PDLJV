package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import dao.GroupDAO;
import dao.CourseDAO;
import dao.AdminDAO;
import model.Group;
import model.Course;
import model.Admin;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class GestionMatiereGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin ad = new Admin(0,"0","0","0","0");
					GestionMatiereGUI window = new GestionMatiereGUI(ad);
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
	public GestionMatiereGUI(Admin ad) {
		initialize(ad);
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 954, 605);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("AJOUTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AjouterCoursGUI hg = new AjouterCoursGUI(ad);
				
				
			}
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 69, 753, 422);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Matiere", "totalTime", "examTime", "tDtime", "tPtime", "amphiTime","Enseignant"
			
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, true, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		scrollPane.setViewportView(table);
		
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		CourseDAO studentDAO = new CourseDAO();
		ArrayList<Course> listCourse = studentDAO.getList();
		for (int i = 0; i < listCourse.size(); i++) {
				model.addRow(new Object [] {listCourse.get(i).getName(), listCourse.get(i).getTotalTime(), listCourse.get(i).getExamTime(),listCourse.get(i).getTDtime(),listCourse.get(i).getTPtime(),listCourse.get(i).getAmphiTime(),listCourse.get(i).getTeach_name() });
				
		} 
		
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(821, 372, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SUPPRIMER");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listCourse.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					frame.dispose();
					SupprimerCourseGUI s = new SupprimerCourseGUI(listCourse.get(table.getSelectedRow()),ad);
					
				}
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Verdana Pro Cond", Font.BOLD, 11));
		btnNewButton_2_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1.setBounds(821, 440, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1);
		
		
		JButton btnNewButton_2_1_1 = new JButton("MODIFIER");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listCourse.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					
					frame.dispose();
					ModifierMatiereGUI j = new ModifierMatiereGUI(listCourse.get(table.getSelectedRow()),ad);
				
				}
			
			}
			
		});
		btnNewButton_2_1_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_1.setBounds(821, 406, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION DES COURS");
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 28));
		lblNewLabel_1.setBackground(new Color(175, 238, 238));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(254, 11, 270, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		JButton btnNewButton_2_1_2 = new JButton("RETOUR");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				AcceuilAdmin GG = new AcceuilAdmin(ad);
			}
		});
		
		btnNewButton_2_1_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_2.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		btnNewButton_2_1_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_2.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_2);
		
		JButton SessionAddButton = new JButton("ADD SESSION");
		SessionAddButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listCourse.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un cours");
				}
				else {
					AjouterSessionGUI s= new AjouterSessionGUI(ad,listCourse.get(table.getSelectedRow()));
				
					frame.dispose();
				
				}
			}
		});
		SessionAddButton.setBounds(314, 532, 195, 23);
		frame.getContentPane().add(SessionAddButton);
		
		JButton SessionAddButton_1 = new JButton("Planning");
		SessionAddButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Planning p = new Planning(ad);
			}
		});
		SessionAddButton_1.setBounds(733, 34, 195, 23);
		frame.getContentPane().add(SessionAddButton_1);
		
		
		
		
		

		
		
		
		
		
		
		
	}
}
