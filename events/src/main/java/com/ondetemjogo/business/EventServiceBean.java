package com.ondetemjogo.business;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ondetemjogo.model.Event;
import com.ondetemjogo.repository.EventRepository;
import com.ondetemjogo.specification.EventSpecification;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getEvents(String search) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date date = calendar.getTime();
		Specification<Event> spec = EventSpecification.findEvents(date, search);
		return eventRepository.findAll(spec);
	}
		
}
