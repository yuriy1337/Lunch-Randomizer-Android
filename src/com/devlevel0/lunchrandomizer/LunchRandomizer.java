package com.devlevel0.lunchrandomizer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class LunchRandomizer extends Activity {
	
	private Settings userSetting = null;
	private RestClient client = null;
	private Selections selections = null;
	private Places places = null;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        init();
        connect();
        
        selections = new Selections(client);
        places = new Places(client);
        
        places.updatePlaces();
        selections.updateCurrent();
        updateView(selections.getCurrent());
    }

    
	public void updateView(Selection currentSelection){
		TextView t = (TextView)findViewById(R.id.lunchOption);
		t.setText(places.getNameFromId(currentSelection.getPlaceId()));
		
		t = (TextView)findViewById(R.id.upvotesCount);
		t.setText(String.valueOf(currentSelection.getUps()));
		
		t = (TextView)findViewById(R.id.date);
		t.setText(currentSelection.getDate());
		
		t = (TextView)findViewById(R.id.downvotesCount);
		int i = currentSelection.getDowns();
		String s= String.valueOf(i);
		t.setText(s);
	}
    
    private void connect(){
		String url = Settings.getLoginUrl();
		client = new RestClient(url);
		client.AddParam("username", Settings.getUsername());
		client.AddParam("password", Settings.getPassword());
		client.AddParam("commit", "Login");
    	
    	try {
    	    client.Execute(RestClient.RequestMethod.POST);
    	} catch (Exception e) {
    	    e.printStackTrace();
    	}
    }
    
    private void init(){
    	//Settings.setServer("192.168.1.111:3000");
    	Settings.setServer("www.lunchrandomizer.com");
    	Settings.setUsername("<<your user name>>");
    	Settings.setPassword("<<your passowrd>>");
    }


   
}