package com.mindtree.ajaxandservletcodechallenge.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.mindtree.ajaxandservletcodechallenge.Utility.DBConnection;
import com.mindtree.ajaxandservletcodechallenge.Utility.DBConnectionImpl;
import com.mindtree.ajaxandservletcodechallenge.entity.Country;

public class SaveDataToDBImpl implements SaveDataToDB {

	public String saveDetails(List<Country> countries) throws SQLException {
		Connection con;

		PreparedStatement pst;

		DBConnection db = new DBConnectionImpl();

		con = db.createConnection();

		boolean flag = false;

		String query = "insert into country values(?,?,?,?,?)";
		pst = con.prepareStatement(query);

		for (int i = 0; i < countries.size(); i++) {
			pst.setString(1, countries.get(i).getName());
			pst.setString(2, countries.get(i).getCapital());
			pst.setString(3, countries.get(i).getRegion());
			pst.setLong(4, countries.get(i).getPopulation());
			pst.setDouble(5, countries.get(i).getArea());

			pst.execute();
			flag = true;
		}

		if (flag) {
			return "success";
		} else {

			return "failure";
		}

	}

}
