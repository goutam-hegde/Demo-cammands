package com.mindtree.ajaxandservletcodechallenge.DAO;

import java.sql.SQLException;
import java.util.List;

import com.mindtree.ajaxandservletcodechallenge.entity.Country;

public interface SaveDataToDB {

	
	public String saveDetails(List<Country> countries) throws SQLException;
}
