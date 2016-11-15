package com.ondetemjogo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Establishment {

	@Id
	@SequenceGenerator(name = "SEQ_ESTABLISHMENT", sequenceName = "GEN_ESTABLISHMENT_ID", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ESTABLISHMENT", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_team")
	private int idEstablishment;
	@Column(nullable = false)
	private String name;
	private String image;

	public int getIdEstablishment() {
		return idEstablishment;
	}

	public void setIdEstablishment(int idEstablishment) {
		this.idEstablishment = idEstablishment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
