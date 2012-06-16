package cz.muni.fi.pv243.backend.entities;

import javax.persistence.Entity;


@Entity
public class Admin extends Person {
	
	
	public Admin(Long id, String password, String firstName, String lastName, String login, String email, String tel) {
		super(id, password, firstName, lastName, login, email, tel);
	}
	
	public Admin() {
		super();
	}

	

}
