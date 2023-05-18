package model;

public class Justificatory {

	private int idjustificatory;
	private String date;
	private String Validity;
	private String link;
	private String student;
	
	
		public Justificatory(int idjustificatory, String date, String validity, String link, String student) {
		super();
		this.idjustificatory=  idjustificatory;
		this.date = date;
		this.Validity = validity;
		this.link = link;
		this.student= student;
	}

		


			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public String getValidity() {
				return Validity;
			}



			public void setValidity(String validity) {
				Validity = validity;
			}



			public String getLink() {
				return link;
			}


			public void setLink(String link) {
				this.link = link;
			}



			public int getIdjustificatory() {
				return idjustificatory;
			}




			public String getStudent() {
				return student;
			}




			public void setStudent(String student) {
				this.student = student;
			}




		
		
		
}
