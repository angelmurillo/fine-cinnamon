package com.finecinnamon.eventviewer.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.finecinnamon.eventviewer.domain.Event;

@Repository
public interface EventRepository extends JpaSpecificationExecutor<Event>, JpaRepository<Event, Long> {

	public Page<Event> findByEventDateBetween(Long eventDateStart, Long eventDateEnd, Pageable p);

	public List<Event> findByAppName(String appName);

	public List<Event> findDistinctEventByAppName(String appName);

	public Page<Event> findByAppName(String appName, Pageable p);

	public Page<Event> findByEventName(String eventName, Pageable p);

	public Page<Event> findByNodeName(String nodeName, Pageable p);

	public Page<Event> findByRequestId(String requestId, Pageable p);

	public Page<Event> findBySessionId(String sessionId, Pageable p);

	public Page<Event> findByUserName(String userName, Pageable p);

	@Query("SELECT DISTINCT e.appName FROM Event e WHERE e.appName LIKE upper(:appName)")
	public List<String> searchAppNamesStaringWith(@Param("appName") String appName);

	@Query("SELECT DISTINCT e.appName FROM Event e")
	public List<String> findListAppNames();

	@Query("SELECT DISTINCT e.eventName FROM Event e")
	public List<String> findListEventNames();
}
