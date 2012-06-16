package cz.muni.fi.pv243.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import cz.muni.fi.pv243.backend.entities.Place;
import cz.muni.fi.pv243.backend.entitiesManagers.PlaceManager;

@Stateless
public class Places {
	
	//@Inject
	//private PlaceManager pm;
	
	@Produces
	@Named
	public List<Place> getPlaces(){
		System.out.println("Getting places");
		ArrayList<Place> ret = new ArrayList<Place>();
		ret.add(new Place(1L,"Abbc",8,16));
		ret.add(new Place(2L,"Bccd",7,19));
		return ret;
	}
	
	@Named
	public void savePlace(Place place){
		System.out.println("Saving places");
	}
	
	@Produces
	@Named
	public Place getPlace(){
		System.out.println("Getting place");
		return new Place();
	}
	
	

}
