package com.ondetemjogo.event.repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ondetemjogo.event.model.Establishment;
import com.ondetemjogo.event.model.Event;
import com.ondetemjogo.event.model.Team;
import com.ondetemjogo.event.repository.EstablishmentRepository;
import com.ondetemjogo.event.repository.EventRepository;
import com.ondetemjogo.event.repository.TeamRepository;
import com.ondetemjogo.event.specification.EventSpecification;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class EventRepositoryTest {

	@Autowired
	private EventRepository repository;
	
	@Autowired
	private EstablishmentRepository establishmentRepository;

	@Autowired
	private TeamRepository teamRepository;
	
	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	public void shouldSaveEvent() {
		Event event = new Event();
		event.setDate(new Date());
		
		Establishment establishment = establishmentRepository.findOne(1L);
		event.setEstablishment(establishment);
		
		Team houseTeam = teamRepository.findOne(1L);
		event.setHouseTeam(houseTeam);
		
		Team visitTeam = teamRepository.findOne(2L);
		event.setVisitTeam(visitTeam);
		
		Event newEvent = repository.saveAndFlush(event);
		Assert.assertNotNull(newEvent);
	}
	
	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	@DatabaseSetup("/event.xml")
	public void shouldSearchEventOnlyDate() throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.sss").parse("22-10-2016 00:00:00.000");
		Specification<Event> spec = EventSpecification.findEvents(date, null);
		List<Event> events = repository.findAll(spec);
		Assert.assertEquals(3, events.size());
	}
	
	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	@DatabaseSetup("/event.xml")
	public void shouldSearchEventWithEstablishmentName() throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.sss").parse("22-10-2016 00:00:00.000");
		Specification<Event> spec = EventSpecification.findEvents(date, "pinga");
		List<Event> events = repository.findAll(spec);
		Assert.assertEquals(1, events.size());
	}
	
	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	@DatabaseSetup("/event.xml")
	public void shouldSearchEventWithEstablishmentAddress() throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.sss").parse("22-10-2016 00:00:00.000");
		Specification<Event> spec = EventSpecification.findEvents(date, "Fim");
		List<Event> events = repository.findAll(spec);
		Assert.assertEquals(1, events.size());
	}

	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	@DatabaseSetup("/event.xml")
	public void shouldSearchEventWithHouseTeamName() throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.sss").parse("22-10-2016 00:00:00.000");
		Specification<Event> spec = EventSpecification.findEvents(date, "mengo");
		List<Event> events = repository.findAll(spec);
		Assert.assertEquals(1, events.size());
	}
	
	@Test
	@DatabaseSetup("/establishment.xml")
	@DatabaseSetup("/team.xml")
	@DatabaseSetup("/event.xml")
	public void shouldSearchEventWithVisitTeamName() throws ParseException {
		Date date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss.sss").parse("22-10-2016 00:00:00.000");
		Specification<Event> spec = EventSpecification.findEvents(date, "Palme");
		List<Event> events = repository.findAll(spec);
		Assert.assertEquals(1, events.size());
	}

}
