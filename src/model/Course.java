package model;

public class Course {

	public Course(int idcours, String name, String totalTime, String examTime, String tDtime, String tPtime,
			String amphiTime, String teach_name) {
		super();
		this.idcours = idcours;
		this.name = name;
		TotalTime = totalTime;
		ExamTime = examTime;
		TDtime = tDtime;
		TPtime = tPtime;
		AmphiTime = amphiTime;
		this.teach_name = teach_name;
	}

	private int idcours;
	private String name;
	private String TotalTime;
	private String ExamTime;
	private String TDtime;
	private String TPtime;
	private String AmphiTime;
	private String teach_name;
	
	
	
	
	
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
	public String getTeach_name() {
		return teach_name;
	}
	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}
	public int getIdcours() {
		return idcours;
	}
	public void setIdcours(int idcours) {
		this.idcours = idcours;
	}
		

	

		
}
