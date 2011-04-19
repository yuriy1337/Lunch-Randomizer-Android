package com.devlevel0.lunchrandomizer;

import java.util.ArrayList;

import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class Selections{
	
	private ArrayList<Selection> allSelections = null;
	private Selection currentSelection = null;
	
	RestClient client = null;
	
	public Selections(RestClient client){
		this.client = client;
		allSelections = new ArrayList<Selection>();
	}
	
	public void updateCurrent(){
		String url = Settings.getCurrentSelectionUrl();
		client.setUrl(url);
		client.AddParam("format", "json");
    	
    	try {
    	    client.Execute(RestClient.RequestMethod.GET);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    	String response = client.getResponse();
    	
    	currentSelection = new Selection(response);
	} 
	
	public Selection getCurrent(){
		return currentSelection;
	}
}
