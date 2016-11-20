package com.ondetemjogo.team.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ondetemjogo.team.model.Team;
import com.ondetemjogo.team.repository.TeamRepository;
import com.ondetemjogo.team.specification.TeamSpecification;

@Service
public class TeamServiceBean implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public List<Team> getTeams(String search) {
		Specification<Team> specs = TeamSpecification.findTeams(search);
		return teamRepository.findAll(specs);
	}

}
