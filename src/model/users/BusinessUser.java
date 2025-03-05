package model.users;

import java.util.ArrayList;

import model.Page;
import model.Post;
import model.PostType;

public class BusinessUser extends RegisteredUser{
	
	private String businessName;
	private ArrayList<Page> pages = new ArrayList<Page>();
	
	//getters
	public String getBusinessName() {
		return businessName;
	}


	public ArrayList<Page> getPages() {
		return pages;
	}
	
	//setters
	public void setBusinessname(String inputBusinessName) {
		if(inputBusinessName!= null && inputBusinessName.matches("[A-Z]{1}[a-z]{2,20}")) {
			businessName = inputBusinessName;
		}
		else
		{
			businessName = "No business Name";
		}
	}
	
	//no setter for pages
	
	public BusinessUser() {
		super();
		setBusinessname("Test Business name");
		
	}
	
	public BusinessUser(String inputUsername, String inputPassword,String inputBusinessName) {
		super(inputUsername,inputPassword);
		setBusinessname(inputBusinessName);
	}
	
	public String toString() {
		return super.toString() + " " + businessName;
	}
	
	


	@Override
	public void createPost(PostType postType, String... params) throws Exception {
		if(postType == null || params == null) {
			throw new Exception("Params should be not null");
		}
		if(params.length < 2)
		{
			throw new Exception("There is no msg and page as input params");
		}
		
		
		Post newPost = new Post(params[0]);
		
		for(Page tempP : pages) {
			for(int i = 1; i < params.length; i++) {
				if(tempP.getTitle().equals(params[i]))
				{
					tempP.getPosts().add(newPost);
				}
			}
		}
		
		
	}
	public void createPage(String inputTitle, String inputDescription) throws Exception {
		if(inputTitle == null || inputDescription == null) {
			throw new Exception("Params should be not null");
		}
	

		for(Page tempP : pages)
		{
			if(tempP.getTitle().equals(inputTitle)) {
				throw new Exception("The page already exists");
			}
		}
		Page newPage = new Page(inputTitle, inputDescription);
		pages.add(newPage);
		
	}

}
