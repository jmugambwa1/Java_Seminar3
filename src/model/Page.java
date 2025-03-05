package model;

import java.util.ArrayList;

import model.users.RegisteredUser;

public class Page {
	// variables, getters, setters, both constructors, toString + other functions(if necessary)
	private String title;
	private String description;
	private ArrayList<RegisteredUser> followers = new  ArrayList<RegisteredUser>();
	private ArrayList<Post> posts = new ArrayList<Post>();
	
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public ArrayList<RegisteredUser> getFollowers() {
		return followers;
	}
	public ArrayList<Post> getPosts() {
		return posts;
	}
	
	 public void setTitle(String inputTitle) {
	    	if(inputTitle != null && inputTitle.matches("[A-Za-z ()]{4,40}")) {
	    		title = inputTitle;
	    	}
	    	else
	    	{
	    		title = "No title";
	    	}
	    } 
	
	public void setDescription(String inputDescription) {
		if(inputDescription != null && inputDescription.matches("[A-Za-z0-9 ().,;:]{4,300}")) {
			description = inputDescription;
		}
		else
		{
			description = "No description";
		}
	}
	
	//No setters for arraylist because they are initialized already at the start
	
	
	
	
	
	
}
