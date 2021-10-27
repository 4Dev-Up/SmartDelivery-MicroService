/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
public interface CandidatRepository extends JpaRepository<Candidat, Integer> {
	@Query("select c from Candidat c where c.nom like :nom")
	public Page<Candidat> candidatByNom(@Param("nom") String n, Pageable pageable);

}
