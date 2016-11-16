package com.ondetemjogo.controller;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
import com.ondetemjogo.adapter.TeamAdapter;
import com.ondetemjogo.business.TeamService;
import com.ondetemjogo.dto.TeamDTO;
import com.ondetemjogo.model.Team;

@RunWith(SpringRunner.class)
@WebMvcTest(TeamController.class)
@AutoConfigureMockMvc
public class TeamControllerTest {

	private JacksonTester<List<TeamDTO>> json;

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TeamService service;

	@Before
	public void setup() {
		ObjectMapper objectMapper = new ObjectMapper();
		JacksonTester.initFields(this, objectMapper);
	}

	@Test
	public void shouldCallService() throws Exception {
		List<TeamDTO> teams = new ArrayList<>();
		Team team = new Team();
		team.setIdTeam(1L);
		team.setName("Flamengo");
		team.setImage("/images/flamengo.png");
		teams.add(new TeamAdapter(team).build());
		String expected = json.write(teams).getJson();
		given(service.getTeams("Flamengo")).willReturn(Arrays.asList(team));

		this.mvc.perform(get("/api/v1/team/Flamengo").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().string(expected));

	}

	@Test
	public void shouldCallServiceWithoutSearch() throws Exception {
		List<TeamDTO> teams = new ArrayList<>();
		Team team = new Team();
		team.setIdTeam(1L);
		team.setName("Flamengo");
		team.setImage("/images/flamengo.png");
		teams.add(new TeamAdapter(team).build());
		String expected = json.write(teams).getJson();
		given(service.getTeams(null)).willReturn(Arrays.asList(team));

		this.mvc.perform(get("/api/v1/team/").accept(MediaType.APPLICATION_JSON_UTF8)).andExpect(status().isOk())
				.andExpect(content().string(expected));
	}
	
	@Test
	public void shouldCallServiceAndDoesntReturnNothing() throws Exception {
		List<TeamDTO> teams = new ArrayList<>();
		String expected = json.write(teams).getJson();
		given(service.getTeams("Salamaleico")).willReturn(Collections.emptyList());

		this.mvc.perform(get("/api/v1/team/Salamaleico").accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk()).andExpect(content().string(expected));
	}

}
