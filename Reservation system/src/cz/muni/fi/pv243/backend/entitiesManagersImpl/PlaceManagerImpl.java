package cz.muni.fi.pv243.backend.entitiesManagersImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.infinispan.api.BasicCache;
import org.infinispan.manager.DefaultCacheManager;

import cz.muni.fi.pv243.backend.entities.Place;
import cz.muni.fi.pv243.backend.entitiesManagers.PlaceManager;

public class PlaceManagerImpl implements PlaceManager {

	private DefaultCacheManager m = new DefaultCacheManager();

	private BasicCache<Long,Place> placeCache = m.getCache();
	
	@Override
	public void savePlace(Place place) {

		if ((placeCache.get(place.getId())) == null) {
			placeCache.put(place.getId(), place);
		}				
	}

	@Override
	public void editPlace(Place place) {

		if (placeCache.containsKey(place.getId())) {
			placeCache.remove(place.getId());
			placeCache.put(place.getId(), place);
		}
		
	}

	@Override
	public void removePlace(Place place) {

		placeCache.remove(place.getId());
		
	}

	@Override
	public List<Place> getPlaces() {

		List<Place> result = new ArrayList<Place>();

		Collection<Place> placeCollection = placeCache.values();
		result.addAll(placeCollection);
		return result;
		
	}

	@Override
	public Place getPlaceByName(String name) {

		Place place = new Place();
		List<Place> allPlaces = this.getPlaces();
		

		for (int i = 0; i < allPlaces.size(); i++) {
			if (allPlaces.get(i).getName() == name) {
			place = (Place)allPlaces.get(i);
				break;
			}
			}	
		return place;
		}

	@Override
	public Place getPlace(Long id) {
		
		return placeCache.get(id);
	}

}
