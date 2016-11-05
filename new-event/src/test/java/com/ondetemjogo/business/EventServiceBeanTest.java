package com.ondetemjogo.business;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.repository.EventRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceBeanTest {

	@Autowired
	private EventService service;
	
	@MockBean
	private EventRepository eventRepository;

	@Test
	public void test() {
		
	}
}
