package cz.muni.fi.pv243.backend.entitiesManagers;

import java.util.Calendar;
import java.util.List;

import cz.muni.fi.pv243.backend.entities.Place;
import cz.muni.fi.pv243.backend.entities.Reservation;



public interface ReservationManager {
	
	void saveReservation(Reservation reservation);
	void editReservation(Reservation reservation);
	void removeReservation(Reservation reservation);
	List<Reservation> getReservationsForPlace(Place place);
	List<Reservation> getFromToForPlace(Calendar from, Calendar to,Place place);
	List<Reservation> getAllReservations();

}
