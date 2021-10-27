/*
 * Copyright (C) TALYS ™ - All Rights Reserved Unauthorized copying of this file, via any medium is
 * strictly prohibited Proprietary and confidential
 */
package com.esprit.microservice;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * {@link } class.
 *
 * @author hp
 * @since 0.1.0
 */
@Entity
public class Candidat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3090249096008711398L;
	@Id
	@GeneratedValue
	private int id;
	private String nom, prenom, email;

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
	 * @return the nom
	 */
	public String getNom() {

		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {

		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {

		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {

		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {

		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {

		this.email = email;
	}

	public Candidat() {

		super();
	}

	public Candidat(String nom) {

		this.nom = nom;
	}

}
