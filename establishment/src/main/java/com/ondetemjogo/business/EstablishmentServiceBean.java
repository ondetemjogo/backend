package com.ondetemjogo.business;

import java.util.List;

import com.ondetemjogo.model.Establishment;
import com.ondetemjogo.repository.EstablishmentRepository;

public class EstablishmentServiceBean implements EstablishmentService {

	private EstablishmentRepository establishmentRepository;

	@SuppressWarnings("unchecked")
	public List<Establishment> getEstablishments(String search) {
		return (List<Establishment>) establishmentRepository;
	}

}
