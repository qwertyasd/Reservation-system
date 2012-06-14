package cz.muni.fi.pv243.backend.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.muni.fi.pv243.backend.entities.Place;

import cz.muni.fi.pv243.backend.entitiesManagersImpl.PlaceManagerImpl;


public class PlaceManagerTest {

	private Place place;
	private Place place2;
	private Place place3;
	private PlaceManagerImpl man;

	public PlaceManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		man = new PlaceManagerImpl();
		place = new Place(new Long(1), "jmeno", 10, 20);
		place2 = new Place(new Long(2), "name", 10, 20);
		place3 = new Place(new Long(3), "name", 10, 20);
	}

	@After
	public void tearDown() {
		man = new PlaceManagerImpl();
		place = new Place();
		place2 = new Place();
		place3 = new Place();
	}

	@Test
	public void testSavePlace() {

		man.savePlace(place);
		List<Place> testList = man.getPlaces();

		Assert.assertNotNull(testList.get(0));
		Assert.assertEquals(place, testList.get(0));
		Assert.assertEquals(place.getId(), testList.get(0).getId());
		Assert.assertEquals(place.getName(), testList.get(0).getName());
		Assert.assertEquals(place.getOpenHour(), testList.get(0).getOpenHour());
		Assert.assertEquals(place.getCloseHour(), testList.get(0).getCloseHour());


	}

	@Test
	public void testEditPlace() {
		man.savePlace(place);
		place = new Place(new Long(1), "name", 11, 21);
		man.editPlace(place);

		List<Place> testList = man.getPlaces();

		Assert.assertNotNull(testList.get(0));
		Assert.assertEquals(place, testList.get(0));
		Assert.assertEquals(place.getId(), testList.get(0).getId());
		Assert.assertEquals(place.getName(), testList.get(0).getName());
		Assert.assertEquals(place.getOpenHour(), testList.get(0).getOpenHour());
		Assert.assertEquals(place.getCloseHour(), testList.get(0).getCloseHour());
	}

	@Test
	public void testRemovePlace() {

		man.savePlace(place);
		man.savePlace(place2);
		List<Place> testList = man.getPlaces();

		Assert.assertEquals(2, testList.size());

		man.removePlace(place);
		testList = man.getPlaces();

		Assert.assertEquals(1, testList.size());
		Assert.assertEquals(place2, testList.get(0));

		man.removePlace(place2);
		testList = man.getPlaces();

		Assert.assertEquals(0, testList.size());
	}

	@Test
	public void testGetAllPlaces() {

		man.savePlace(place);
		man.savePlace(place2);
		List<Place> testList = man.getPlaces();

		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(place));
		Assert.assertEquals(true, testList.contains(place2));
	}

	@Test
	public void testGetPlaceByLastName() {

		man.savePlace(place);
		man.savePlace(place2);
		man.savePlace(place3);
		
		Place test = man.getPlaceByName("jmeno");
		
		Assert.assertEquals(place, test);
		Assert.assertEquals(place.getId(), test.getId());
		Assert.assertEquals(place.getName(), test.getName());
		Assert.assertEquals(place.getOpenHour(), test.getOpenHour());
		Assert.assertEquals(place.getCloseHour(), test.getCloseHour());
	}

	@Test
	public void testgetPlaceById() {

		man.savePlace(place);
		man.savePlace(place2);
		Place test = man.getPlace(new Long(1));

		Assert.assertEquals(place, test);
		Assert.assertEquals(place.getId(), test.getId());
		Assert.assertEquals(place.getName(), test.getName());
		Assert.assertEquals(place.getOpenHour(), test.getOpenHour());
		Assert.assertEquals(place.getCloseHour(), test.getCloseHour());

	}

}
