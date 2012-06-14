package cz.muni.fi.pv243.backend.entitiesManagers;

import java.util.List;

import cz.muni.fi.pv243.backend.entities.Admin;

public interface AdminManager {
	
	void saveAdmin(Admin admin);
	void editAdmin(Admin admin);
	void removeAdmin(Admin admin);
	List<Admin> getAdmin();
	List<Admin> getAdminByLastName(String name);
	Admin getAdmin(Long id);

}
