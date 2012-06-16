package cz.muni.fi.pv243.backend.entitiesManagers;

import java.util.List;

import cz.muni.fi.pv243.backend.entities.Place;

public interface PlaceManager {
	
	void savePlace(Place place);
	void editPlace(Place place);
	void removePlace(Place place);
	List<Place> getPlaces();
	Place getPlaceByName(String name);
	Place getPlace(Long id);
	

}
