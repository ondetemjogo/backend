package com.ondetemjogo.business;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.model.Event;
import com.ondetemjogo.repository.EventRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceBeanTest {

	@Autowired
	private EventService service;
	
	@MockBean
	private EventRepository eventRepository;

	@Test
	@SuppressWarnings("unchecked")
	public void shouldReturnEvents() {
		List<Event> events = new ArrayList<>();
		events.add(new Event());
		events.add(new Event());
		given(eventRepository.findAll(any(Specification.class))).willReturn(events);
		List<Event> result = service.getEvents(null);
		Assert.assertEquals(2, result.size());
	}
	
	@Test
	@SuppressWarnings("unchecked")
	public void shouldFindBySearchWord() {
		List<Event> events = new ArrayList<>();
		events.add(new Event());
		events.add(new Event());
		given(eventRepository.findAll(any(Specification.class))).willReturn(events);
		List<Event> result = service.getEvents("search");
		Assert.assertEquals(2, result.size());
	}
}
