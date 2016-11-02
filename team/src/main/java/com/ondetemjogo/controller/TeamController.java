package com.ondetemjogo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ondetemjogo.adapter.TeamAdapter;
import com.ondetemjogo.business.TeamService;
import com.ondetemjogo.dto.TeamDTO;
import com.ondetemjogo.model.*;

@RestController
@RequestMapping("/api/v1")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = { "/search", "/search/{search}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<TeamDTO>> getEventsWithSearch(@PathVariable(value = "search", required = false) String search) {

		List<Team> events = teamService.getTeams(search);
		Set<TeamDTO> teamDTOs = new HashSet<>();
		for (Team team : events) {
			teamDTOs.add(new TeamAdapter(team).build());
		}
		return ResponseEntity.ok().body(teamDTOs);

	}

}
