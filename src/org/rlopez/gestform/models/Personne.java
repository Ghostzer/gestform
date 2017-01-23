package org.rlopez.gestform.models;

public class Personne {

	 int idPersonne;
	 String nom;
	 String prenom;
	
//	 constructeur
	 public Personne(String nom, String prenom) {
		 super();
		 this.nom = nom;
		 this.prenom = prenom;
	 }
	 
	 public Personne(int idPersonne, String nom, String prenom) {
		 super();
		 this.idPersonne = idPersonne;
		 this.nom = nom;
		 this.prenom = prenom;
	 }
	 

	public int getId() {
		return idPersonne;
	}

	public void setId(int id) {
		this.idPersonne = id;
	}

	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", nom=" + nom
				+ ", prenom=" + prenom + "]";
	}	
	
}
