package com.ondetemjogo.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ondetemjogo.adapter.EstablishmentAdapter;
import com.ondetemjogo.business.EstablishmentService;
import com.ondetemjogo.dto.EstablishmentDTO;
import com.ondetemjogo.model.Establishment;

@RestController
@RequestMapping("/api/v1")
public class EstablishmentController {

	@Autowired
	private EstablishmentService service;

	@RequestMapping(value = { "/establishment",
			"/establishment/{Search}" }, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Set<EstablishmentDTO>> getEstablishmentsWithSearch(
			@PathVariable(value = "search", required = false) String search) {

		List<Establishment> establishments = service.getEstablishments(search);
		Set<EstablishmentDTO> establishmentDTOs = new HashSet<>();
		for (Establishment establishment : establishments) {
			establishmentDTOs.add(new EstablishmentAdapter(establishment).build());
		}
		return ResponseEntity.ok().body(establishmentDTOs);
	}

}
