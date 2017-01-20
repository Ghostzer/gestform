package org.rlopez.gestform.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.rlopez.gestform.models.Formation;

public class FormationDAO {

	public static void insertFormation(String nom) {

		Statement st = null;

		Connection connection = ConnectDB.getConnection();

		try {
			st = connection.createStatement();

			String sql = "INSERT INTO `Formation` (`id`, `nom`) VALUES (NULL, '"
					+ nom + "')";
			st.executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

}
