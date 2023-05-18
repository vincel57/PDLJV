package dao;

import java.sql.SQLException;

/**
 * Classe d'acces a la base de donnees
 * 
 * @author ESIGELEC - TIC Department
 * @version 2.0
 * */
public class ConnectionDAO {
	/**
	 * Parametres de connexion a la base de donnees oracle
	 * URL, LOGIN et PASS sont des constantes
	 */
	static String UrlMarvine = "jdbc:oracle:thin:@//oracle.esigelec.fr:1521/orcl.intranet.int" ;
	static String LogMarvine = "C##BDD2_18";
	static String PassMarvine = "BDD218";
	static String UrlJarfino = "jdbc:oracle:thin:@//oracle.esigelec.fr:1521/orcl.intranet.int" ;
	static String LogJarfino = "C##BDD2_15";
	static String PassJarfino = "BDD215";
	// � utiliser si vous �tes sur une machine personnelle :
	//final static String URL   = "jdbc:oracle:thin:@oracle.esigelec.fr:1521:orcl";
	
	// � utiliser si vous �tes sur une machine de l'�cole :
	final static String URL   = UrlJarfino;
	final static String LOGIN = LogJarfino;   // remplacer les ********. Exemple C##BDD1_1
	final static String PASS  = PassJarfino;   // remplacer les ********. Exemple BDD11
	
	/**n  
	 * Constructor
	 * 
	 */
	public ConnectionDAO() {
		// chargement du pilote de bases de donnees
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			System.out.println("CO reussi");
		} catch (ClassNotFoundException e) {
			System.err.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier .jar dans le projet");
		}
	}
	
	public static void main(String[] args) throws SQLException {
		ConnectionDAO connectionDAO  = new ConnectionDAO ();
		
	}
}