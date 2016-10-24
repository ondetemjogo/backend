package com.ondetemjogo.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ondetemjogo.adapter.EventAdapter;
import com.ondetemjogo.business.EventService;
import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.model.Event;
import com.ondetemjogo.stub.EstablishmentStub;
import com.ondetemjogo.stub.TeamStub;

@RunWith(SpringRunner.class)
@WebMvcTest(EventsController.class)
@AutoConfigureMockMvc
public class EventsControllerTest {

	private JacksonTester<List<EventDTO>> json;
	@Autowired
	private MockMvc mvc;
	@MockBean
	private EventService eventService;

	@Before
	public void setup() {
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}

	@Test
	public void shouldCallService() throws Exception {
		List<EventDTO> events = new ArrayList<>();
		Event event = new Event();
		event.setDate(new Date());
		event.setEstablishment(new EstablishmentStub());
		event.setHouseTeam(new TeamStub());
		event.setVisitTeam(new TeamStub());
		events.add(new EventAdapter(event).build());
		String expected = json.write(events).getJson();
		
		given(eventService.getEvents("Flamengo")).willReturn(Arrays.asList(event));

		this.mvc.perform(get("/api/v1/search/Flamengo").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().string(expected));
	}
	
	@Test
	public void shouldCallServiceWithoutSearch() throws Exception {
		List<EventDTO> events = new ArrayList<>();
		Event event = new Event();
		event.setDate(new Date());
		event.setEstablishment(new EstablishmentStub());
		event.setHouseTeam(new TeamStub());
		event.setVisitTeam(new TeamStub());
		events.add(new EventAdapter(event).build());
		String expected = json.write(events).getJson();
		
		given(eventService.getEvents(null)).willReturn(Arrays.asList(event));

		this.mvc.perform(get("/api/v1/search/").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().string(expected));
	}
}
