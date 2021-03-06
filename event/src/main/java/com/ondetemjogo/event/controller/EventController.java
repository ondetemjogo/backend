package com.ondetemjogo.event.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ondetemjogo.event.adapter.EventAdapter;
import com.ondetemjogo.event.business.EventService;
import com.ondetemjogo.event.dto.EventDTO;
import com.ondetemjogo.event.model.Event;

@RestController
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = {"/api/v1/event", "/api/v1/event/{search}"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<EventDTO>> getEventsWithSearch(@PathVariable(value = "search", required = false) String search) {
		List<Event> events = eventService.getEvents(search);
		Set<EventDTO> eventsDTO = new HashSet<>();
		for (Event event : events) {
			eventsDTO.add(new EventAdapter(event).build());
		}
	    return ResponseEntity.ok().body(eventsDTO);
	}

}
