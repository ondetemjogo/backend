package com.ondetemjogo.team.adapter;

import com.ondetemjogo.team.dto.TeamDTO;
import com.ondetemjogo.team.model.Team;

public class TeamAdapter {

	private Team team;

	public TeamAdapter(Team team) {
		this.team = team;
	}

	public TeamDTO build() {
		if (team == null) {
			return null;
		}

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setId(team.getIdTeam());
		teamDTO.setImage(team.getImage());
		teamDTO.setName(team.getName());
		return teamDTO;
	}

}
