package org.rlopez.gestform.models;

import java.util.ArrayList;

public class Ecf {

    int id;
    String nom;
    int id_formation;
    Boolean resultat;
    ArrayList<Ecf> ecfs = new ArrayList<Ecf>();

    private Ecf(int id, String nom, int id_formation, Boolean resultat) {
        super();
        this.id = id;
        this.nom = nom;
        this.id_formation = id_formation;
        this.resultat = resultat;
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

    public int getId_formation() {
        return id_formation;
    }

    public void setId_formation(int id_formation) {
        this.id_formation = id_formation;
    }

    public Boolean getResultat() {
        return resultat;
    }

    public void setResultat(Boolean resultat) {
        this.resultat = resultat;
    }

}
