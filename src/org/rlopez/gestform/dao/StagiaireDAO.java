package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

	
}
