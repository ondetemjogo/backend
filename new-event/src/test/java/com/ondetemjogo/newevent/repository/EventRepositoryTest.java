package com.ondetemjogo.newevent.repository;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.ondetemjogo.newevent.model.Establishment;
import com.ondetemjogo.newevent.model.Event;
import com.ondetemjogo.newevent.model.Team;
import com.ondetemjogo.newevent.repository.EstablishmentRepository;
import com.ondetemjogo.newevent.repository.EventRepository;
import com.ondetemjogo.newevent.repository.TeamRepository;

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
	
}
