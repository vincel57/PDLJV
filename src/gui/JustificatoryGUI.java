package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.toedter.calendar.JCalendar;

import dao.JustificatoryDAO;
import dao.SessionDAO;
import model.Justificatory;
import model.Session;
import model.Student;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JustificatoryGUI {

	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student(0, "", "", "", "", 0, "");
					JustificatoryGUI window = new JustificatoryGUI(student);
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
	public JustificatoryGUI(Student student) {
		initialize(student);
		frame.setVisible(true);
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Student student) {
		frame = new JFrame();
		frame.setBounds(100, 100, 1049, 824);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	
		JLabel lblNewLabel = new JLabel("VOS JUSTIFICATIFS");
		lblNewLabel.setBounds(256, 11, 345, 14);
		frame.getContentPane().add(lblNewLabel);

		JPanel panel = new JPanel();
		GridLayout gl_panel = new GridLayout(8, 1);
		gl_panel.setVgap(15);
		

			
		
		panel.setLayout(gl_panel);
		
	
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(10, 52, 608, 572);
		frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton = new JButton("IMPORTER ");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AjouterJusutificatoryGUI aj= new AjouterJusutificatoryGUI(student);

			}
		});
		btnNewButton.setBounds(714, 159, 159, 23);
		frame.getContentPane().add(btnNewButton);
		
		
		JustificatoryDAO justificatoryDAO = new JustificatoryDAO();
		ArrayList<Justificatory> listJustificatory = justificatoryDAO.getList(student.getId());
        Justificatory justificatory = new Justificatory(0,"","","","");

		for (int i = 0; i < listJustificatory.size(); i++) {
			
			justificatory = listJustificatory.get(i);
			JLabel justificatif_1 = new JLabel(justificatory.getValidity()+" "+justificatory.getDate());	
			justificatif_1.setIcon(new ImageIcon(justificatory.getLink()));

			
			
			justificatif_1.setName(""+i);
			
			
			
			justificatif_1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	 
	            	Object source = e.getSource();
	                if (source instanceof JLabel) {
	                	JLabel clickedTextArea = (JLabel) source;
	                    String text = clickedTextArea.getName();
	                    System.out.println("Clicked Text: " + text);
	                   
	                    String[] options = {"Confirmer", "Annuler"};
						int choice = JOptionPane.showOptionDialog(null, "Voulez vos vraiment supprimer0?", "Supprimer le justificatif",
        		                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        		        // Vérifier la réponse de l'utilisateur
        		        if (choice == 0) {

		    	            int returnValue=justificatoryDAO.delete(listJustificatory.get(Integer.parseInt(text)).getIdjustificatory());

							if(returnValue!=0) {
								JOptionPane.showMessageDialog(null, "Suppression reussi");
								frame.dispose();
								JustificatoryGUI jg= new JustificatoryGUI(student);
							}
							else {
								JOptionPane.showMessageDialog(null, "Suppression raté");
							}
        		        	
        		        } 
	            		
						


	                    
	                    
	                }
	            	
	            }
	        });
			
				panel.add(justificatif_1);
			
			
		}
		
		
		
		
	

	}
}
