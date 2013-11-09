package com.finecinnamon.eventviewer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.domain.OtherEventInfo;
import com.finecinnamon.eventviewer.repository.EventRepository;
import com.finecinnamon.eventviewer.repository.OtherEventInfoRepository;

@RequestMapping("/othereventinfoes")
@Controller
public class OtherEventInfoController {
	
	@Autowired(required = true)
	private EventRepository eventRepository;
	
	@Autowired(required = true)
	private OtherEventInfoRepository otherEventInfoRepository;
	
	
	@RequestMapping(value = "show/{id}", headers = "Accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> showAppName(@PathVariable("id") String eventId) {
		
		Event event = eventRepository.findOne(Long.parseLong(eventId));
		List<OtherEventInfo> listOtherEventInfo = otherEventInfoRepository.findByEventId(event);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		return new ResponseEntity<String>(OtherEventInfo.toJsonArray(listOtherEventInfo), headers, HttpStatus.OK);
	}
	

}
