package model;

public class Session {


	private int idsession;
	private String start;
	private String end;
	private String date;
	private String room;
	private String name;
	private String type;
	private String matiere;
	private String teach_name;
	private int groupe_number;
	

	public Session(int idsession, String start, String end, String date, String room, String name, String type,
			String matiere, String teach_name, int groupe_number) {
		super();
		this.idsession = idsession;
		this.start = start;
		this.end = end;
		this.date = date;
		this.room = room;
		this.name = name;
		this.type = type;
		this.matiere = matiere;
		this.teach_name = teach_name;
		this.groupe_number = groupe_number;
	}


	
	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getIdsession() {
		return idsession;
	}

	public void setIdsession(int idsession) {
		this.idsession = idsession;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}



	public String getTeach_name() {
		return teach_name;
	}



	public void setTeach_name(String teach_name) {
		this.teach_name = teach_name;
	}



	public int getGroupe_number() {
		return groupe_number;
	}



	public void setGroupe_number(int groupe_number) {
		this.groupe_number = groupe_number;
	}
	
	
	


}
