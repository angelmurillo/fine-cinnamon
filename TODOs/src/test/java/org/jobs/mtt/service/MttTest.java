package org.jobs.mtt.service;

import java.util.Date;
import java.util.List;

import org.jobs.mtt.domain.Task;
import org.jobs.mtt.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:META-INF/spring/applicationContext*.xml")
public class MttTest {

	private static final String USER1 = "test";
	private static final String USER2 = "test2";
	
	@Autowired
	protected UserService userServiceImp;
	
	@Autowired
	protected TaskService taskServiceImp;
	
	@Before
	public void setup() {
		
		// Create user in db
		User user = new User(USER1);
		User user2 = new User(USER2);
		userServiceImp.addUser(user);
		userServiceImp.addUser(user2);
	}

	/**
	 * Count users in db after setup
	 */
	@Test
	@Transactional
	public void testCountUsers() {

		List<User> userNumber = userServiceImp.findAllUsers();
		Assert.assertEquals("No users",2, userNumber.size());
	}
	
	/**
	 * Check if user1 has tasks and user2 has not task.
	 */
	@Test
	@Transactional
	public void testAddOneTaskUser1() {

		Task task = new Task("Task1", "Desc1", new Date(), false, userServiceImp.findUserByName(USER1));
		taskServiceImp.addTask(task);
		
		Assert.assertEquals("No task",1, taskServiceImp.findAllTasksByUser(USER1).size());
		Assert.assertEquals("Has task",0, taskServiceImp.findAllTasksByUser(USER2).size());
		
	}

	

}
