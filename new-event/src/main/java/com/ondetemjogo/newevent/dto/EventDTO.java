package com.ondetemjogo.newevent.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;

public class EventDTO {

	@NotNull
	private Date date;
	@NotNull
	private Long establishment;
	@NotNull
	private Long houseTeam;
	@NotNull
	private Long visitTeam;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getEstablishment() {
		return establishment;
	}

	public void setEstablishment(Long establishment) {
		this.establishment = establishment;
	}

	public Long getHouseTeam() {
		return houseTeam;
	}

	public void setHouseTeam(Long houseTeam) {
		this.houseTeam = houseTeam;
	}

	public Long getVisitTeam() {
		return visitTeam;
	}

	public void setVisitTeam(Long visitTeam) {
		this.visitTeam = visitTeam;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((establishment == null) ? 0 : establishment.hashCode());
		result = prime * result + ((houseTeam == null) ? 0 : houseTeam.hashCode());
		result = prime * result + ((visitTeam == null) ? 0 : visitTeam.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventDTO other = (EventDTO) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (establishment == null) {
			if (other.establishment != null)
				return false;
		} else if (!establishment.equals(other.establishment))
			return false;
		if (houseTeam == null) {
			if (other.houseTeam != null)
				return false;
		} else if (!houseTeam.equals(other.houseTeam))
			return false;
		if (visitTeam == null) {
			if (other.visitTeam != null)
				return false;
		} else if (!visitTeam.equals(other.visitTeam))
			return false;
		return true;
	}

}
