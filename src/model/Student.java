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
			private int year;
			private String sector;
			
			
			
	public Student (int id, String name, String firstName, String mail, String password,int year, String sector) {
		super(id,name,firstName,mail,password);
					this.year = year;
					this.sector = sector;
			
		}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
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
		System.out.println("Year"+year);
		System.out.println("sector"+sector);

	}
		
			
			
	
			
}
