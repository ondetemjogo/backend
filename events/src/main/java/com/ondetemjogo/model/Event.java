package com.ondetemjogo.model;

import java.util.Date;

public class Event {

	private Date date;
	private Establishment establishment;
	private Team houseTeam;
	private Team visitTeam;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Establishment getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Establishment establishment) {
		this.establishment = establishment;
	}

	public Team getHouseTeam() {
		return houseTeam;
	}

	public void setHouseTeam(Team houseTeam) {
		this.houseTeam = houseTeam;
	}

	public Team getVisitTeam() {
		return visitTeam;
	}

	public void setVisitTeam(Team visitTeam) {
		this.visitTeam = visitTeam;
	}

}
