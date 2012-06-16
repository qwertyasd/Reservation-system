package cz.muni.fi.pv243.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import cz.muni.fi.pv243.backend.entities.Admin;
import cz.muni.fi.pv243.backend.entities.Person;
import cz.muni.fi.pv243.backend.entities.User;

@Stateless
public class Users {
	
	@Produces
	@Named
	public List<Person> getUsers(){
		System.out.println("Getting users");
		ArrayList<Person> ret = new ArrayList<Person>();
		ret.add(new User(1L,"6A767D77C765", "Pavel", "Trubka", "patru", "pavel@trubka.cz", "789456123", true) );
		ret.add(new Admin(2L,"9B98787F87EA", "Franta", "Dlouhý", "admin", "admin@sportoviste.cz", "123654798") );
		ret.add(new User(3L,"4365C65B65EF", "Tonda", "Nekouk", "neky", "neky@seznam.cz", "777666555", false) );
		return ret;
	}

	@Named
	public void addUser(User user){
		System.out.println("Adding user " + user);
	}

	@Named
	public void removeUser(long id){
		System.out.println("Removing user " + id);
	}

	@Named
	public void acceptUser(long id){
		System.out.println("Accepting user " + id);
	}
	
	@Named
	public Person getUser(long id){
		System.out.println("Getting user " + id);
		return new User(id,new Integer((int) (id*63872874)).toString(), "Tery", "Marry", "tem", "Terry@gmail.com", "53523524", id % 2 == 0);
	}

}
