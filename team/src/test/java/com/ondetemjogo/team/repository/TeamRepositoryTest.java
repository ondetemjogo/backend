package com.ondetemjogo.team.repository;

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
import com.ondetemjogo.team.model.Team;
import com.ondetemjogo.team.repository.TeamRepository;
import com.ondetemjogo.team.specification.TeamSpecification;

@RunWith(SpringRunner.class)
@DataJpaTest
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
    DirtiesContextTestExecutionListener.class,
   TransactionalTestExecutionListener.class,
    DbUnitTestExecutionListener.class })
public class TeamRepositoryTest {

	@Autowired
	private TeamRepository repository;

	@Test
	public void shouldSaveTeam() {
		Team team = new Team();
		team.setName("Flamengo");
		Team newTeam = repository.saveAndFlush(team);
		Assert.assertNotNull(newTeam);
	}

	@Test
	@DatabaseSetup("/team.xml")
	public void shouldSearchTeamWithPartialValue() {
		Specification<Team> spec = TeamSpecification.findTeams("Flam");
		List<Team> teams = repository.findAll(spec);
		Assert.assertEquals(1, teams.size());
	}
	
	@Test
	@DatabaseSetup("/team.xml")
	public void shouldDoesntReturnTeamsWithSearchInvalid() {
		Specification<Team> spec = TeamSpecification.findTeams("desconhecido");
		List<Team> teams = repository.findAll(spec);
		Assert.assertEquals(0, teams.size());
	}
	
	@Test
	@DatabaseSetup("/team.xml")
	public void shouldReturnAllTeamsWithoutValue() {
		Specification<Team> spec = TeamSpecification.findTeams(null);
		List<Team> teams = repository.findAll(spec);
		Assert.assertEquals(4, teams.size());
	}
}
