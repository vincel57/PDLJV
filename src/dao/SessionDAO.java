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
public class SessionDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public SessionDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un eleve dans la table cours.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param cours le eleve a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Session sess) {
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
			
			ps = con.prepareStatement("INSERT INTO seance (idseance,debut, fin,dateseance,room,name,idsession_type,groupe_number,id_course) VALUES(?, ?, ?, ?, ?, ?, ?,?,?)");
			ps.setInt(1, sess.getIdsession());
			ps.setString(2, sess.getStart());
			ps.setString(3, sess.getEnd());
			ps.setString(4, sess.getDate());
			ps.setString(5, sess.getRoom());
			ps.setString(6, sess.getName());
			ps.setString(7, sess.getType());
			ps.setInt(8, sess.getGroupe_number());
			ps.setString(9, sess.getMatiere());

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
	public int update(Session sess) {
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
			ps = con.prepareStatement("UPDATE seance set debut = ?, fin = ?, dateseance = ?, room= ?, name= ?,idsession_type=?, id_course=? ,WHERE idseance = ?");

			ps.setString(1, sess.getStart());
			ps.setString(2, sess.getEnd());
			ps.setString(3, sess.getDate());
			ps.setString(4, sess.getRoom());
			ps.setString(5, sess.getName());
			ps.setString(6, sess.getType());
			ps.setString(7, sess.getMatiere());
			ps.setInt(8, sess.getIdsession());	
			
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
			ps = con.prepareStatement("DELETE FROM seance WHERE idseance = ?");
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
	public Session get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Session returnValue = null;
		String sector= "Sector undefined";

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			if(con!=null) {
				System.out.println("CONNECTION SUCCESSED");
			}
			
			else
				System.out.println("CONNECTION FAILED");
			ps = con.prepareStatement("SELECT * FROM seance WHERE idseance = ?");
			ps.setInt(1, id);
	
		//	int idsession, String start, String end, String date, String room, String name, String type,
		//	String matiere, String teach_name, int groupe_numbe			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				System.out.println("ID"+rs.getInt("idseance"));
				returnValue = new Session(rs.getInt("idseance"),
									       rs.getString("debut"),
									       rs.getString("fin"),
									       rs.getString("dateseance"),
									       rs.getString("room"),
									       rs.getString("name"),
									       rs.getString("idsession_type"),
									       rs.getString("id_course"),
									       rs.getString("teach_name"),
									       rs.getInt("groupe_number"));
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
	public ArrayList<Session> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Session> returnValue = new ArrayList<Session>();
		

		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM seance");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				
				
				returnValue.add(new Session(rs.getInt("idseance"),
					       rs.getString("debut"),
					       rs.getString("fin"),
					       rs.getString("dateseance"),
					       rs.getString("room"),
					       rs.getString("name"),
					       rs.getString("idsession_type"),
					       rs.getString("id_course"),
					       rs.getString("teach_name"),
					       rs.getInt("groupe_number")));
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