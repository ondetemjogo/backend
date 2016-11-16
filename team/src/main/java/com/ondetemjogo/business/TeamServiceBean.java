package com.ondetemjogo.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.ondetemjogo.model.Team;
import com.ondetemjogo.repository.TeamRepository;
import com.ondetemjogo.specification.TeamSpecification;

@Service
public class TeamServiceBean implements TeamService {

	@Autowired
	private TeamRepository teamRepository;

	public List<Team> getTeams(String search) {
		Specification<Team> specs = TeamSpecification.findTeams(search);
		return teamRepository.findAll(specs);
	}

}
