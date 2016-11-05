package com.ondetemjogo.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.repository.EventRepository;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public void save(EventDTO event) {
		
	}

}
