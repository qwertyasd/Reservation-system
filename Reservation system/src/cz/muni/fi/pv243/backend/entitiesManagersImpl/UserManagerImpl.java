package cz.muni.fi.pv243.backend.entitiesManagersImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.infinispan.api.BasicCache;
import org.infinispan.manager.DefaultCacheManager;

import cz.muni.fi.pv243.backend.entities.User;
import cz.muni.fi.pv243.backend.entitiesManagers.UserManager;

public class UserManagerImpl implements UserManager{

	private DefaultCacheManager m = new DefaultCacheManager();

	private BasicCache<Long, User> userCache = m.getCache();
	
	@Override
	public void saveUser(User user) {
		
		if ((userCache.get(user.getId())) == null) {
			userCache.put(user.getId(), user);
		}
		
	}

	@Override
	public void editUser(User user) {

		if (userCache.containsKey(user.getId())) {
			userCache.remove(user.getId());
			userCache.put(user.getId(), user);
		}
		
	}

	@Override
	public void removeUser(User user) {

		userCache.remove(user.getId());
		
	}

	@Override
	public User getUser(Long id) {
		
		return userCache.get(id);
		
	}

	@Override
	public List<User> getUsers() {

		List<User> result = new ArrayList<User>();

		Collection<User> userCollection = userCache.values();
		result.addAll(userCollection);
		return result;
		
	}

	@Override
	public List<User> getUsersByLastName(String lastName) {
		
		List<User> result = new ArrayList<User>();
		
		List<User> allUsers = this.getUsers();

		for (int i = 0; i < allUsers.size(); i++) {
			if (allUsers.get(i).getLastName() == lastName) {
				result.add(allUsers.get(i));
			}
		}
		return result;
		
	}

}
