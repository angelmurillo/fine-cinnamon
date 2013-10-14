package org.jobs.mtt.service;

import java.util.List;

import org.jobs.mtt.domain.User;
import org.jobs.mtt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public void addUser(User user) {
		userRepository.save(user);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User findUserByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public Long countUsers() {
		return userRepository.count();
	}

}
