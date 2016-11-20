package com.ondetemjogo.newevent.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Event {

	@Id
	@SequenceGenerator(name = "SEQ_EVENT", sequenceName = "GEN_EVENT_ID", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_EVENT", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_event")
	private Long idEvent;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date date;
	@ManyToOne
	@JoinColumn(name = "id_establishment", nullable = false)
	private Establishment establishment;
	@ManyToOne
	@JoinColumn(name = "id_house_team", nullable = false)
	private Team houseTeam;
	@ManyToOne
	@JoinColumn(name = "id_visit_team", nullable = false)
	private Team visitTeam;

	public Long getIdEvent() {
		return idEvent;
	}

	public void setIdEvent(Long idEvent) {
		this.idEvent = idEvent;
	}

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
