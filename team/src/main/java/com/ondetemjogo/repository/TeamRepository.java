package com.ondetemjogo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

	List<Team> findAllByNameLike(String search);
	
}
