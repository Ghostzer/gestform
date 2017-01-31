/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.rlopez.gestform.models.Ecf;
import org.rlopez.gestform.models.Formation;
import org.rlopez.gestform.models.Stagiaire;

/**
 *
 * @author rico
 */
public class EcfDAO {
    public static void ajoutEcf(Ecf ecf) throws Exception {
        Connection connection = ConnectDB.getConnection();

        PreparedStatement etmCreateEcf;
        try {
            connection.setAutoCommit(false);

            etmCreateEcf = connection.prepareStatement("INSERT INTO Ecf (nom) VALUES(?);", Statement.RETURN_GENERATED_KEYS);
            etmCreateEcf.setString(1, ecf.getNom());


            etmCreateEcf.execute();


            connection.commit();
            etmCreateEcf.close();

        } catch (SQLException e) {
            //pb if here
            connection.rollback();
            throw new Exception("error while creating personne " + e.getMessage());
        }
    }
    
    
    public static List<Ecf> findAllEcf() {

        Connection connection = ConnectDB.getConnection();

        List<Ecf> Ecfs = new ArrayList<>();
        Statement stm;
        try {
            stm = connection.createStatement();

            String sql = "select * from Ecf e INNER JOIN Formation f ON e.id_formation=f.id";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                Formation formation = FormationDAO.findBy(rs.getInt("f.id"));
                Boolean resultat = rs.getBoolean("resultat");
                Ecf e = new Ecf(id, nom, formation, resultat);

                Ecfs.add(e);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return Ecfs;

    }

    public static Ecf findBy(int id) {
        Ecf ecf = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement("select * from Ecf WHERE id= ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                ecf = new Ecf(rs.getInt("id"), rs.getString("nom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return ecf;
    }
    
    
        public static void supprimerEcf(Ecf ecf) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement etm;
        try {

            etm = connection.prepareStatement("DELETE FROM Ecf WHERE id = ?");
            etm.setInt(1, ecf.getId());
            etm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
        
            public static void updateResultat(Ecf s) throws Exception {
        Connection connection = ConnectDB.getConnection();

        PreparedStatement etmUpdateResultat;
        try {
            connection.setAutoCommit(false);

            etmUpdateResultat = connection.prepareStatement("UPDATE Ecf SET resultat = ?");
            etmUpdateResultat.setBoolean(1, s.getResultat());

            etmUpdateResultat.execute();

            

            connection.commit();
            etmUpdateResultat.close();

        } catch (SQLException e) {
            //pb if here
            connection.rollback();
            throw new Exception("error while creating personne " + e.getMessage());
        }
    }
        
}
