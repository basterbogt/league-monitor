package org.captains.daos;

import java.util.List;

import org.captains.domain.User;

public interface Users {

	public User getUser(String id);
	public List<User> getUsers();
	
}
