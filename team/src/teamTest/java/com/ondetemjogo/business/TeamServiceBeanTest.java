package com.ondetemjogo.business;

import static org.mockito.BDDMockito.given;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.ondetemjogo.repository.TeamRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TeamServiceBeanTest {

	@MockBean
	private TeamRepository teamRepository;

	@Test
	public void shouldReturnTeams() {

	}

}
