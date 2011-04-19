package com.devlevel0.lunchrandomizer;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class Places {

	private JSONArray placesJSON = null;
	private ArrayList<Place> places = null;
	RestClient client = null;
	
	
	public Places(RestClient client){
		this.client = client;
		places = new ArrayList<Place>();
	}
	
	public void updatePlaces(){
		String url = Settings.getPlacesUrl();
		client.setUrl(url);
		client.AddParam("format", "json");
    	
    	try {
    	    client.Execute(RestClient.RequestMethod.GET);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	String response = client.getResponse();
    	
    	createPlacesArray(response);
	} 
	
	public String getNameFromId(int id){
		return places.get(id - 1).getName();
	}
	
	private void createPlacesArray(String response) {
    	try {
    		placesJSON = new JSONArray(response);
      	}
      	catch (Exception e){
      		Log.i("Lunch Randomizer", e.toString());
      	}
      	
      	for (int i = 0; i < placesJSON.length(); i++) {
			try {
				places.add(i, new Place((JSONObject) placesJSON.get(i)));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
