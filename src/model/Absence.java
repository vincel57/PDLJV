package model;

public class Absence {
	
	private String type;
	private String student;
	private String date;
	private String duration;
	private int idabsence;

	
	
		public Absence(int idabsence,String type, String student, String date, String duration) {
		super();
		this.idabsence= idabsence;
		this.type = type;
		this.student = student;
		this.date = date;
		this.duration = duration;
		
	}
		
		
		public int getIdAbsence() {
			return idabsence;
		}
		
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getStudent() {
			return student;
		}
		public void setStudent(String student) {
			this.student = student;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		
}
