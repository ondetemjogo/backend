package com.ondetemjogo.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondetemjogo.model.Event;
import com.ondetemjogo.repository.EventRepository;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getEvents(String search) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		return eventRepository.findAllByDateGreaterThanEqual(date);
	}
		
}
