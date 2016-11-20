package com.ondetemjogo.newevent.business;

import static org.mockito.BDDMockito.given;

import java.util.Calendar;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.newevent.business.EventService;
import com.ondetemjogo.newevent.dto.EventDTO;
import com.ondetemjogo.newevent.exception.BusinessException;
import com.ondetemjogo.newevent.model.Establishment;
import com.ondetemjogo.newevent.model.Event;
import com.ondetemjogo.newevent.model.Team;
import com.ondetemjogo.newevent.repository.EstablishmentRepository;
import com.ondetemjogo.newevent.repository.EventRepository;
import com.ondetemjogo.newevent.repository.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EventServiceBeanTest {

	private static final int DAY_MINUS = -1;

	@Autowired
	private EventService service;
	@MockBean
	private EventRepository eventRepository;
	@MockBean
	private EstablishmentRepository establishmentRepository;
	@MockBean
	private TeamRepository teamRepository;

	@Test
	public void shouldValidateDateInPast() {
		EventDTO event = newEvent();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DAY_OF_MONTH, DAY_MINUS);
		event.setDate(calendar.getTime());
		
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("Cannot use date in past", be.getError());
		}
	}
	
	@Test
	public void shouldValidateExistsEstablishment() {
		EventDTO event = newEvent();

		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(null);
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("Invalid establishment, doesn't exists", be.getError());
		}
	}
	
	@Test
	public void shouldValidateEqualsTeam() {
		EventDTO event = newEvent();
		event.setVisitTeam(1L);
		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(new Establishment());
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("Invalid teams, cannot be equals", be.getError());
		}
	}
	
	@Test
	public void shouldValidateHouseTeamExists() {
		EventDTO event = newEvent();

		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(new Establishment());
		given(teamRepository.findOne(event.getHouseTeam())).willReturn(null);
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("Invalid house team, doesn't exists", be.getError());
		}
	}
	
	@Test
	public void shouldValidateVisitTeamExists() {
		EventDTO event = newEvent();

		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(new Establishment());
		given(teamRepository.findOne(event.getHouseTeam())).willReturn(new Team());
		given(teamRepository.findOne(event.getVisitTeam())).willReturn(null);
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("Invalid visit team, doesn't exists", be.getError());
		}
	}
	
	@Test
	public void shouldSave() {
		EventDTO event = newEvent();

		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(new Establishment());
		given(teamRepository.findOne(event.getHouseTeam())).willReturn(new Team());
		given(teamRepository.findOne(event.getVisitTeam())).willReturn(new Team());
		given(eventRepository.save(BDDMockito.any(Event.class))).willReturn(new Event());
		
		service.save(event);
	}
	
	@Test
	public void shouldShowErrorInTheSave() {
		EventDTO event = newEvent();

		given(establishmentRepository.findOne(event.getEstablishment())).willReturn(new Establishment());
		given(teamRepository.findOne(event.getHouseTeam())).willReturn(new Team());
		given(teamRepository.findOne(event.getVisitTeam())).willReturn(new Team());
		given(eventRepository.save(BDDMockito.any(Event.class))).willReturn(null);
		
		try {
			service.save(event);
			Assert.fail("cannot be here");
		} catch (BusinessException be) {
			Assert.assertEquals("It wasn't possible save the event", be.getError());
		}
	}
	
	private EventDTO newEvent() {
		EventDTO event = new EventDTO();
		event.setDate(new Date());
		event.setEstablishment(1L);
		event.setHouseTeam(1L);
		event.setVisitTeam(2L);
		return event;
	}

}
