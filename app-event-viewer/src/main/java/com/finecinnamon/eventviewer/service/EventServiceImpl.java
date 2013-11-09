package com.finecinnamon.eventviewer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.repository.EventRepository;

@Service
@Transactional
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	public long countAllEvents() {
		return eventRepository.count();
	}

	public void deleteEvent(Event event) {
		eventRepository.delete(event);
	}

	public Event findEvent(Long id) {
		return eventRepository.findOne(id);
	}

	public List<Event> findAllEvents() {

		return eventRepository.findAll();
	}

	public Page<Event> findAllEventsPaginated(Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findAll(page);
	}

	public List<Event> findEventEntries(int firstResult, int maxResults) {
		return eventRepository.findAll(new org.springframework.data.domain.PageRequest(firstResult / maxResults, maxResults))
				.getContent();
	}

	public Page<Event> findEventByAppName(String appName, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByAppName(appName, page);
	}

	public Page<Event> findBySyncJobIdOrderByLastUpdateDesc(String appName, Pageable p) {
		return eventRepository.findByAppName(appName, p);
	}

	public void saveEvent(Event event) {
		eventRepository.save(event);
	}

	public Event updateEvent(Event event) {
		return eventRepository.save(event);
	}

	public Page<Event> findByEventName(String eventName, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByEventName(eventName, page);
	}

	public Page<Event> findByNodeName(String nodeName, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByNodeName(nodeName, page);
	}

	public Page<Event> findByRequestId(String requestId, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByRequestId(requestId, page);
	}

	public Page<Event> findBySessionId(String sessionId, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findBySessionId(sessionId, page);
	}

	public Page<Event> findByUserName(String userName, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByUserName(userName, page);
	}

	public Page<Event> findByAppName(String appName, Pageable p) {
		final PageRequest page = new PageRequest(p.getPageNumber(), p.getPageSize(), new Sort(new Order(Direction.DESC, "id")));
		return eventRepository.findByAppName(appName, page);
	}

	public List<String> findListAppNames() {
		return eventRepository.findListAppNames();
	}

	public List<String> findListEventNames() {
		return eventRepository.findListEventNames();
	}

	public List<String> searchAppNamesStaringWith(String appName) {
		return eventRepository.searchAppNamesStaringWith("%" + appName + "%");
	}

}
