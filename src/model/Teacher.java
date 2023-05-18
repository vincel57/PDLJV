package model;
/**
 * Classe Teacher
 * @author mavin
 *
 *
 *
 */
public class Teacher extends User {
	/**
	 * Identifiant de l'Enseignant
	 */
			private String phoneNumber;
			
			
			
	public Teacher (int id, String name, String firstName, String mail, String password, String phoneNumber) {
		super(id,name,firstName,mail,password);
					this.phoneNumber = phoneNumber;
		}


	public String getPhoneNumber() {
		return phoneNumber;
	}




	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public void display() {
		super.display();		
		System.out.println("Telephone"+phoneNumber);
		

	}




	
		
			
			
	
			
}
