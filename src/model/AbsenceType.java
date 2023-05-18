package model;

public class AbsenceType {
		
	
	private int id;
	private String type;
	
	
		public AbsenceType(int id, String type) {
		super();
		this.id = id;
		this.type = type;
	}



			public int getId() {
				return id;
			}



			public void setId(int id) {
				this.id = id;
			}



			public String getType() {
				return type;
			}



			public void setType(String type) {
				this.type = type;
			}
			

			public void display() {
				System.out.println("Id"+id);
				System.out.println("Type"+type);

				
			}
				
	
}

