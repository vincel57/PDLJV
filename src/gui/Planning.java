package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import model.Session;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import com.toedter.calendar.demo.DemoTable;
import java.awt.BorderLayout;
import com.toedter.plaf.JCalendarTheme;

import dao.StudentDAO;
import model.Student;
import oracle.sql.DATE;

import com.toedter.calendar.JCalendarBeanInfo;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooserBeanInfo;
import com.toedter.calendar.demo.DateChooserPanel;
import com.toedter.calendar.JDateChooser;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class Planning {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				
					Planning window = new Planning();
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
	public Planning() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 971, 614);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Session se= new Session(4,"08h","9h","17/05/2001","D1287","rhhh","TP","ATS","CABOT",2);
		JLabel titre = new JLabel("Date du jour");
		titre.setBounds(439, 28, 90, 14);
		frame.getContentPane().add(titre);
		
		
		
		JCalendar calendar = new JCalendar();
	
		
				
				
		calendar.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(calendar.getDate());
				Calendar cal = Calendar.getInstance();
			int day=cal.get(Calendar.DAY_OF_MONTH);
			System.out.println(calendar.getDayChooser());

	
				SimpleDateFormat format1 = new SimpleDateFormat("E dd-MM-yyyy");
				String date = format1.format(calendar.getDate());
				titre.setText(date);
			
				

			//	System.out.println(date);
				
			}
		});
		calendar.setBounds(47, 59, 255, 291);
		frame.getContentPane().add(calendar);
		
		

		
		
		
		
		
		JPanel panel = new JPanel();
		GridLayout gl_panel = new GridLayout(5, 1);
		gl_panel.setVgap(15);
		panel.setLayout(gl_panel);

		JTextArea textArea1 = new JTextArea(se.getType()+"\r\n"+se.getName()+"\r\n"+se.getRoom()+"\r\n"+se.getStart()+"-"+se.getEnd()+"\r\n"+2);
		textArea1.setEditable(false);
		textArea1.setName(""+1);
		JTextArea textArea2 = new JTextArea(se.getType()+"\r\n"+se.getName()+"\r\n"+se.getRoom()+"\r\n"+se.getStart()+"-"+se.getEnd()+"\r\n"+3);
		textArea2.setEditable(false);
		panel.add(textArea1);
		panel.add(textArea2);

		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setBounds(374, 53, 392, 359);
		frame.getContentPane().add(scrollPane);

		textArea1.addMouseListener(new MouseAdapter() {
	            public void mouseClicked(MouseEvent e) {
	 
	            	Object source = e.getSource();
	                if (source instanceof JTextArea) {
	                    JTextArea clickedTextArea = (JTextArea) source;
	                    String text = clickedTextArea.getName();
	                    System.out.println("Clicked Text: " + text);
	                }
	            	
	            }
	        });
		// Ajouter le JSplitPane à un autre conteneur principal

		//se.getType()+"\r\n"+se.getName()+"\r\n"+se.getRoom()+"\r\n"+se.getStart()+"-"+se.getEnd()
		
	
		  
		
	
		

		
		  


		      
		
		
		
		
	}
}

