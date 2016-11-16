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

import com.ondetemjogo.model.Team;
import com.ondetemjogo.repository.TeamRepository;

@SuppressWarnings("unchecked")
@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceBeanTest {

	@Autowired
	private TeamService service;

	@MockBean
	private TeamRepository teamRepository;

	@Test
	public void shouldDoesntReturnTeams() {
		List<Team> teams = new ArrayList<>();
		given(teamRepository.findAll(any(Specification.class))).willReturn(teams);
		List<Team> result = service.getTeams("Fla");
		Assert.assertEquals(0, result.size());
	}
	
	@Test
	public void shouldReturnTeams() {
		List<Team> teams = new ArrayList<>();
		teams.add(new Team());
		given(teamRepository.findAll(any(Specification.class))).willReturn(teams);
		List<Team> result = service.getTeams("Flamengo");
		Assert.assertEquals(1, result.size());
	}

}
