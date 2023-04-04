package model;

public class Group {
		
	
	private int group_number;
	private int capacity;
	
	
		public Group(int group_number, int capacity) {
		super();
		this.group_number = group_number;
		this.capacity = capacity;
	}


			public int getGroup_number() {
				return group_number;
			}

			public void setGroup_number(int group_number) {
				this.group_number = group_number;
			}

			public int getCapacity() {
				return capacity;
			}

			public void setCapacity(int capacity) {
				this.capacity = capacity;
			}
			public void display() {
				System.out.println("Numero"+group_number);
				System.out.println("Capacité"+capacity);

				
			}
				
	
}

