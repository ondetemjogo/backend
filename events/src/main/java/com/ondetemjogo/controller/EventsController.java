package com.ondetemjogo.controller;

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

import com.ondetemjogo.adapter.EventAdapter;
import com.ondetemjogo.business.EventService;
import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.model.Event;

@RestController
@RequestMapping("/api/v1")
public class EventsController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value = "/search/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<EventDTO>> getBalance(@PathVariable("search") String search) {
		List<Event> events = eventService.getEvents(search);
		Set<EventDTO> eventsDTO = new HashSet<>();
		for (Event event : events) {
			eventsDTO.add(new EventAdapter(event).build());
		}
	    return ResponseEntity.ok().body(eventsDTO);
	}

}
