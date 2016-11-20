package com.ondetemjogo.newevent.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Establishment {

	@Id
	@SequenceGenerator(name = "SEQ_ESTABLISH", sequenceName = "GEN_ESTABLISH_ID", allocationSize = 1)
	@GeneratedValue(generator = "SEQ_ESTABLISH", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_establishment")
	private Long idEstablishment;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String address;
	private String image;

	public Long getIdEstablishment() {
		return idEstablishment;
	}

	public void setIdEstablishment(Long idEstablishment) {
		this.idEstablishment = idEstablishment;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
