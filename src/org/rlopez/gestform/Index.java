package org.rlopez.gestform;


import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;

import org.rlopez.gestform.dao.FormationDAO;
import org.rlopez.gestform.dao.PersonneDAO;
import org.rlopez.gestform.dao.StagiaireDAO;

import org.rlopez.gestform.models.Fenetre;
import org.rlopez.gestform.models.Formation;
import org.rlopez.gestform.models.Personne;
import org.rlopez.gestform.models.Stagiaire;


public class Index {

	/**
	 * @param args
	 */

	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);

		int menu = 0;
		char reponse = 'o';

		Formation formation = new Formation("DL");

		Fenetre fen = new Fenetre();

		while (reponse == 'o' || reponse == 'n') {

			System.out.println("\n\n----------------------------------------");
			System.out.println("|   Bienvenue sur la DB stagiaire      |");
			System.out.println("|--------------------------------------|");
			System.out.println("|                                      |");
			System.out.println("| Menu :                               |");
			System.out.println("| ------                               |");
			System.out.println("|                                      |");
			System.out.println("| 1.) Entrer les stagiaires            |");
			System.out.println("| 2.) Entrer une nouvelle formation    |");
			System.out.println("| 3.) Voir la liste des stagiaires     |");
			System.out.println("| 4.) Rechercher un stagiaire          |");
			System.out.println("| 5.) Entrer les stagiaires v2         |");
			System.out.println("| 6.) Quitter                          |");
			System.out.println("|                                v 0.2 |");
			System.out.println("----------------------------------------");

			menu = Integer.parseInt(sc.nextLine());

			if (menu == 1) {
				reponse = 'o'; // On ré-initialise la var reponse à "o". Sinon
								// bug = Quand on ne continue pas l'entrée des
								// noms/prenoms stagiaires, on ne peut pas
								// re-selectionner le menu 1.
				while (reponse == 'o') {

					System.out.println("Nom du stagiaire : ");
					String nomStagiaire = sc.nextLine();
					System.out.println("Prenom du stagiaire : ");
					String prenomStagiaire = sc.nextLine();
					System.out.println("Matricule : ");
					int matriculeStagiaire = Integer.parseInt(sc
							.nextLine());

					int id = 0;
					String var_nom = nomStagiaire;
					String var_prenom = prenomStagiaire;
					int var_matricule = matriculeStagiaire;

					Stagiaire stagiaire = new Stagiaire(id, var_nom,
							var_prenom, var_matricule);
					System.out.println("Le stagiaire " + stagiaire.getNom()
							+ " " + stagiaire.getPrenom() + " "
							+ stagiaire.getMatricule() + " est inscrit !\n");

					formation.addStagiaire(stagiaire);
					reponse = ' ';
					while (reponse != 'o' && reponse != 'n') {

						System.out.println("Continue ? o/n : ");
						reponse = sc.nextLine().charAt(0);
					}
				}
			} else if (menu == 2) {
				System.out.println("Entrez le nom de la formation : ");
				String newFormation = sc.nextLine();
				FormationDAO.insertFormation(newFormation);
				System.out.println("Ok !");

			} else if (menu == 3) {
				
				//System.out.println(formation);
				Thread.sleep(2000);
				
			} else if (menu == 4) {
				System.out.println("Quel nom ?");
				String newNom = sc.nextLine();
				Personne p = PersonneDAO.findByNom(newNom);
				System.out.println(p);
				
			} else if (menu == 5) {
				System.out.println("Nom : ");
				String nomStagiaire = sc.nextLine();
				System.out.println("Prenom : ");
				String prenomStagiaire = sc.nextLine();
				System.out.println("Matricule : ");
				int matriculeStagiaire = Integer.parseInt(sc.nextLine());
				
				
				List<Formation> formations = FormationDAO.findAllFormation();
						
			for (Formation form : formations) {
				 System.out.print(form.getId() + " " + form.getNom()+"\n");
			}
			System.out.println("Veuillez choisir le numéro correspondant à votre formation : ");
			int id = Integer.parseInt(sc.nextLine());
			Formation f = null;
			
			for (Formation form : formations) { 
				if (form.getId() == id) { 
					f = form; 
					break; }
			}
			
			try {
				StagiaireDAO.save(new Stagiaire(1, nomStagiaire, prenomStagiaire, matriculeStagiaire , f ));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}

			else {
				System.out.println("Bye !");
				break;

			}
		}
	}

}
