package model;

public class Justificatory {

		private String type;
		private String date;
		private boolean Validity;
		
			public Justificatory(String type, String date, boolean validity) {
				super();
				this.type = type;
				this.date = date;
				Validity = validity;
	}

			public String getType() {
				return type;
			}

			public void setType(String type) {
				this.type = type;
			}

			public String getDate() {
				return date;
			}

			public void setDate(String date) {
				this.date = date;
			}

			public boolean isValidity() {
				return Validity;
			}

		
		
		
}
