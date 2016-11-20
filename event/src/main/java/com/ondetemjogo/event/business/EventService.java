package com.ondetemjogo.event.business;

import java.util.List;

import com.ondetemjogo.event.model.Event;

public interface EventService {
	
	List<Event> getEvents(String search); 
	
}
