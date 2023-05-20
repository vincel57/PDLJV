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
import dao.TeacherDAO;
import model.Group;
import model.Student;
import model.Teacher;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;

public class AppelGUI {

	private JFrame frame;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Teacher teach = new Teacher(0,"","","","","");
					AppelGUI window = new AppelGUI(teach);
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
	public AppelGUI(Teacher teach) {
		initialize(teach);
		frame.setVisible(true);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Teacher teach) {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(248, 248, 255));
		frame.setBounds(100, 100, 758, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setBounds(639, 62, 21, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
	/*	for(int i=0;i<list.size();i++) {
			data[i][0]=i+1;
			data[i][1]=list.get(i).getLastname()+" "+list.get(i).getFirstname();
			cb=new JCheckBox("");
			cbs.add(cb);
			data[i][2]=(Object) cb;
			
	}*/
		StudentDAO studentDAO = new StudentDAO();
		ArrayList<Student> listStudent = studentDAO.getList();
		
		JButton btnNewButton_2 = new JButton("Valider");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i< table.getRowCount();i++)
				{
					Boolean checked = (Boolean) table.getValueAt(i,3);
					if(checked)
					{
						System.out.println(listStudent.get(i).getFirstName());
					}
				}
				
				
				
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
				"Lastname", "Firstname","groupe","Absent"
			}
		) {
			Class[] columnTypes = new Class[] {
				 String.class, String.class, Integer.class, Boolean.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
			 false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		}); 
		scrollPane.setViewportView(table);
		
		DefaultTableModel model =  (DefaultTableModel)table.getModel();
		
		for (int i = 0; i < listStudent.size(); i++) {
			model.addRow(new Object [] {listStudent.get(i).getName(), listStudent.get(i).getFirstName(), listStudent.get(i).getGroup(), new Boolean(false)});
				
		} 
		
		
		btnNewButton_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2.setForeground(new Color(139, 0, 0));
		btnNewButton_2.setBounds(643, 143, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		
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
				
			//	AcceuilTeacher GG = new AcceuilTeacher(ad);
			}
		});
		
		btnNewButton_2_1_2.setForeground(new Color(178, 34, 34));
		btnNewButton_2_1_2.setFont(new Font("Verdana Pro Cond Black", Font.PLAIN, 11));
		btnNewButton_2_1_2.setBackground(new Color(135, 206, 250));
		btnNewButton_2_1_2.setBounds(10, 11, 89, 23);
		frame.getContentPane().add(btnNewButton_2_1_2);
		
	
		
		
		
		
		

		
		
		
		
		
		
		
	}
}
