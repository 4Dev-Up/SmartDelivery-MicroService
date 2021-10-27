/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Table(name="AERO")
@Entity

public class Aero implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3090249096008711398L;
	@Id
	@GeneratedValue
	private int id;
	private String matricule, capacite, chauffeur;

	/**
	 * @return the id
	 */
	public int getId() {

		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {

		this.id = id;
	}

	/**
	 * @return the matricule
	 */
	public String getMatricule() {

		return matricule;
	}

	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {

		this.matricule = matricule;
	}

	/**
	 * @return the capacite
	 */
	public String getCapacite() {

		return capacite;
	}

	/**
	 * @param capacite the capacite to set
	 */
	public void setCapacite(String capacite) {

		this.capacite = capacite;
	}

	/**
	 * @return the chauffeur
	 */
	public String getChauffeur() {

		return chauffeur;
	}

	/**
	 * @param chauffeur the chauffeur to set
	 */
	public void setChauffeur(String chauffeur) {

		this.chauffeur = chauffeur;
	}

	/**
	 * @param id
	 * @param matricule
	 * @param capacite
	 * @param chauffeur
	 */
	public Aero(int id, String matricule, String capacite, String chauffeur) {

		super();
		this.id = id;
		this.matricule = matricule;
		this.capacite = capacite;
		this.chauffeur = chauffeur;
	}

	public Aero() {

		super();
	}

}
