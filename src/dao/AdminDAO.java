package dao;
import java.sql.*;
import java.util.ArrayList;
import model.*;

/**
 * Classe d'acces aux donnees contenues dans la table admin
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class AdminDAO extends ConnectionDAO {
	/**
	 * Constructor
	 * 
	 */
	public AdminDAO() {
		super();
	}

	/**
	 * Permet d'ajouter un admin dans la table admin.
	 * Le mode est auto-commit par defaut : chaque insertion est validee
	 * 
	 * @param admin le admin a ajouter
	 * @return retourne le nombre de lignes ajoutees dans la table
	 */
	public int add(Admin admin) {
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
			
			
		
			ps = con.prepareStatement("INSERT INTO admin(id, name, fistName, mail, password) VALUES(?, ?, ?, ?, ?)");
			
			ps.setInt(1, admin.getId());
			ps.setString(2, admin.getName());
			ps.setString(3, admin.getFirstName());
			ps.setString(4, admin.getMail());
			ps.setString(5, admin.getPassword());
		
			

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-00001"))
				System.out.println("Cet identifiant de admin existe déjà. Ajout impossible !");
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
	 * Permet de modifier un admin dans la table admin.
	 * Le mode est auto-commit par defaut : chaque modification est validee
	 * 
	 * @param admin le admin a modifier
	 * @return retourne le nombre de lignes modifiees dans la table
	 */
	public int update(Admin admin) {
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
			ps = con.prepareStatement("UPDATE admin set name = ?, firstName = ?, mail = ?, password= ? WHERE id = ?");
			ps.setString(1, admin.getName());
			ps.setString(2, admin.getFirstName());
			ps.setString(3, admin.getMail());
			ps.setString(4, admin.getPassword());
			ps.setInt(5, admin.getId());
			
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
	 * Permet de supprimer un admin par id dans la table admin.
	 * Si ce dernier possede des articles, la suppression n'a pas lieu.
	 * Le mode est auto-commit par defaut : chaque suppression est validee
	 * 
	 * @param id l'id du admin à supprimer
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
			// le getter permet de recuperer la valeur de l'ID du admin
			ps = con.prepareStatement("DELETE FROM admin WHERE id = ?");
			ps.setInt(1, id);

			// Execution de la requete
			returnValue = ps.executeUpdate();

		} catch (Exception e) {
			if (e.getMessage().contains("ORA-02292"))
				System.out.println("Ce admin possede des articles, suppression impossible !"
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
	 * Permet de recuperer un admin a partir de sa reference
	 * 
	 * @param reference la reference du admin a recuperer
	 * @return le admin trouve;
	 * 			null si aucun admin ne correspond a cette reference
	 */
	public Admin get(int id, String password) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin returnValue = null;
		

		// connexion a la base de donnees
		try {

			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM admin WHERE id = ? AND password= ?");
			ps.setInt(1, id);
			ps.setString(2, password);

			// on execute la requete
			// rs contient un pointeur situe juste avant la premiere ligne retournee
			rs = ps.executeQuery();
			// passe a la premiere (et unique) ligne retournee
			if (rs.next()) {
				
				returnValue = new Admin(rs.getInt("id"),
									       rs.getString("name"),
									       rs.getString("firstName"),
									       rs.getString("mail"),
									       rs.getString("password"));
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
	 * Permet de recuperer tous les admins stockes dans la table admin
	 * 
	 * @return une ArrayList de admin
	 */
	public ArrayList<Admin> getList() {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Admin> returnValue = new ArrayList<Admin>();
		
		// connexion a la base de donnees
		try {
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM admin ORDER BY id");

			// on execute la requete
			rs = ps.executeQuery();
			// on parcourt les lignes du resultat
			while (rs.next()) {
				
				
				returnValue.add(new Admin(rs.getInt("id"),
					       rs.getString("name"),
					       rs.getString("firstName"),
					       rs.getString("mail"),
					       rs.getString("password")));
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
	
	/*
	 public static void main(String[] args) throws SQLException {
		int returnValue;
		AdminDAO adminDAO = new AdminDAO();
		// Ce test va utiliser directement votre BDD, on essaie d'éviter les collisions avec vos données en prenant de grands ID
		int[] ids = {424242, 424243, 424244};
		// test du constructeur
		Admin s1 = new Admin(ids[0], "Mon admin principal", "Rouen", "monadminprincipal@mail.com");
		Admin s2 = new Admin(ids[1], "Mon admin secondaire", "Le Havre", "monadminsecondaire@mail.com");
		Admin s3 = new Admin(ids[2], "Mon admin de secours", "Paris", "monadminsecours@mail.com");
		// test de la methode add
		returnValue = adminDAO.add(s1);
		System.out.println(returnValue + " admin ajoute");
		returnValue = adminDAO.add(s2);
		System.out.println(returnValue + " admin ajoute");
		returnValue = adminDAO.add(s3);
		System.out.println(returnValue + " admin ajoute");
		System.out.println();
		
		// test de la methode get
		Admin sg = adminDAO.get(1);
		// appel implicite de la methode toString de la classe Object (a eviter)
		System.out.println(sg);
		System.out.println();
		
		// test de la methode getList
		ArrayList<Admin> list = adminDAO.getList();
		for (Admin s : list) {
			// appel explicite de la methode toString de la classe Object (a privilegier)
			System.out.println(s.toString());
		}
		System.out.println();
		// test de la methode delete
		// On supprime les 3 articles qu'on a créé
		returnValue = 0;
		for (int id : ids) {
//			returnValue = adminDAO.delete(id);
			System.out.println(returnValue + " admin supprime");
		}
		
		System.out.println();
	}
*/}