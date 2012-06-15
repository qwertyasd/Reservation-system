package cz.muni.fi.pv243.backend.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Reservation {
	@Id
    @GeneratedValue
	private Long id;
	private Long userId;
	private Long placeId;
	private Calendar startDate;
	private Calendar endDate;
	
	
	public Reservation() {
	}
	
	public Reservation(Long id, Long userId, Long placeId, Calendar startDate,
			Calendar endDate) {
		
		this.id = id;
		this.userId = userId;
		this.placeId = placeId;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getPlaceId() {
		return placeId;
	}
	public void setPlaceId(Long placeId) {
		this.placeId = placeId;
	}
	public Calendar getStartDate() {
		return startDate;
	}
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	public Calendar getEndDate() {
		return endDate;
	}
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}
	
	
	
	

}
