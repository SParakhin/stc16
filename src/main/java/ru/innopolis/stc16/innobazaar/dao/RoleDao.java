package ru.innopolis.stc16.innobazaar.dao;

import ru.innopolis.stc16.innobazaar.entity.Role;

public interface RoleDao {

	public Role findRoleByName(String theRoleName);
	
}
