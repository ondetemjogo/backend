package com.ondetemjogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
