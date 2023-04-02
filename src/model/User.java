package model;

public class User {
		protected String name;
		protected int id;
		protected String firstName;
		protected String password;
		protected String mail;
			
			public User (int id, String name, String firstName, String mail, String password) {
				this.id = id;
				this.name = name;
				this.firstName = firstName;
				this.mail = mail;
				//listArticles = new ArrayList<Article>();
				this.password = password;
	}
			
			public int getId() {
				return id;
			}
			
			public String getPassword() {
				return password;
			}
			public String getName() {
				return name;
			}
			public String getFirstName() {
				return firstName;
			}

			public String getMail() {
				return mail;
			}

			public void setMail(String mail) {
				this.mail = mail;
			}

			public void setName(String name) {
				this.name = name;
			}

			public void setId(int id) {
				this.id = id;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public void setPassword(String password) {
				this.password = password;
			}
			public void display() {
				System.out.println("Id"+id);
				System.out.println("Name"+name);
				System.out.println("First Name"+firstName);
				System.out.println("Mail"+mail);
				System.out.println("Password"+password);
			}
				
	
}

