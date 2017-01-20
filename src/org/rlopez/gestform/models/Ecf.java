package org.rlopez.gestform.models;

import java.util.ArrayList;

public class Ecf {

		int id;
		String nom;
		ArrayList<Stagiaire> stagiaires = new ArrayList<Stagiaire>();
		
		
		private Ecf(int id, String nom) {
			super();
			this.id = id;
			this.nom = nom;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

	}
