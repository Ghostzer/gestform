package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.rlopez.gestform.models.Formation;
import org.rlopez.gestform.models.Stagiaire;

public class StagiaireDAO {

	public static void save(Stagiaire s) throws Exception {
        Connection connection = ConnectDB.getConnection();

        PreparedStatement stmCreatePersonne;
        PreparedStatement stmCreateStagiaire;
        try {
            connection.setAutoCommit(false);

            stmCreatePersonne = connection.prepareStatement("INSERT INTO Personne (nom, prenom) VALUES(?, ?);", Statement.RETURN_GENERATED_KEYS);
            stmCreatePersonne.setString(1, s.getNom());
            stmCreatePersonne.setString(2, s.getPrenom());

            stmCreatePersonne.execute();

            // get autoincrement pour récupérer l'ID de la Personne nouvellement créée
            ResultSet rs = stmCreatePersonne.getGeneratedKeys();
            if (!rs.next()) {
                throw new Exception("humm cannot get generated personne id");
            }
            s.setId(rs.getInt(1));

            stmCreateStagiaire = connection.prepareStatement("INSERT INTO Stagiaire (Matricule, id_personne, id_formation) VALUES(?, ?, ?);");
            stmCreateStagiaire.setInt(1, s.getMatricule());
            stmCreateStagiaire.setInt(2, s.getId());
            stmCreateStagiaire.setInt(3, s.getFormation().getId());
            
            stmCreateStagiaire.execute();

            connection.commit();
            stmCreatePersonne.close();
            stmCreateStagiaire.close();

        } catch (SQLException e) {
            //pb if here
            connection.rollback();
            throw new Exception("error while creating personne " + e.getMessage());
        }
    }
	
	
	
	public static List<Stagiaire> findAllStagiaire() {

		Connection connection = ConnectDB.getConnection();

		List<Stagiaire> Stagiaires = new ArrayList<>();
		Statement stm;
		try {
			stm = connection.createStatement();

			String sql = "select * from Stagiaire INNER JOIN Formation ON Stagiaire.id_formation=Formation.id ";
			ResultSet rs = stm.executeQuery(sql);

			while (rs.next()) {

				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				Stagiaire s = new Stagiaire(nom, prenom);

				Stagiaires.add(s);
			}
			rs.close();

		} catch (SQLException e) {
			throw new RuntimeException();
		}

		return Stagiaires;

	}
	
	
	
	

	
}
