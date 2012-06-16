package cz.muni.fi.pv243.backend.entitiesManagers;

import java.util.List;

import cz.muni.fi.pv243.backend.entities.User;


public interface UserManager {

	void saveUser (User user);
	void editUser (User user);
	void removeUser (User user);
	User getUser (Long id);
	List<User> getUsers();
	List<User> getUsersByLastName(String lastName);
	
	

}
