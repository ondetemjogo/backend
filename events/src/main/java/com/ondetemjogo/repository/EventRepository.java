package com.ondetemjogo.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ondetemjogo.model.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

	List<Event> findAllByDateGreaterThanEqual(Date date);

}
