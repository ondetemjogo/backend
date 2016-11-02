package com.ondetemjogo.adapter;

import com.ondetemjogo.dto.TeamDTO;
import com.ondetemjogo.model.Team;

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
		teamDTO.setHouseTeamName(team.getName());
		teamDTO.setImageHouseTeam(team.getImage());
		return teamDTO;
	}

}