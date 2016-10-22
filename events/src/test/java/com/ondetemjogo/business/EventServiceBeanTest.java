package com.ondetemjogo.business;

import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.model.Event;
import com.ondetemjogo.repository.EventRepository;
import com.ondetemjogo.util.DateUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceBeanTest {

	@Autowired
	private EventService service;
	@MockBean
	private EventRepository eventRepository;

	@Test
	public void shouldReturnEvents() {
		List<Event> events = new ArrayList<>();
		events.add(new Event());
		events.add(new Event());
		Date date = new Date();
		DateUtil.resetHour(date);
		given(eventRepository.findAllByDateGreaterThanEqual(date)).willReturn(events);
		List<Event> result = service.getEvents(null);
		Assert.assertEquals(2, result.size());
	}
}
