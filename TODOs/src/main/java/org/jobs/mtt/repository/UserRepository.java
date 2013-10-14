package org.jobs.mtt.repository;

import org.jobs.mtt.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaSpecificationExecutor<User>, JpaRepository<User, Long> {
	
	User findByName(String name);

}