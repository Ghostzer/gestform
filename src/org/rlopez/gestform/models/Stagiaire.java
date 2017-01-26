package org.rlopez.gestform.models;

import java.util.ArrayList;

public class Stagiaire extends Personne {

	int idStagiaire;
	int matricule;
	
	ArrayList<Ecf> ecfs = new ArrayList<Ecf>();
	
	// on déclare l'objet Formation (de la class Formation.java) afin de lié les 2 ensemble. Un genre "d'extend à l'envers".
	Formation formation;


	public Stagiaire(int id, String nom, String prenom, int matricule) {
		super(id, nom, prenom);
		this.matricule = matricule;
	}
	
	private Stagiaire(int id, String nom, String prenom, int idStagiaire, ArrayList<Ecf> ecfs, Formation formation) {
		super(id, nom, prenom);
		this.idStagiaire = idStagiaire;
		this.ecfs = ecfs;
		this.formation = formation;
	}
	
	public Stagiaire(int id, String nom, String prenom,
			int matricule, Formation formation) {
		super(id, nom, prenom);
		this.matricule = matricule;
		this.formation = formation;
	}
        
        public Stagiaire(int matricule, String nom, String prenom) {
		super(matricule, nom, prenom);
		this.matricule = matricule;
	}
	
	public Stagiaire(String nom, String prenom) {
		super(nom, prenom);
	}
        
        
        public Stagiaire(int matricule, String nom, String prenom, Formation formation) {
		super(matricule, nom, prenom);
                this.matricule = matricule;
		this.formation = formation;
	}

	

	public Formation getFormation() {
		return formation;
	}
	
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public int getMatricule() {
		return matricule;
	}

	public void setMatricule(int matricule) {
		this.matricule = matricule;
	}

	public String toString() {
		return "Stagiaire : " + " " + nom + " " + prenom + "[matricule=" + matricule + "]";
	}
	
	public int getIdStagiaire() {
		return idStagiaire;
	}
	
	public void setIdStagiaire(int idStagiaire) {
		this.idStagiaire = idStagiaire;
	}

	
	
	
	
}
