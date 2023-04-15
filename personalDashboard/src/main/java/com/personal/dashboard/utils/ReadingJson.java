package com.personal.dashboard.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * Reading Json Utility
 *
 */
public class ReadingJson {

	public static JSONArray getJsonArray(String ObjectName, String fileLocation) {

		JSONParser parser = new JSONParser();
		JSONArray countries = new JSONArray();
		try {

			JSONObject jsonObject = (JSONObject) parser.parse(new FileReader(fileLocation));

			countries = (JSONArray) jsonObject.get(ObjectName);

		} catch (FileNotFoundException fe) {
			return null;
		} catch (Exception e) {
			return null;
		}

		return countries;
	}
}