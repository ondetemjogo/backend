package com.ondetemjogo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.DateUtil;
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

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ondetemjogo.business.EventService;
import com.ondetemjogo.dto.ErrorDTO;
import com.ondetemjogo.dto.EventDTO;

@RunWith(SpringRunner.class)
@WebMvcTest(EventController.class)
@AutoConfigureMockMvc
public class EventControllerTest {

	private JacksonTester<EventDTO> json;
	private JacksonTester<List<ErrorDTO>> jsonError;
	@Autowired
	private MockMvc mvc;
	@MockBean
	private EventService eventService;

	@Before
	public void setup() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		JacksonTester.initFields(this, objectMapper);
	}

	@Test
	public void shouldValidateDateMandatory() throws Exception {
		EventDTO event = newEvent();
		event.setDate(null);
		String content = json.write(event).getJson();
		
		ErrorDTO error = new ErrorDTO();
		error.setField("date");
		error.setRejectedValue(null);
		error.setError("may not be null");
		String expected = jsonError.write(Arrays.asList(error)).getJson();

		this.mvc.perform(post("/api/v1/event").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content))
				.andExpect(status().isBadRequest()).andExpect(content().string(expected));
	}
	
	@Test
	public void shouldValidateEstablishmentMandatory() throws Exception {
		EventDTO event = newEvent();
		event.setEstablishment(null);
		String content = json.write(event).getJson();
		
		ErrorDTO error = new ErrorDTO();
		error.setField("establishment");
		error.setRejectedValue(null);
		error.setError("may not be null");
		String expected = jsonError.write(Arrays.asList(error)).getJson();

		this.mvc.perform(post("/api/v1/event").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content))
				.andExpect(status().isBadRequest()).andExpect(content().string(expected));
	}
	
	@Test
	public void shouldValidateHouseTeamMandatory() throws Exception {
		EventDTO event = newEvent();
		event.setHouseTeam(null);
		String content = json.write(event).getJson();
		
		ErrorDTO error = new ErrorDTO();
		error.setField("houseTeam");
		error.setRejectedValue(null);
		error.setError("may not be null");
		String expected = jsonError.write(Arrays.asList(error)).getJson();

		this.mvc.perform(post("/api/v1/event").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content))
				.andExpect(status().isBadRequest()).andExpect(content().string(expected));
	}
	
	@Test
	public void shouldValidateVisitTeamMandatory() throws Exception {
		EventDTO event = newEvent();
		event.setVisitTeam(null);
		String content = json.write(event).getJson();
		
		ErrorDTO error = new ErrorDTO();
		error.setField("visitTeam");
		error.setRejectedValue(null);
		error.setError("may not be null");
		String expected = jsonError.write(Arrays.asList(error)).getJson();

		this.mvc.perform(post("/api/v1/event").contentType(MediaType.APPLICATION_JSON_UTF8_VALUE).content(content))
				.andExpect(status().isBadRequest()).andExpect(content().string(expected));
	}
	
	private EventDTO newEvent() {
		EventDTO event = new EventDTO();
		event.setDate(new Date());
		event.setEstablishment(1L);
		event.setHouseTeam(1L);
		event.setVisitTeam(1L);
		return event;
	}

}
