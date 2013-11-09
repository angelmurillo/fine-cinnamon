package com.finecinnamon.eventviewer.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.finecinnamon.eventviewer.domain.Event;

public interface EventService {

	public abstract long countAllEvents();

	public abstract void deleteEvent(Event event);

	public abstract Event findEvent(Long id);

	public abstract List<Event> findAllEvents();

	public abstract Page<Event> findAllEventsPaginated(Pageable p);

	public abstract List<Event> findEventEntries(int firstResult, int maxResults);

	public abstract void saveEvent(Event event);

	public abstract Event updateEvent(Event event);

	public abstract Page<Event> findEventByAppName(String appName, Pageable p);

	public abstract Page<Event> findBySyncJobIdOrderByLastUpdateDesc(String appName, Pageable p);

	public abstract Page<Event> findByEventName(String eventName, Pageable p);

	public abstract Page<Event> findByNodeName(String nodeName, Pageable p);

	public abstract Page<Event> findByRequestId(String requestId, Pageable p);

	public abstract Page<Event> findBySessionId(String sessionId, Pageable p);

	public abstract Page<Event> findByUserName(String userName, Pageable p);

	public abstract Page<Event> findByAppName(String appName, Pageable p);

	public abstract List<String> findListAppNames();

	public abstract List<String> findListEventNames();

	public abstract List<String> searchAppNamesStaringWith(String appName);

}
