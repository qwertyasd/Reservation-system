package cz.muni.fi.pv243.backend.entitiesManagersImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.infinispan.api.BasicCache;
import org.infinispan.manager.DefaultCacheManager;

import cz.muni.fi.pv243.backend.entities.Admin;
import cz.muni.fi.pv243.backend.entitiesManagers.AdminManager;

public class AdminManagerImpl implements AdminManager {

	private DefaultCacheManager m = new DefaultCacheManager();

	private BasicCache<Long, Admin> adminCache = m.getCache();

	@Override
	public void saveAdmin(Admin admin) {
		if(admin == null){
			throw new NullPointerException("Admin can not be null.");
		}
		if ((adminCache.get(admin.getId())) == null) {
			adminCache.put(admin.getId(), admin);
		}
	}

	@Override
	public void editAdmin(Admin admin) {
		if(admin == null){
			throw new NullPointerException("Admin can not be null.");
		}
		if (adminCache.containsKey(admin.getId())) {
			adminCache.remove(admin.getId());
			adminCache.put(admin.getId(), admin);
		}
	}

	@Override
	public void removeAdmin(Admin admin) {
		if(admin == null){
			throw new NullPointerException("Admin can not be null.");
		}
		adminCache.remove(admin.getId());

	}

	@Override
	public List<Admin> getAdmin() {

		List<Admin> result = new ArrayList<Admin>();

		Collection<Admin> adminCollection = adminCache.values();
		result.addAll(adminCollection);
		return result;
		
	}

	@Override
	public List<Admin> getAdminByLastName(String name) {
		if(name == null){
			throw new NullPointerException("Name can not be null.");
		}
		List<Admin> result = new ArrayList<Admin>();
		
		List<Admin> allAdmins = this.getAdmin();

		for (int i = 0; i < allAdmins.size(); i++) {
			if (allAdmins.get(i).getLastName() == name) {
				result.add(allAdmins.get(i));
			}
		}
		return result;
		
	}

	@Override
	public Admin getAdmin(Long id) {
		if(id == null){
			throw new NullPointerException("Id can not be null.");
		}
		return adminCache.get(id);
		
	}

}
