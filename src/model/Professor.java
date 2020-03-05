package model;

public class Professor {
	private String name;
	private String id;
	
	public Professor(String n, String i) {
		name = n;
		id = i;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
