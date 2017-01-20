package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.rlopez.gestform.models.Personne;

public class PersonneDAO {

	public static Personne findByNom(String nom) {
		Personne p = null;
        Connection connection = ConnectDB.getConnection();
        PreparedStatement stm;
        try {
            stm = connection.prepareStatement("select * from Personne WHERE nom= ?");
            stm.setString(1, nom);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                p = new Personne(rs.getString("nom"), rs.getString("prenom"));
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new RuntimeException();
        }

        return p;
}
	
}
