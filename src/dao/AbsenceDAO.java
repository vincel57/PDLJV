package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table absence
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class AbsenceDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AbsenceDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un absence dans la table absence.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param absence le absence a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Absence absence) {
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
		
		
			ps = con.prepareStatement("INSERT INTO Absence (IDSTUDENT,IDABSENCE,IDABSENCE_TYPE,DURE,JOUR) VALUES(?,seq_absence.nextVal,?,?,?)");
			
			
			ps.setString(1, absence.getStudent());
			ps.setString(2, absence.getType());
			ps.setString(2, absence.getDuration());		
			ps.setString(2, absence.getDate());
	

			

		
		
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de absence existe déjà. Ajout impossible !");
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
	 * Permet de modifier un absence dans la table absence.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param absence le absence a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Absence absence) {
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
			ps = con.prepareStatement("UPDATE absence set IDSTUDENT = ?, IDABSENCE_TYPE = ?, DURE = ?, JOUR= ? WHERE IDABSENCE = ?");
			ps.setString(1, absence.getStudent());
			ps.setString(2, absence.getType());
			ps.setString(3, absence.getDuration());		
			ps.setString(4, absence.getDate());
			ps.setString(5, absence.getStudent());

			
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
	 * Permet de supprimer un absence par id dans la table absence.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du absence à supprimer
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
			// le getter permet de recuperer la valeur de l'ID du absence
			ps = con.prepareStatement("DELETE FROM absence WHERE IDABSENCE = ?");
			ps.setInt(1, id);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce absence possede des articles, suppression impossible !"
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
	 * Permet de recuperer un absence a partir de sa reference
	 * 
	 * @param reference la reference du absence a recuperer
	 * @return le absence trouve;
	 * 			null si aucun absence ne correspond a cette reference
	 */
	public Absence get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Absence returnValue = null;
		

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL,LOGIN,PASS);
			if(con!=null) {
				System.out.println("CONNECTION SUCCESSED");
			}
			
			else
				System.out.println("CONNECTION FAILED");
			ps = con.prepareStatement("SELECT absence.idstudent, absence.idabsence,absence_type.nom AS type,absence.dure,absence.jour\r\n"
					+ "FROM absence_type INNER JOIN absence \r\n"
					+ "ON absence_type.idabsence_type= absence.idabsence_type\r\n"
					+ "INNER JOIN student \r\n"
					+ "ON absence.idstudent= student.idstudent\r\n"
					+ "WHERE absence.idabsence=1?");
			ps.setInt(1, id);
			
			
			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new Absence( rs.getInt("IDABSENCE"),
					       rs.getString("type"),
					       rs.getString("IDSTUDENT"),
					       rs.getString("jour"),
					       rs.getString("dure"));
				
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
	 * Permet de recuperer tous les absences stockes dans la table absence
	 * 
	 * @return une ArrayList de absence
	 */
	public ArrayList<Absence> getListAbsenceStudent(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Absence> returnValue = new ArrayList<Absence>();
		
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT absence.idstudent, absence.idabsence,absence_type.nom AS type,absence.dure,absence.jour\r\n"
					+ "FROM absence_type INNER JOIN absence \r\n"
					+ "ON absence_type.idabsence_type= absence.idabsence_type\r\n"
					+ "INNER JOIN student \r\n"
					+ "ON absence.idstudent= student.idstudent\r\n"
					+ "WHERE absence.idstudent=?");
			
			ps.setInt(1, id);
			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				
				returnValue.add(new Absence(rs.getInt("IDABSENCE"),
					       rs.getString("type"),
					       rs.getString("IDSTUDENT"),
					       rs.getString("jour"),
					       rs.getString("dure")));
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
	
	
	 
	 }