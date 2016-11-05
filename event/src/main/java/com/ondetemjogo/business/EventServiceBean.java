package com.ondetemjogo.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ondetemjogo.model.Event;
import com.ondetemjogo.repository.EventRepository;
import com.ondetemjogo.specification.EventSpecification;
import com.ondetemjogo.util.DateUtil;

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
