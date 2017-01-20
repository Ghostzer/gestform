package org.rlopez.gestform.models;

public class Resultat {

	int id;
	int note;
	Stagiaire stag;
	Ecf ecf;


	private Resultat(int id, int note, Stagiaire stag, Ecf ecf) {
		super();
		this.id = id;
		this.note = note;
		this.stag = stag;
		this.ecf = ecf;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}

	public Stagiaire getStag() {
		return stag;
	}
	public void setStag(Stagiaire stag) {
		this.stag = stag;
	}
	public Ecf getEcf() {
		return ecf;
	}
	public void setEcf(Ecf ecf) {
		this.ecf = ecf;
	}
	
	
	
	
}
