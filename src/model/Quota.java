package model;

public class Quota {
	
	private int idquota;
	private float seuil;
	private String sanction;
	
	public Quota(int idquota, float seuil, String sanction) {
		super();
		this.idquota = idquota;
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

	public int getIdquota() {
		return idquota;
	}

	public void setIdquota(int idquota) {
		this.idquota = idquota;
	}
	
	
	
}
