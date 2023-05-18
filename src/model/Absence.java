package model;

public class Absence {
	
	private String type;
	private String hour;
	private String date;
	private String duration;
	private int idabsence;
	private boolean isJustified;
	
	
		public Absence(int idabsence,String type, String hour, String date, String duration, boolean isJustified) {
		super();
		this.idabsence= idabsence;
		this.type = type;
		this.hour = hour;
		this.date = date;
		this.duration = duration;
		this.isJustified = isJustified;
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
		public String getHour() {
			return hour;
		}
		public void setHour(String hour) {
			this.hour = hour;
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
