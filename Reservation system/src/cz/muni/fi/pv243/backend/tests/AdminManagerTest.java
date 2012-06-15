package cz.muni.fi.pv243.backend.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.muni.fi.pv243.backend.entities.Admin;

import cz.muni.fi.pv243.backend.entitiesManagersImpl.AdminManagerImpl;

public class AdminManagerTest {

	private Admin admin;
	private Admin admin2;
	private Admin admin3;
	private AdminManagerImpl man;

	public AdminManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		man = new AdminManagerImpl();
		admin = new Admin(new Long(1), "heslo", "jmeno", "prijmeni", "login",
				"email", "telefon");
		admin2 = new Admin(new Long(2), "password", "name", "surname",
				"login2", "email2", "phone");
		admin3 = new Admin(new Long(3), "password", "name", "surname",
				"login2", "email2", "phone");
	}

	@After
	public void tearDown() {
		man = new AdminManagerImpl();
		admin = new Admin();
		admin2 = new Admin();
		admin3 = new Admin();
	}

	@Test
	public void testSaveAdmin() {

		man.saveAdmin(admin);
		List<Admin> testList = man.getAdmin();

		Assert.assertNotNull(testList.get(0));
		Assert.assertEquals(admin, testList.get(0));
		Assert.assertEquals(admin.getId(), testList.get(0).getId());
		Assert.assertEquals(admin.getPassword(), testList.get(0).getPassword());
		Assert.assertEquals(admin.getFirstName(), testList.get(0)
				.getFirstName());
		Assert.assertEquals(admin.getLastName(), testList.get(0).getLastName());
		Assert.assertEquals(admin.getLogin(), testList.get(0).getLogin());
		Assert.assertEquals(admin.getEmail(), testList.get(0).getEmail());
		Assert.assertEquals(admin.getTel(), testList.get(0).getTel());

	}

	@Test
	public void testEditAdmin() {
		man.saveAdmin(admin);
		admin = new Admin(new Long(1), "password", "name", "surname", "login2",
				"email2", "phone");
		man.editAdmin(admin);

		List<Admin> testList = man.getAdmin();

		Assert.assertEquals(admin, testList.get(0));
		Assert.assertEquals(admin.getId(), testList.get(0).getId());
		Assert.assertEquals(admin.getPassword(), testList.get(0).getPassword());
		Assert.assertEquals(admin.getFirstName(), testList.get(0)
				.getFirstName());
		Assert.assertEquals(admin.getLastName(), testList.get(0).getLastName());
		Assert.assertEquals(admin.getLogin(), testList.get(0).getLogin());
		Assert.assertEquals(admin.getEmail(), testList.get(0).getEmail());
		Assert.assertEquals(admin.getTel(), testList.get(0).getTel());
	}

	@Test
	public void testRemoveAdmin() {

		man.saveAdmin(admin);
		man.saveAdmin(admin2);
		List<Admin> testList = man.getAdmin();

		Assert.assertEquals(2, testList.size());

		man.removeAdmin(admin);
		testList = man.getAdmin();

		Assert.assertEquals(1, testList.size());
		Assert.assertEquals(admin2, testList.get(0));

		man.removeAdmin(admin2);
		testList = man.getAdmin();

		Assert.assertEquals(0, testList.size());
	}

	@Test
	public void testGetAllAdmins() {

		man.saveAdmin(admin);
		man.saveAdmin(admin2);
		List<Admin> testList = man.getAdmin();

		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(admin));
		Assert.assertEquals(true, testList.contains(admin2));
	}

	@Test
	public void testGetAdminsByLastName() {

		man.saveAdmin(admin);
		man.saveAdmin(admin2);
		man.saveAdmin(admin3);
		
		List<Admin> testList = man.getAdminByLastName("surname");
		
		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(admin2));
		Assert.assertEquals(true, testList.contains(admin3));
	}

	@Test
	public void testgetAdminById() {

		man.saveAdmin(admin);
		man.saveAdmin(admin2);
		Admin test = man.getAdmin(new Long(1));

		Assert.assertEquals(admin, test);
		Assert.assertEquals(admin.getId(), test.getId());
		Assert.assertEquals(admin.getPassword(), test.getPassword());
		Assert.assertEquals(admin.getFirstName(), test.getFirstName());
		Assert.assertEquals(admin.getLastName(), test.getLastName());
		Assert.assertEquals(admin.getLogin(), test.getLogin());
		Assert.assertEquals(admin.getEmail(), test.getEmail());
		Assert.assertEquals(admin.getTel(), test.getTel());

	}

}
