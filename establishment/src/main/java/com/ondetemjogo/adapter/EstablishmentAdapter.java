package com.ondetemjogo.adapter;

import com.ondetemjogo.dto.EstablishmentDTO;
import com.ondetemjogo.model.Establishment;

public class EstablishmentAdapter {

	private Establishment establishment;

	public EstablishmentAdapter(Establishment establishment) {
		this.establishment = establishment;
	}

	public EstablishmentDTO build() {
		if (establishment == null) {
			return null;
		}
		EstablishmentDTO establishmentDTO = new EstablishmentDTO();
		establishmentDTO.setId(establishment.getIdEstablishment());
		establishmentDTO.setName(establishment.getName());
		establishmentDTO.setImage(establishment.getImage());
		return establishmentDTO;
	}
}
