package com.devlevel0.lunchrandomizer;

import java.util.Date;

import org.json.JSONObject;

import android.text.format.DateFormat;
import android.util.Log;

public class Selection {

	private JSONObject selectionJSON = null;
	private String selection = null;
	private int id = 0;
	private int place_id = 0;
	private String date = null;
	private int ups = 0;
	private int downs = 0;
	
	
	public Selection(String selection){
		this.selection = selection;
		stringToJson(selection);
	}
	
	public int getPlaceId(){
		return place_id;
	}
	
	public String getDate(){
		return date;
	}
	
	public int getUps(){
		return ups;
	}
	
	public int getDowns(){
		return downs;
	}

	
	private void stringToJson(String selection){
    	try {
    		selectionJSON = new JSONObject(selection);
      	}
      	catch (Exception e){
      		Log.i("Lunch Randomizer", e.toString());
      	}
      	extractData(selectionJSON);
	}

	private void extractData(JSONObject sJSON){
		JSONObject curSel = sJSON.optJSONObject("current_selection");
		if(curSel == null){
			selectionJSON = sJSON.optJSONObject("selection");
		}
		else{
			selectionJSON = curSel.optJSONObject("selection");
			try{
			ups = sJSON.optInt("ups");
			downs = sJSON.optInt("downs");
			}
			catch(Exception e){
				Log.e("Lunch Randomizer", "Failed to get ups and downs");
			}
		}
		id = selectionJSON.optInt("id");
		place_id = selectionJSON.optInt("place_id");
		date = selectionJSON.optString("date_created");
	}
}
