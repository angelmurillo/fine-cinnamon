package com.finecinnamon.eventviewer.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finecinnamon.eventviewer.domain.Event;
import com.finecinnamon.eventviewer.repository.EventRepository;
import com.finecinnamon.eventviewer.repository.OtherEventInfoRepository;
import com.finecinnamon.eventviewer.service.EventService;

@Controller
public class EventController {
	
	@Autowired(required = true)
	private EventRepository eventRepository;
	
	@Autowired(required = true)
	private OtherEventInfoRepository otherEventInfoRepository;
	
	@Autowired(required = true)
	private EventService eventService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String intro(ModelMap model) {
		
		return "inicio";
	}
	
	@RequestMapping(value = "/events", method = RequestMethod.GET)
	public String list(ModelMap model, Pageable p) {
		model.addAttribute("page", eventService.findAllEventsPaginated(p));
		model.addAttribute("applicationList", eventService.findListAppNames());
		model.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	
	@RequestMapping(value = "/events/appName/{appName}", method = RequestMethod.GET)
	public String showAppName(@PathVariable("appName") String appName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findEventByAppName(appName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/eventName/{eventName}", method = RequestMethod.GET)
	public String showEventName(@PathVariable("eventName") String eventName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByEventName(eventName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/nodeName/{nodeName}", method = RequestMethod.GET)
	public String showNodeName(@PathVariable("nodeName") String nodeName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByNodeName(nodeName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/requestId/{requestId}", method = RequestMethod.GET)
	public String showRequestId(@PathVariable("requestId") String requestId, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByRequestId(requestId,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/sessionId/{sessionId}", method = RequestMethod.GET)
	public String showSessionId(@PathVariable("sessionId") String sessionId, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findBySessionId(sessionId,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/userName/{userName}", method = RequestMethod.GET)
	public String showUserName(@PathVariable("userName") String userName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByUserName(userName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/findByAppName", method = RequestMethod.GET)
	public String findByAppName(@RequestParam String appName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByAppName(appName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		uiModel.addAttribute("appName", appName);
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/findByEventName", method = RequestMethod.GET)
	public String findByEventName(@RequestParam String eventName, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByEventName(eventName,p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		uiModel.addAttribute("eventName", eventName);
		return "listadoEventos";
	}
	
	@RequestMapping(value = "/events/findByRequestId", method = RequestMethod.GET)
	public String findByRequestIdName(@RequestParam String requestId, Model uiModel, Pageable p) {
		uiModel.addAttribute("page", eventService.findByRequestId(requestId, p));
		uiModel.addAttribute("applicationList", eventService.findListAppNames());
		uiModel.addAttribute("eventNameList", eventService.findListEventNames());
		return "listadoEventos";
	}
	
	

	@RequestMapping(value = "/events/id/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, Model uiModel, HttpServletRequest request) {
		
		Event event = eventService.findEvent(id);
		
		uiModel.addAttribute("referer", request.getHeader("Referer"));
		uiModel.addAttribute("event", eventService.findEvent(id));
		uiModel.addAttribute("otherEventInfo", otherEventInfoRepository.findByEventId(event));
		
		return "eventoUnico";
	}
	
	@RequestMapping(value = "live", headers = "Accept=application/json", method = RequestMethod.POST)
	public ResponseEntity<String> showLive(@RequestBody String json, @RequestParam String name_startsWith) {
		
		List<String> appNameList = eventService.searchAppNamesStaringWith(name_startsWith);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json; charset=utf-8");
		
		return new ResponseEntity<String>(Event.fromStringArraytoJson(appNameList), headers, HttpStatus.OK);
	}

}
