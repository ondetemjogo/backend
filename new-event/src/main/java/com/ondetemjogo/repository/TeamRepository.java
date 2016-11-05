package com.ondetemjogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
