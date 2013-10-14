package org.jobs.mtt.service;

import java.util.List;

import org.jobs.mtt.domain.Task;
import org.jobs.mtt.domain.User;
import org.jobs.mtt.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImp implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Autowired
	UserService userService;

	@Override
	public Task addTask(Task task) {
		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(Task task) {
		taskRepository.delete(task);
	}

	@Override
	public Task findTask(Long id) {
		return taskRepository.findOne(id);
	}

	@Override
	public List<Task> findAllTasks() {
		return taskRepository.findAll();
	}

	@Override
	public List<Task> findAllTasksByUser(String userName) {
		User user = userService.findUserByName(userName);
		// Find task by user
		return taskRepository.findByUser(user);
	}

	@Override
	public Task updateTask(Task task) {
		return taskRepository.save(task);
	}

}
