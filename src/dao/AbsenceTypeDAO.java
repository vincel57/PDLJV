package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table group
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class AbsenceTypeDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AbsenceTypeDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un group dans la table group.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param group le group a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(AbsenceType abstype) {
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
			
			
		
			ps = con.prepareStatement("INSERT INTO Absence_Type (idabsence_type,nom) VALUES(?, ?)");
			
			
			ps.setInt(1, abstype.getId());
			ps.setString(2, abstype.getType());
		
		
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de type d'absence existe déjà. Ajout impossible !");
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
	 * Permet de modifier un group dans la table group.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param group le group a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(AbsenceType abstype) {
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
			ps = con.prepareStatement("UPDATE Absence_Type set nom = ?, WHERE idabsence_type = ?");
			ps.setInt(1, abstype.getId());
			ps.setString(2, abstype.getType());
		
			
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
	 * Permet de supprimer un group par id dans la table group.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du group à supprimer
	 * @return retourne le nombre de lignes supprimees dans la table
	 */
	public int delete(String nom) {
		Connection con = null;
		PreparedStatement ps = null;
		int returnValue = 0;

		// connexion a la base de donnees
		try {

			// tentative de connexion
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			// preparation de l'instruction SQL, le ? represente la valeur de l'ID
			// a communiquer dans la suppression.
			// le getter permet de recuperer la valeur de l'ID du group
			ps = con.prepareStatement("DELETE FROM Absence_Type WHERE nom = ?");
			ps.setString(1, nom);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce group possede des articles, suppression impossible !"
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
	 * Permet de recuperer un group a partir de sa reference
	 * 
	 * @param reference la reference du group a recuperer
	 * @return le group trouve;
	 * 			null si aucun group ne correspond a cette reference
	 */
	public AbsenceType get(int id) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		AbsenceType returnValue = null;
		

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL,LOGIN,PASS);
			if(con!=null) {
				System.out.println("CONNECTION SUCCESSED");
			}
			
			else
				System.out.println("CONNECTION FAILED");
			ps = con.prepareStatement("SELECT * FROM Absence_Type WHERE idabsence_type= ?");
			ps.setInt(1, id);
			


			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				returnValue = new AbsenceType(rs.getInt("id"),	     
									       rs.getString("nom"));
				returnValue.display();
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
	 * Permet de recuperer tous les groups stockes dans la table group
	 * 
	 * @return une ArrayList de group
	 */
	public ArrayList<AbsenceType> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<AbsenceType> returnValue = new ArrayList<AbsenceType>();
		
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM Absence_Type ORDER BY idabsence_type");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				
				returnValue.add(new AbsenceType(rs.getInt("id"),	     
					       rs.getString("nom")));
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
	//	int returnValue;
		AbsenceTypeDAO groupDAO = new AbsenceTypeDAO();
			groupDAO.getList().get(0).display();
			
			}
	 }