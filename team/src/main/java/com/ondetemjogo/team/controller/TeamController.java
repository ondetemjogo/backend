package com.ondetemjogo.team.controller;

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

import com.ondetemjogo.team.adapter.TeamAdapter;
import com.ondetemjogo.team.business.TeamService;
import com.ondetemjogo.team.dto.TeamDTO;
import com.ondetemjogo.team.model.*;

@RestController
@RequestMapping("/api/v1")
public class TeamController {

	@Autowired
	private TeamService teamService;

	@RequestMapping(value = { "/team", "/team/{search}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<TeamDTO>> getTeamsWithSearch(@PathVariable(value = "search", required = false) String search) {

		List<Team> teams = teamService.getTeams(search);
		Set<TeamDTO> teamDTOs = new HashSet<>();
		for (Team team : teams) {
			teamDTOs.add(new TeamAdapter(team).build());
		}
		return ResponseEntity.ok().body(teamDTOs);

	}

}
