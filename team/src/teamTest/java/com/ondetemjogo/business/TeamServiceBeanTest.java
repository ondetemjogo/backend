package com.ondetemjogo.business;

import static org.mockito.BDDMockito.given;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.model.Team;
import com.ondetemjogo.repository.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceBeanTest {

	@Autowired
	private TeamService service;

	@MockBean
	private TeamRepository teamRepository;

	@Test
	public void shouldReturnTeams() {
		List<Team> team = new ArrayList<>();
		String search = "Fla";
		given(teamRepository.findAllByNameLike(search)).willReturn(team);
		List<Team> result = service.getTeams(search);
		Assert.assertEquals(1, result.size());
	}

}
