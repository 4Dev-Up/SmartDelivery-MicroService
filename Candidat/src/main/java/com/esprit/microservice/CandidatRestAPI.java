/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@RestController
@RequestMapping(value = "/api/candidats")
public class CandidatRestAPI {
	private String title = "Hello,I'm the candidate Microservice";
	@Autowired
	CandidatService candidatService;

	@RequestMapping("/hello")
	public String sayHello() {

		System.out.println(title);
		return title;
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Candidat> createCandidat(@RequestBody Candidat candidat) {

		return new ResponseEntity<>(candidatService.addCandidat(candidat), HttpStatus.OK);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Candidat> updateCandidat(@PathVariable(value = "id") int id,
			@RequestBody Candidat candidat) {

		return new ResponseEntity<>(candidatService.updateCandidat(id, candidat), HttpStatus.OK);
	}

	@DeleteMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<String> deleteCandidat(@PathVariable(value = "id") int id) {

		return new ResponseEntity<String>(candidatService.deleteCandidat(id), HttpStatus.OK);
	}

}
