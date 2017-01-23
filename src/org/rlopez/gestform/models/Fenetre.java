package org.rlopez.gestform.models;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableModel;

import org.rlopez.gestform.dao.FormationDAO;
import org.rlopez.gestform.dao.StagiaireDAO;

public class Fenetre extends JFrame {
	public Fenetre() {

		JPanel pan = new JPanel(); //creation de la couche JPanel

		this.setTitle("Bienvenue sur la DB stagiaire");
		this.setSize(400, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setContentPane(pan);
		



		JButton btnAjouterStagiaire = new JButton("Ajouter des stagiaires"); // creation d'un bouton
		pan.add(btnAjouterStagiaire); // liaison du bouton à la couche Jpanel

		btnAjouterStagiaire.addActionListener(new ActionListener() { // Action lié au bouton btnAjouterStagiaire
			public void actionPerformed(ActionEvent e) {
				JOptionPane jop = new JOptionPane();
				String prenomStagiaire = JOptionPane.showInputDialog(null, "Entrez le prenom", "Ajout du prénom", JOptionPane.QUESTION_MESSAGE); // Création boite de dialogue
				String nomStagiaire = JOptionPane.showInputDialog(null, "Entrez le nom", "Ajout du Nom", JOptionPane.QUESTION_MESSAGE);
				String StrmatriculeStagiaire = JOptionPane.showInputDialog(null, "Matricule", "Ajout du  Matricule", JOptionPane.QUESTION_MESSAGE);
				int matriculeStagiaire = Integer.parseInt(StrmatriculeStagiaire);
				
				
				List<Formation> objetFormation = FormationDAO.findAllFormation(); // Création d'une nouvelle liste Formation qui appelle la méthode findAllFormation qui récupère la liste des formations
				Object[] tblFormation = objetFormation.toArray(); // On met le résultat de la liste sous forme de tableau
			    Object listeFormation = JOptionPane.showInputDialog(null, "Choisir la formation","Liste",JOptionPane.QUESTION_MESSAGE,null,tblFormation,tblFormation[2]);
			    
			    Formation formation = (Formation)listeFormation; 
			    
			    try {
					StagiaireDAO.save(new Stagiaire(1, nomStagiaire, prenomStagiaire, matriculeStagiaire , formation ));
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    
			}
		}); //fin ActionListener premier bouton
		
		
		
		JButton btnAjouterFormation = new JButton("Ajouter une formation");
		pan.add(btnAjouterFormation);
		btnAjouterFormation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ajoutFormation = JOptionPane.showInputDialog(null, "Entrez la formation : ", "Formation", JOptionPane.QUESTION_MESSAGE);
		
				FormationDAO.insertFormation(ajoutFormation);
		
			}
			});
		
		
//		JButton btnListeStagiaire = new JButton("Voir la liste des stagiaires");
//		pan.add(btnListeStagiaire);
//		btnListeStagiaire.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//
//
//			
//			});
		
		
		

		// JButton btnRchStagiaire = new JButton("Rechercher un stagiaire");
		// JButton btnQuitter = new JButton("Quitter");

		// pan.add(btnRchStagiaire);
		// pan.add(btnQuitter);

	}
}
