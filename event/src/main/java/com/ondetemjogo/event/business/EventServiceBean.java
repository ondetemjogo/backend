package com.ondetemjogo.event.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ondetemjogo.event.model.Event;
import com.ondetemjogo.event.repository.EventRepository;
import com.ondetemjogo.event.specification.EventSpecification;
import com.ondetemjogo.event.util.DateUtil;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;

	@Override
	public List<Event> getEvents(String search) {
		Date date = DateUtil.resetHour(new Date());
		Specification<Event> spec = EventSpecification.findEvents(date, search);
		return eventRepository.findAll(spec);
	}

}
