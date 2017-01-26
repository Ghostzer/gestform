package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.rlopez.gestform.models.Formation;

public class FormationDAO {

//    public static void insertFormation(String nom) {
//
//        Statement st = null;
//
//        Connection connection = ConnectDB.getConnection();
//
//        try {
//            st = connection.createStatement();
//
//            String sql = "INSERT INTO `Formation` (`id`, `nom`) VALUES (NULL, '"
//                    + nom + "')";
//            st.executeUpdate(sql);
//
//        } catch (SQLException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }
    
    
public static void ajoutFormation(Formation f) throws Exception {
        Connection connection = ConnectDB.getConnection();

        PreparedStatement ftmCreateFormation;
        try {
            connection.setAutoCommit(false);

            ftmCreateFormation = connection.prepareStatement("INSERT INTO Formation (nom) VALUES(?);", Statement.RETURN_GENERATED_KEYS);
            ftmCreateFormation.setString(1, f.getNom());


            ftmCreateFormation.execute();


            connection.commit();
            ftmCreateFormation.close();

        } catch (SQLException e) {
            //pb if here
            connection.rollback();
            throw new Exception("error while creating personne " + e.getMessage());
        }
    }
    
    
    public static List<Formation> findAllFormation() {

        Connection connection = ConnectDB.getConnection();

        List<Formation> formations = new ArrayList<>();
        Statement stm;
        try {
            stm = connection.createStatement();

            String sql = "select * from Formation";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");

                Formation f = new Formation(id, nom);

                formations.add(f);
            }
            rs.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }

        return formations;

    }

    public static Formation findBy(int id) {
        Formation p = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement("select * from Formation WHERE id= ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Formation(rs.getInt("id"), rs.getString("nom"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

        return p;
    }
    
    
        public static void supprimerFormation(Formation f) {
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try {

            stm = connection.prepareStatement("DELETE FROM Formation WHERE id = ?");
            stm.setInt(1, f.getId());
            stm.executeUpdate();

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
    

}
