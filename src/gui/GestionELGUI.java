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
import dao.StudentDAO;
import model.Group;
import model.Student;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class GestionELGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionELGUI window = new GestionELGUI();
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
	public GestionELGUI() {
		initialize();
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 758, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton_2 = new JButton("AJOUTER");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.dispose();
				AjouterELGUI gp = new AjouterELGUI();
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
				"ID", "Lastname", "Firstname", "Email", "Group", "Sector"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, String.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				true, false, false, true, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> listStudent = studentDAO.getList();
		for (int i = 0; i < listStudent.size(); i++) {
				model.addRow(new Object [] {listStudent.get(i).getId(), listStudent.get(i).getName(), listStudent.get(i).getFirstName(), listStudent.get(i).getMail(), listStudent.get(i).getGroup(), listStudent.get(i).getSector()});
				
		} 
		
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(643, 375, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("SUPPRIMER");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listStudent.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					frame.dispose();
					SupprimerELGUI Nes = new SupprimerELGUI( listStudent.get(table.getSelectedRow()));
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
				if(table.getSelectedRow()< 0 || table.getSelectedRow() >= listStudent.size()) {
					JOptionPane.showMessageDialog(null, "Veuillez sélectionner un élève");
				}
				else {
					frame.dispose();
					ModifieELGUI gh = new ModifieELGUI(	listStudent.get(table.getSelectedRow()));
				}
			
			}
			
		});
		btnNewButton_2_1_1.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_1.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_1.setBounds(643, 396, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("GESTION DES ELEVES");
		lblNewLabel_1.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 28));
		lblNewLabel_1.setBackground(new Color(175, 238, 238));
		lblNewLabel_1.setForeground(new Color(178, 34, 34));
		lblNewLabel_1.setBounds(254, 11, 270, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		
		
		JButton btnNewButton_2_1_2 = new JButton("RETOUR");
		btnNewButton_2_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				AcceuilAdmin GG = new AcceuilAdmin();
			}
		});
		
		btnNewButton_2_1_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_2.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		btnNewButton_2_1_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_2.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_2);
		
		
		
		
		

		
		
		
		
		
		
		
	}
}
