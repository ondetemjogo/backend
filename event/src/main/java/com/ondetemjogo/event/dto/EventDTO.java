package com.ondetemjogo.event.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class EventDTO {

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String establishmentName;
	private String establishmentAddress;
	private String establishmentImage;
	private String houseTeamName;
	private String houseTeamImage;
	private String visitTeamName;
	private String visitTeamImage;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEstablishmentName() {
		return establishmentName;
	}

	public void setEstablishmentName(String establishmentName) {
		this.establishmentName = establishmentName;
	}

	public String getEstablishmentAddress() {
		return establishmentAddress;
	}

	public void setEstablishmentAddress(String establishmentAddress) {
		this.establishmentAddress = establishmentAddress;
	}

	public String getEstablishmentImage() {
		return establishmentImage;
	}

	public void setEstablishmentImage(String establishmentImage) {
		this.establishmentImage = establishmentImage;
	}

	public String getHouseTeamName() {
		return houseTeamName;
	}

	public void setHouseTeamName(String houseTeamName) {
		this.houseTeamName = houseTeamName;
	}

	public String getHouseTeamImage() {
		return houseTeamImage;
	}

	public void setHouseTeamImage(String houseTeamImage) {
		this.houseTeamImage = houseTeamImage;
	}

	public String getVisitTeamName() {
		return visitTeamName;
	}

	public void setVisitTeamName(String visitTeamName) {
		this.visitTeamName = visitTeamName;
	}

	public String getVisitTeamImage() {
		return visitTeamImage;
	}

	public void setVisitTeamImage(String visitTeamImage) {
		this.visitTeamImage = visitTeamImage;
	}

}
