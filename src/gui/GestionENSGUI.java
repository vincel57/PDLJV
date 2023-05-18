package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import dao.TeacherDAO;
import model.Admin;
import model.Teacher;

public class GestionENSGUI {

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
					GestionENSGUI window = new GestionENSGUI(ad);
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
	public GestionENSGUI(Admin ad) {
		initialize(ad);
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Admin ad) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 758, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("AJOUTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AjouterENSGUI gs = new AjouterENSGUI(ad); 
			}
		
		});
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 59, 612, 422);
		frame.getContentPane().add(scrollPane);
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Lastname", "Firstname", "Email", "Tel"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		TeacherDAO studentDAO = new TeacherDAO();
		ArrayList<Teacher> listTeacher = studentDAO.getList();
		for (int i = 0; i < listTeacher.size(); i++) {
				model.addRow(new Object [] {listTeacher.get(i).getId(), listTeacher.get(i).getName(), listTeacher.get(i).getFirstName(), listTeacher.get(i).getMail(), listTeacher.get(i).getPhoneNumber()});
				
		} 
		
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(643, 375, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SUPPRIMER");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listTeacher.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					frame.dispose();
					SupprimerENSGUI Nes = new SupprimerENSGUI( listTeacher.get(table.getSelectedRow()), ad);
				}
				
			}
		});
		btnNewButton_2_1.setFont(new Font("Verdana Pro Cond", Font.PLAIN, 11));
		btnNewButton_2_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1.setBounds(643, 419, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1);
		
		
		JButton btnNewButton_2_1_1 = new JButton("MODIFIER");
		btnNewButton_2_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(table.getSelectedRow());
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listTeacher.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					frame.dispose();
					ModifierENSGUI g = new ModifierENSGUI(listTeacher.get(table.getSelectedRow()),ad);
				}

			}
			
		});
		btnNewButton_2_1_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_1.setBounds(643, 396, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION DES ENSEIGNANTS");
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 28));
		lblNewLabel_1.setBackground(new Color(175, 238, 238));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(175, 11, 373, 52);
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
	}

}
