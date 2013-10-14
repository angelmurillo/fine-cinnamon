package org.jobs.mtt.service;

import java.util.List;

import org.jobs.mtt.domain.Task;

public interface TaskService {

	public abstract Task addTask(Task task);

	public abstract void deleteTask(Task task);

	public abstract Task findTask(Long id);

	public abstract List<Task> findAllTasks();

	public abstract Task updateTask(Task task);

	List<Task> findAllTasksByUser(String userName);

}
