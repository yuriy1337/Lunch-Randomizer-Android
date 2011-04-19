package com.devlevel0.lunchrandomizer;

import org.json.JSONObject;

import android.util.Log;

public class Place {
	
	private JSONObject placeJSON = null;
	private String name = null;
	private String updated_at = null;
	private boolean is_catered = false;
	private int id = 0;
	private int category_id = 0;
	
	
	public Place(JSONObject placeJSON){
		this.placeJSON = placeJSON;
		extractData(placeJSON);
	}

	public String getName(){
		return name;
	}
	
	private void extractData(JSONObject sJSON){
		JSONObject placeJSON = sJSON.optJSONObject("place");
		name = placeJSON.optString("name");
		id = placeJSON.optInt("id");
		category_id = placeJSON.optInt("category_id");
		updated_at = placeJSON.optString("date_created");
		is_catered = placeJSON.optBoolean("is_catered");
	}
	
	
}

