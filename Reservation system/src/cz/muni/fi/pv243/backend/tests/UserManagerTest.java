package cz.muni.fi.pv243.backend.tests;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import cz.muni.fi.pv243.backend.entities.User;

import cz.muni.fi.pv243.backend.entitiesManagersImpl.UserManagerImpl;


public class UserManagerTest {

	private User User;
	private User User2;
	private User User3;
	private UserManagerImpl man;

	public UserManagerTest() {
	}

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() {
		man = new UserManagerImpl();
		User = new User(new Long(1), "heslo", "jmeno", "prijmeni", "login",
				"email", "telefon", false);
		User2 = new User(new Long(2), "password", "name", "surname",
				"login2", "email2", "phone", false);
		User3 = new User(new Long(3), "password", "name", "surname",
				"login2", "email2", "phone", false);
	}

	@After
	public void tearDown() {
		man = new UserManagerImpl();
		User = new User();
		User2 = new User();
		User3 = new User();
	}

	@Test
	public void testSaveUser() {

		man.saveUser(User);
		List<User> testList = man.getUsers();

		Assert.assertNotNull(testList.get(0));
		Assert.assertEquals(User, testList.get(0));
		Assert.assertEquals(User.getId(), testList.get(0).getId());
		Assert.assertEquals(User.getPassword(), testList.get(0).getPassword());
		Assert.assertEquals(User.getFirstName(), testList.get(0)
				.getFirstName());
		Assert.assertEquals(User.getLastName(), testList.get(0).getLastName());
		Assert.assertEquals(User.getLogin(), testList.get(0).getLogin());
		Assert.assertEquals(User.getEmail(), testList.get(0).getEmail());
		Assert.assertEquals(User.getTel(), testList.get(0).getTel());
		Assert.assertEquals(User.getOk(), testList.get(0).getOk());

	}

	@Test
	public void testEditUser() {
		man.saveUser(User);
		User = new User(new Long(1), "password", "name", "surname", "login2",
				"email2", "phone", false);
		man.editUser(User);

		List<User> testList = man.getUsers();

		Assert.assertEquals(User, testList.get(0));
		Assert.assertEquals(User.getId(), testList.get(0).getId());
		Assert.assertEquals(User.getPassword(), testList.get(0).getPassword());
		Assert.assertEquals(User.getFirstName(), testList.get(0)
				.getFirstName());
		Assert.assertEquals(User.getLastName(), testList.get(0).getLastName());
		Assert.assertEquals(User.getLogin(), testList.get(0).getLogin());
		Assert.assertEquals(User.getEmail(), testList.get(0).getEmail());
		Assert.assertEquals(User.getTel(), testList.get(0).getTel());
	}

	@Test
	public void testRemoveUser() {

		man.saveUser(User);
		man.saveUser(User2);
		List<User> testList = man.getUsers();

		Assert.assertEquals(2, testList.size());

		man.removeUser(User);
		testList = man.getUsers();

		Assert.assertEquals(1, testList.size());
		Assert.assertEquals(User2, testList.get(0));

		man.removeUser(User2);
		testList = man.getUsers();

		Assert.assertEquals(0, testList.size());
	}

	@Test
	public void testGetAllUsers() {

		man.saveUser(User);
		man.saveUser(User2);
		List<User> testList = man.getUsers();

		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(User));
		Assert.assertEquals(true, testList.contains(User2));
	}

	@Test
	public void testGetUsersByLastName() {

		man.saveUser(User);
		man.saveUser(User2);
		man.saveUser(User3);
		
		List<User> testList = man.getUsersByLastName("surname");
		
		Assert.assertEquals(2, testList.size());
		Assert.assertEquals(true, testList.contains(User2));
		Assert.assertEquals(true, testList.contains(User3));
	}

	@Test
	public void testgetUserById() {

		man.saveUser(User);
		man.saveUser(User2);
		User test = man.getUser(new Long(1));

		Assert.assertEquals(User, test);
		Assert.assertEquals(User.getId(), test.getId());
		Assert.assertEquals(User.getPassword(), test.getPassword());
		Assert.assertEquals(User.getFirstName(), test.getFirstName());
		Assert.assertEquals(User.getLastName(), test.getLastName());
		Assert.assertEquals(User.getLogin(), test.getLogin());
		Assert.assertEquals(User.getEmail(), test.getEmail());
		Assert.assertEquals(User.getTel(), test.getTel());

	}

}
