package dao;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table cours
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class CourseDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public CourseDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un eleve dans la table cours.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param cours le eleve a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Course cours) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;
	

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans l'insertion.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("INSERT INTO course (idcourse ,nom, totalTime, examTime, tDtime, tPtime, amphiTime, idteacher) VALUES(seq_course.nextVal, ?, ?, ?, ?, ?, ?, ?)");
			ps.setInt(1, cours.getIdcours());
			ps.setString(2, cours.getName());
			ps.setString(3, cours.getTotalTime());
			ps.setString(4, cours.getExamTime());
			ps.setString(5, cours.getTDtime());
			ps.setString(6, cours.getTPtime());			
			ps.setString(7, cours.getAmphiTime());
			ps.setString(8, cours.getTeach_name());


			// Execution de la requete
			returnValue = ps.executeUpdate();
				
		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de eleve existe déjà. Ajout impossible !");
			else {
				e.printStackTrace();
				
			}
				
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de modifier un eleve dans la table cours.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param cours le eleve a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Course cours) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, chaque ? represente une valeur
			// a communiquer dans la modification.
			// les getters permettent de recuperer les valeurs des attributs souhaites
			ps = con.prepareStatement("UPDATE course set name = ?, totalTime = ?, examTime = ?, tDtime= ?, tPtime= ?, amphitime=? ,WHERE idcourse = ?");
			
			ps.setString(1, cours.getName());
			ps.setString(2, cours.getTotalTime());
			ps.setString(3, cours.getExamTime());
			ps.setString(4, cours.getTDtime());
			ps.setString(5, cours.getTPtime());			
			ps.setString(6, cours.getAmphiTime());
			ps.setInt(7, cours.getIdcours());
			
			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de supprimer un eleve par id dans la table cours.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du cours à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du eleve
			ps = con.prepareStatement("DELETE FROM course WHERE idcours = ?");
			ps.setInt(1, id);
			
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce eleve possede des articles, suppression impossible !"
						         + " Supprimer d'abord ses articles ou utiiser la méthode de suppression avec articles.");
			else
				e.printStackTrace();
		} finally {
			// fermeture du preparedStatement et de la connexion
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}


	/**
	 * Permet de recuperer un eleve a partir de sa reference
	 * 
	 * @param reference la reference du eleve a recuperer
	 * @return le eleve trouve;
	 * 			null si aucun eleve ne correspond a cette reference
	 */
	public Course get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Course returnValue = null;
		String sector= "Sector undefined";

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			if(con!=null) {
				System.out.println("CONNECTION SUCCESSED");
			}
			
			else
				System.out.println("CONNECTION FAILED");
			ps = con.prepareStatement("SELECT idcourse, nom, totalTime, examTime, tDtime, tPtime, amphiTime,teacher.firstname || ' ' || teacher.lastname AS teacher FROM course INNER JOIN teacher ON teacher.idteacher=course.idteacher WHERE idcourse = ?");
			ps.setInt(1, id);
	

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				System.out.println("ID"+rs.getInt("IDSTUDENT"));
				returnValue = new Course(rs.getInt("IDCOURSE"),
									       rs.getString("name"),
									       rs.getString("totalTime"),
									       rs.getString("examTime"),
									       rs.getString("tDtime"),
									       rs.getString("tPtime"),
									       rs.getString("amphiTime"),
									       rs.getString("teacher"));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du ResultSet, du PreparedStatement et de la Connexion
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (ps != null) {
					ps.close();
				}
			} catch (Exception ignore) {
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	/**
	 * Permet de recuperer tous les eleves stockes dans la table eleve
	 * 
	 * @return une ArrayList de eleve
	 */
	public ArrayList<Course> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Course> returnValue = new ArrayList<Course>();
		String sector= "Sector undefined";

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT idcourse, nom, totalTime, examTime, tDtime, tPtime, amphiTime,teacher.firstname || ' ' || teacher.lastname AS teacher FROM course INNER JOIN teacher ON teacher.idteacher=course.idteacher");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				
				
				returnValue.add(new Course(rs.getInt("idcourse"),
					       rs.getString("nom"),
					       rs.getString("totalTime"),
					       rs.getString("examTime"),
					       rs.getString("tDtime"),
					       rs.getString("tPtime"),
					       rs.getString("amphiTime"),
					       rs.getString("teacher")));
			}
		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			// fermeture du rs, du preparedStatement et de la connexion
			try {
				if (rs != null)
					rs.close();
			} catch (Exception ignore) {
			}
			try {
				if (ps != null)
					ps.close();
			} catch (Exception ignore) {
			}
			try {
				if (con != null)
					con.close();
			} catch (Exception ignore) {
			}
		}
		return returnValue;
	}

	
	/**
	 * ATTENTION : Cette méthode n'a pas vocation à être executée lors d'une utilisation normale du programme !
	 * Elle existe uniquement pour TESTER les méthodes écrites au-dessus !
	 * 
	 * @param args non utilisés
	 * @throws SQLException si une erreur se produit lors de la communication avec la BDD
	 */
	
	
	 public static void main(String[] args) throws SQLException {
		int returnValue;
		CourseDAO coursDAO = new CourseDAO();
		
	
		
		// test de la methode getList
		ArrayList<Course> list = coursDAO.getList();
		for (Course s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
	
	}
}