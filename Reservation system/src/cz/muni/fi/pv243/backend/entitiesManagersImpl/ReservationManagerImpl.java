package cz.muni.fi.pv243.backend.entitiesManagersImpl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

import org.infinispan.api.BasicCache;
import org.infinispan.manager.DefaultCacheManager;

import cz.muni.fi.pv243.backend.entities.Reservation;
import cz.muni.fi.pv243.backend.entities.Place;
import cz.muni.fi.pv243.backend.entitiesManagers.ReservationManager;

public class ReservationManagerImpl implements ReservationManager{

	private DefaultCacheManager m = new DefaultCacheManager();

	private BasicCache<Long, Reservation> reservationCache = m.getCache();
	
	@Override
	public void saveReservation(Reservation reservation) {
		if(reservation == null){
			throw new NullPointerException("Reservation can not be null.");
		}
		if ((reservationCache.get(reservation.getId())) == null) {
			reservationCache.put(reservation.getId(), reservation);
		}
		
	}

	@Override
	public void editReservation(Reservation reservation) {
		if(reservation == null){
			throw new NullPointerException("Reservation can not be null.");
		}
		if (reservationCache.containsKey(reservation.getId())) {
			reservationCache.remove(reservation.getId());
			reservationCache.put(reservation.getId(), reservation);
		}
		
	}

	@Override
	public void removeReservation(Reservation reservation) {
		if(reservation == null){
			throw new NullPointerException("Reservation can not be null.");
		}
		reservationCache.remove(reservation.getId());
		
	}

	@Override
	public List<Reservation> getAllReservations() {

		List<Reservation> result = new ArrayList<Reservation>();

		Collection<Reservation> reservationCollection = reservationCache.values();
		result.addAll(reservationCollection);
		return result;
		
	}
	
	@Override
	public List<Reservation> getReservationsForPlace(Place place) {
		if(place == null){
			throw new NullPointerException("Place can not be null.");
		}
		List<Reservation> result = new ArrayList<Reservation>();
		
		List<Reservation> allReservations = this.getAllReservations();

		for (int i = 0; i < allReservations.size(); i++) {
			if (allReservations.get(i).getPlaceId().equals(place.getId())) {
				result.add(allReservations.get(i));
			}
		}
		return result;
	}

	@Override
	public List<Reservation> getFromToForPlace(Calendar from, Calendar to,
			Place place) {
		if(place == null){
			throw new NullPointerException("Place can not be null.");
		}
		if(from == null){
			throw new NullPointerException("Start date can not be null.");
		}
		if(to == null){
			throw new NullPointerException("End date not be null.");
		}
		
		List<Reservation> result = new ArrayList<Reservation>();
		
		List<Reservation> placeReservations = this.getReservationsForPlace(place);
		for (int i = 0; i < placeReservations.size(); i++) {
			if (placeReservations.get(i).getStartDate().compareTo(from) >= 0 && placeReservations.get(i).getEndDate().compareTo(to) <= 0) {
				result.add(placeReservations.get(i));
			}
		}
		return result;
	}

}
