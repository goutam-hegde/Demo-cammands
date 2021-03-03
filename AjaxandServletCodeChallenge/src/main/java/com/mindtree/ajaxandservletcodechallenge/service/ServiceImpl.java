package com.mindtree.ajaxandservletcodechallenge.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.mindtree.ajaxandservletcodechallenge.DAO.SaveDataToDB;
import com.mindtree.ajaxandservletcodechallenge.DAO.SaveDataToDBImpl;
import com.mindtree.ajaxandservletcodechallenge.entity.Country;

public class ServiceImpl implements Service {

	public String parseJsonData(String json) {
		
		String message="";
		List<Country> countries = new ArrayList<Country>();
		Object obj;
		try {
			obj = new JSONParser().parse(json);

			JSONArray array = (JSONArray) obj;
			for (int i = 0; i < 5; i++) {
				JSONObject jsonObj = (JSONObject) array.get(i);

				String name = (String) jsonObj.get("name");
				String capital = (String) jsonObj.get("capital");
				String region = (String) jsonObj.get("region");
				long population = (Long) jsonObj.get("population");
				long area = (Long) jsonObj.get("area");

				Country country = new Country(name, capital, region, population, area);
				countries.add(country);

			}

		} catch (ParseException e) {
			e.printStackTrace();
		}

	
		SaveDataToDB saveData=new SaveDataToDBImpl();
		try {
			message = saveData.saveDetails(countries);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return message;
	}
}
