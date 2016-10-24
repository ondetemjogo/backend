package com.ondetemjogo.adapter;

import com.ondetemjogo.dto.EventDTO;
import com.ondetemjogo.model.Event;

public class EventAdapter {

	private Event event;
	
	public EventAdapter(Event event) {
		this.event = event;
	}

	public EventDTO build() {
		if (event == null) {
			return null;
		}
		EventDTO eventDTO = new EventDTO();
		eventDTO.setDate(event.getDate());
		eventDTO.setEstablishmentAddress(event.getEstablishment().getAddress());
		eventDTO.setEstablishmentImage(event.getEstablishment().getImage());
		eventDTO.setEstablishmentName(event.getEstablishment().getName());
		eventDTO.setHouseTeamImage(event.getHouseTeam().getImage());
		eventDTO.setHouseTeamName(event.getHouseTeam().getName());
		eventDTO.setVisitTeamImage(event.getVisitTeam().getImage());
		eventDTO.setVisitTeamName(event.getVisitTeam().getName());
		return eventDTO;
	}

}
