package cz.muni.fi.pv243.frontend;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Named;

import cz.muni.fi.pv243.backend.entities.Place;

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
		System.out.println("Saving place " + place);
	}
	
	@Named
	public Place getPlace(long id){
		System.out.println("Getting place " + id);
		return new Place(id,"Tra Lala",(int)(id+2) % 12,(int)(id*2) % 12 + 8);
	}
	
	

}
