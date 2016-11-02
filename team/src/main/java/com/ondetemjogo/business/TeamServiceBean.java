package com.ondetemjogo.business;

import java.util.List;

import com.ondetemjogo.model.Team;
import com.ondetemjogo.repository.TeamRepository;

public class TeamServiceBean implements TeamService {

	private TeamRepository teamRepository;

	public List<Team> getTeams(String search) {

		return teamRepository.findAllByNameLike(search);
	}

}
