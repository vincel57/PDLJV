package gui;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.Justificatory;
import dao.JustificatoryDAO;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import model.Student;

public class AjouterJusutificatoryGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Student student = new Student(0, "", "", "", "", 0, "");

					AjouterJusutificatoryGUI window = new AjouterJusutificatoryGUI(student);
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
	public AjouterJusutificatoryGUI(Student student) {
		initialize(student);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(Student student) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		 JFileChooser file_Chooser = new JFileChooser();
		    file_Chooser.setCurrentDirectory(new File("."));
		 
		    
		    file_Chooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
		      public boolean accept(File f) {
		    	 
		    	  
		        return (f.getName().toLowerCase().endsWith(".jpeg") 	||	f.getName().toLowerCase().endsWith(".jpg") ||	f.getName().toLowerCase().endsWith(".png") )
		            || f.isDirectory();
		 
		      }
		 
		      public String getDescription() {
		            return "Fichier jpeg,jpg,png";
		      }
		    });
		 
		    int r = file_Chooser.showOpenDialog(new JFrame());
		    if (r == JFileChooser.APPROVE_OPTION) {
		      String nom = file_Chooser.getSelectedFile().getName();
		      String path = file_Chooser.getSelectedFile().getPath();

		      int lastDotIndex = path.lastIndexOf(".");
		      String extension =path.substring(lastDotIndex+1);
		      System.out.println(nom);
		      System.out.println(extension);

		    // Obtenez l'image à enregistrer, par exemple en la chargeant depuis un fichier ou en la générant dynamiquement 
		    		  String outputFolderPath = "./Justificatifs/"+student.getId()+"-";

		    	        File outputFile = new File(outputFolderPath+nom);
		    	        System.out.println(outputFile);

		    	        
		 	        	   
		    	        
							try {
								BufferedImage image = ImageIO.read(new File(path));
								 // Enregistrez l'image dans le dossier spécifié
			    	            ImageIO.write(image, extension, outputFile);
			    	            System.out.println(image);
			    	            Date date = new Date();
			    	        	SimpleDateFormat format1 = new SimpleDateFormat("dd-MM-yyyy");
			    				String day = format1.format(date);
			    	            

			    	            Justificatory justificatory = new Justificatory(0,day,"en attente de validation",outputFolderPath+nom,""+student.getId());
			    	            JustificatoryDAO justif = new JustificatoryDAO();
			    	           
			    	            int returnValue= justif.add(justificatory);; 
								if(returnValue!=0) {
									JOptionPane.showMessageDialog(null, "Enregistrement reussi");
									frame.dispose();
									JustificatoryGUI jg= new JustificatoryGUI(student);
								}
								else {
									JOptionPane.showMessageDialog(null, "Enregistrement raté");
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
		    	  
		    } 
		    
		    else {
				JustificatoryGUI jg= new JustificatoryGUI(student);

		    }
	}

}
