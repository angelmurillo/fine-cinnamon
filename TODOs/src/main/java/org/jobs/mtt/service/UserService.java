package org.jobs.mtt.service;

import java.util.List;

import org.jobs.mtt.domain.User;

public interface UserService {
	
	void addUser(User user);
	
	List<User> findAllUsers();
	
	User findUserByName(String name);
	
	Long countUsers();

}
