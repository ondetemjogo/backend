package com.ondetemjogo.event.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.event.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
