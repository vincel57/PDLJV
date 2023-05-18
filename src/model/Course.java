package model;

public class Course {

	private int idcours;
	private String name;
	private String TotalTime;
	private String ExamTime;
	private String TDtime;
	private String TPtime;
	private String AmphiTime;
	
	
	
	public Course(int idcours, String name, String totalTime, String examTime, String tDtime, String tPtime, String amphiTime) {
		this.idcours= idcours;
		this.name = name;
		TotalTime = totalTime;
		ExamTime = examTime;
		TDtime = tDtime;
		TPtime = tPtime;
		AmphiTime = amphiTime;
		
	}

	public int getIdCours() {
		return idcours;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTotalTime() {
		return TotalTime;
	}


	public void setTotalTime(String totalTime) {
		TotalTime = totalTime;
	}


	public String getExamTime() {
		return ExamTime;
	}


	public void setExamTime(String examTime) {
		ExamTime = examTime;
	}


	public String getTDtime() {
		return TDtime;
	}


	public void setTDtime(String tDtime) {
		TDtime = tDtime;
	}


	public String getTPtime() {
		return TPtime;
	}


	public void setTPtime(String tPtime) {
		TPtime = tPtime;
	}


	public String getAmphiTime() {
		return AmphiTime;
	}


	public void setAmphiTime(String amphiTime) {
		AmphiTime = amphiTime;
	}
	
	public void display() {
		System.out.println("Cours"+name);
		System.out.println("Temps total"+TotalTime);
	}
		

	

		
}
