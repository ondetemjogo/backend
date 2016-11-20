package com.ondetemjogo.newevent.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.newevent.model.Team;

public interface TeamRepository extends JpaRepository<Team, Long> {

}
