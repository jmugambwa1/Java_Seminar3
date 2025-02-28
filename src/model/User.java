package model;

public class User {
	private int id;
	
	private static int counter = 0;
	
	
	
	public int getId() {
		return id;
	}
	
	public void setID() {
		id = counter++;
	}
	
	public User() {
		setID();
	}
	
	public String toString() {
		return id + "";
	}
	

}
