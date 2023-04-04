package model;
/**
 * Classe Student
 * @author mavin
 *
 *
 *
 */
public class Student extends User {
	/**
	 * Identifiant de l'Student
	 */
			private int group_number;
			private String sector;
			
			
			
	public Student (int id, String name, String firstName, String mail, String password,int group_number, String sector) {
		super(id,name,firstName,mail,password);
					this.group_number = group_number;
					this.sector = sector;
			
		}


	public int getGroup() {
		return group_number;
	}


	public void setGroup(int group_number) {
		this.group_number = group_number;
	}


	public String getSector() {
		return sector;
	}


	public void setSector(String sector) {
		this.sector = sector;
	}
	
	@Override
	public void display() {
		super.display();		
		System.out.println("Group"+group_number);
		System.out.println("sector"+sector);

	}
		
			
			
	
			
}
