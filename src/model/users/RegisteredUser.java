package model.users;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import model.IPostCreate;
import service.MainService;

public abstract class RegisteredUser extends User implements IPostCreate{
	private String username;
	private String password;
	
	
	
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	
	public void setUsername(String inputUsername) {
		if(inputUsername!=null && inputUsername.matches("[A-Z]{1}[a-z]{6,25}")) {
			username = id + " " + inputUsername;
		}
		else
		{
			username = "No username";
		}
	}
	
	public void setPassword(String inputPassword) {
		if(inputPassword != null && inputPassword.matches("[A-Za-z0-9?*#.:;]{6,20}"))
		{
			try {
				MessageDigest md = MessageDigest.getInstance("MD5");
				md.update(inputPassword.getBytes());
				password = new String(md.digest());
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				password = "No password";
			}
		}
		else
		{
			password = "No password";
		}
	}
	
	public RegisteredUser()
	{
		super();//will call User class no argument constructor
		setUsername("test.user");
		setPassword("1234QWerty?");
		
	}
	public RegisteredUser(String inputUsername, String inputPassword) {
		super();//will call User class no argument constructor
		setUsername(inputUsername);
		setPassword(inputPassword);
	}
	
	public String toString() {
		return super.toString() + ": " + username + " (" + password+ ")";
	}
	
	public void followUser(String username) throws Exception{
		if(username == null) {
			throw new Exception("Username should not be null");
		}
		
		for(User tempU : MainService.getAllUsers()) {
			if(tempU instanceof RegisteredUser) {
				RegisteredUser tempRU = (RegisteredUser)tempU;
				if(tempRU.getUsername().equals(username))
				{
					if(tempRU instanceof PrivateUser) {
						PrivateUser tempPU = (PrivateUser)tempRU;
						tempPU.getFollowers().add(this);
					}
				}
			}
		}
		
	}
	
	
	

}
