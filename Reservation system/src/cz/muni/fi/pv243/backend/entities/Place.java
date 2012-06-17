package cz.muni.fi.pv243.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Place {
	@Id
    @GeneratedValue
	private Long id;
	@NotNull
	private String name;
	@NotNull
	private int openHour;
	@NotNull
	private int closeHour;
	
	
	public Place() {		
	}
	public Place(Long id, String name, int openHour, int closeHour) {
		
		this.id = id;
		this.name = name;
		this.openHour = openHour;
		this.closeHour = closeHour;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getOpenHour() {
		return openHour;
	}
	public void setOpenHour(int openHour) {
		this.openHour = openHour;
	}
	public int getCloseHour() {
		return closeHour;
	}
	public void setCloseHour(int closeHour) {
		this.closeHour = closeHour;
	}
	
	
	public String toString() {
		return id + ":" + name + "(" + openHour + " - " + closeHour + ")";
	}
	

}
