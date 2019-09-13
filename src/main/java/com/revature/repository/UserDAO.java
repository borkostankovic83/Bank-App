package com.revature.repository;
import java.util.List;

import com.revature.model.User;
//DAOs are just Data Access Objects
//they're used to access data
/**
* PlayerDAO retrieves and stores data about Player objects
* 
* @author Borko Stankovic
*
*/
	public interface UserDAO {
	
	User getUser(int id);

	User getUser(String username);
	
	List<User> getUser();
	
	boolean createUser(User u);
	
	boolean updateUser(User u);

	boolean deleteUser(User u);
	
	User getUser(String username, String password);

}