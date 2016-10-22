package com.ondetemjogo.business;

import java.util.List;

import com.ondetemjogo.model.Event;

public interface EventService {
	
	List<Event> getEvents(String search); 
	
}
