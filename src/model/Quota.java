package model;

public class Quota {
	
	private float seuil;
	private String sanction;
	
	public Quota(float seuil, String sanction) {
		super();
		this.seuil = seuil;
		this.sanction = sanction;
	}

	public float getSeuil() {
		return seuil;
	}

	public void setSeuil(float seuil) {
		this.seuil = seuil;
	}

	public String getSanction() {
		return sanction;
	}

	public void setSanction(String sanction) {
		this.sanction = sanction;
	}
	
	
	
}
