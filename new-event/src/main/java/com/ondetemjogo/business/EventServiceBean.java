package com.ondetemjogo.business;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.exception.BusinessException;
import com.ondetemjogo.model.Establishment;
import com.ondetemjogo.model.Event;
import com.ondetemjogo.model.Team;
import com.ondetemjogo.repository.EstablishmentRepository;
import com.ondetemjogo.repository.EventRepository;
import com.ondetemjogo.repository.TeamRepository;
import com.ondetemjogo.util.DateUtil;

@Service
public class EventServiceBean implements EventService {

	@Autowired
	private EventRepository eventRepository;
	@Autowired
	private EstablishmentRepository establishmentRepository;
	@Autowired
	private TeamRepository teamRepository;

	@Override
	public void save(EventDTO event) {
		Date maxDate = DateUtil.resetHour(new Date());
		if (maxDate.after(event.getDate())) {
			throw new BusinessException("Cannot use date in past");
		}
		
		Establishment establishment = establishmentRepository.findOne(event.getEstablishment());
		if (establishment == null) {
			throw new BusinessException("Invalid establishment, doesn't exists");
		}
		
		if (event.getHouseTeam() == event.getVisitTeam()) {
			throw new BusinessException("Invalid teams, cannot be equals");
		}
		
		Team houseTeam = teamRepository.findOne(event.getHouseTeam());
		if (houseTeam == null) {
			throw new BusinessException("Invalid house team, doesn't exists");
		}
		
		Team visitTeam = teamRepository.findOne(event.getVisitTeam());
		if (visitTeam == null) {
			throw new BusinessException("Invalid visit team, doesn't exists");
		}
		
		Event newEvent = new Event();
		newEvent.setDate(event.getDate());
		newEvent.setEstablishment(establishment);
		newEvent.setHouseTeam(houseTeam);
		newEvent.setVisitTeam(visitTeam);
		Event savedEvent = eventRepository.save(newEvent);
		if (savedEvent == null) {
			throw new BusinessException("It wasn't possible save the event");
		}
	}

}
