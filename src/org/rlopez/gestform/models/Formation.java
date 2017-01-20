package org.rlopez.gestform.models;

import java.util.ArrayList;

	public class Formation {

	int id;
	String nom;
	ArrayList<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
	ArrayList<Ecf> ecfs = new ArrayList<Ecf>();

	public Formation(String nom) {
		super();
		this.nom = nom;
	}
	

	public Formation(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}


	public void addStagiaire(Stagiaire s) {
		this.stagiaires.add(s);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Formation " + nom + " " + stagiaires;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
