package org.jobs.mtt.repository;

import java.util.List;

import org.jobs.mtt.domain.Task;
import org.jobs.mtt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaSpecificationExecutor<Task>, JpaRepository<Task, Long> {
	
	List<Task> findByUser(User user);

}