package cz.muni.fi.pv243.backend.tests;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.muni.fi.pv243.backend.entities.Place;
import cz.muni.fi.pv243.backend.entities.Reservation;


import cz.muni.fi.pv243.backend.entitiesManagersImpl.ReservationManagerImpl;

public class ReservationManagerTest {

	private Reservation reservation;
	private Reservation reservation2;
	private Reservation reservation3;
	private Calendar calendar;
	private Calendar calendar2;
	private Calendar calendar3;
	private Place place;
	private ReservationManagerImpl man;

	public ReservationManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		man = new ReservationManagerImpl();
		
		calendar = new GregorianCalendar();
		calendar.set(2012, 1, 1, 10, 00);
		calendar2 = new GregorianCalendar();
		calendar2.set(2012, 1, 1, 11, 00);
		calendar3 = new GregorianCalendar();
		calendar3.set(2012, 1, 1, 12, 00);
		
		place = new Place(new Long(200), "jmeno", 10, 20);
		
		reservation = new Reservation(new Long(1), new Long(10), new Long(100), calendar, calendar2);
		reservation2 = new Reservation(new Long(2), new Long(20), new Long(200), calendar, calendar2);
		reservation3 = new Reservation(new Long(3), new Long(30), new Long(200), calendar2, calendar3);
	}

	@After
	public void tearDown() {
		man = new ReservationManagerImpl();
		reservation = new Reservation();
		reservation2 = new Reservation();
		reservation3 = new Reservation();
		place = new Place();
	}

	@Test
	public void testSaveReservation() {

		man.saveReservation(reservation);
		List<Reservation> testList = man.getAllReservations();

		Assert.assertNotNull(testList.get(0));
		Assert.assertEquals(reservation, testList.get(0));
		Assert.assertEquals(reservation.getId(), testList.get(0).getId());
		Assert.assertEquals(reservation.getUserId(), testList.get(0).getUserId());
		Assert.assertEquals(reservation.getPlaceId(), testList.get(0).getPlaceId());
		Assert.assertEquals(reservation.getStartDate(), testList.get(0).getStartDate());
		Assert.assertEquals(reservation.getEndDate(), testList.get(0).getEndDate());

	}

	@Test
	public void testEditReservation() {
		man.saveReservation(reservation);
		reservation = (new Reservation(new Long(1), new Long(10), new Long(100), calendar, calendar2));
		man.editReservation(reservation);

		List<Reservation> testList = man.getAllReservations();

		Assert.assertEquals(reservation, testList.get(0));
		Assert.assertEquals(reservation.getId(), testList.get(0).getId());
		Assert.assertEquals(reservation.getUserId(), testList.get(0).getUserId());
		Assert.assertEquals(reservation.getPlaceId(), testList.get(0).getPlaceId());
		Assert.assertEquals(reservation.getStartDate(), testList.get(0).getStartDate());
		Assert.assertEquals(reservation.getEndDate(), testList.get(0).getEndDate());
	}

	@Test
	public void testRemoveReservation() {

		man.saveReservation(reservation);
		man.saveReservation(reservation2);
		List<Reservation> testList = man.getAllReservations();

		Assert.assertEquals(2, testList.size());

		man.removeReservation(reservation);
		testList = man.getAllReservations();

		Assert.assertEquals(1, testList.size());
		Assert.assertEquals(reservation2, testList.get(0));

		man.removeReservation(reservation2);
		testList = man.getAllReservations();

		Assert.assertEquals(0, testList.size());
	}

	@Test
	public void testGetAllReservations() {

		man.saveReservation(reservation);
		man.saveReservation(reservation2);
		List<Reservation> testList = man.getAllReservations();

		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(reservation));
		Assert.assertEquals(true, testList.contains(reservation2));
	}

	@Test
	public void testGetReservationsForPlace() {

		man.saveReservation(reservation);
		man.saveReservation(reservation2);
		man.saveReservation(reservation3);
		
		List<Reservation> testList = man.getReservationsForPlace(place);
		
		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(reservation2));
		Assert.assertEquals(true, testList.contains(reservation3));
	}

	@Test
	public void testGetFromToForPlace() {

		man.saveReservation(reservation);
		man.saveReservation(reservation2);
		man.saveReservation(reservation3);
		List<Reservation> testList = man.getFromToForPlace(calendar, calendar2, place);

		Assert.assertEquals(1, testList.size());
		Assert.assertEquals(true, testList.contains(reservation2));

	}

}
