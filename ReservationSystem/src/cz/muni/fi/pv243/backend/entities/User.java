package cz.muni.fi.pv243.backend.entities;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class User extends Person {
	
	@NotNull
	private boolean ok;
	
	public User(Long id, String password, String firstName, String lastName,
			String login, String email, String tel, boolean ok) {
		
		super(id, password, firstName, lastName, login, email, tel);
		this.ok = ok;
	}
	
	public User() {		
		super();
	}
	
	
	public boolean getOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}

}
