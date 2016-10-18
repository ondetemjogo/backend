package com.ondetemjogo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ondetemjogo.dto.EventDTO;

@RestController
@RequestMapping("/api/v1")
public class EventsController {

	@RequestMapping(value = "/search/{search}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<EventDTO>> getBalance(@PathVariable("search") String search) {
      List<EventDTO> events = new ArrayList<>();   
	   events.add(new EventDTO());
	   events.add(new EventDTO());
	   events.add(new EventDTO());
	   return ResponseEntity.ok().body(events);
	}

}
