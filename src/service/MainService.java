package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.PostType;
import model.users.BusinessUser;
import model.users.PrivateUser;
import model.users.User;

public class MainService {

	private static ArrayList<User> allUsers = new ArrayList<User>();
	
	
	public static void main(String[] args) {
		User u1 = new User();//Guest User
		User u2 = new User();//Guest User
		PrivateUser u3 = new PrivateUser("Joel.Mugambwa", "123abc??", "Joel", "Mugambwa");
		BusinessUser u4 = new BusinessUser("my.microsoft", "1234poiu??", "My microsoft");
		
		allUsers.addAll(Arrays.asList(u1, u2, u3, u4));
		
		
		for(User tempU: allUsers) {
			System.out.println(tempU.getClass().getName()+ "->" + tempU);
		}
		
		try {
			u3.createPost(PostType.privatePost, "I want to go home!");
			u3.createPost(PostType.publicPost, "I like JAVA!");
			
			System.out.println("Karina private posts: " + u3.getPrivatePosts());
			System.out.println("Karina public posts: " + u3.getPublicPosts());
			
			u4.createPage("Microsoft in Ventspils", "Information about STEM activities in Ventspils");
			u4.createPage("Microsoft in Riga",  "Information about STEM activities in Riga");
			
			u4.createPost(PostType.publicPost, "Hello in my page!",
					"Microsoft in Ventspils", "Microsoft in Riga" );
			
			u4.createPost(PostType.publicPost, "20% Discount for Ventspils users",
					"Microsoft in Ventspils");
			
			System.out.println("My Microsoft Ventspils page ->" + u4.getPages().get(0).getPosts());
			System.out.println("My Microsoft Riga page ->" + u4.getPages().get(1).getPosts());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}
	
	public static ArrayList<User> getAllUsers()
	{
		return allUsers;
	}

}