package com.devlevel0.lunchrandomizer;

public class Settings {
	
	private static String username = null;
	private static String password = null;
	private static String server = null;
	
	private static String loginPath = "/en/login";
	private static String currentSelectionPath = "/en/selections/current";
	private static String placesPath = "/en/places";
	public Settings(){
		
	}
	
	public static String getUsername(){
		return username;
	}
	
	public static String getPassword(){
		return password;
	}

	public static String getServer(){
		return server;
	}
	
	public static String getLoginPath(){
		return loginPath;
	}
	
	public static void setUsername(String username){
		Settings.username = username;
	}
	
	public static void setPassword(String password){
		Settings.password = password;
	}
	
	public static void setServer(String server){
		Settings.server = server;
	}
	
	private static void setLoginpath(String loginPath){
		Settings.loginPath = loginPath;
	}
	
	public static String getLoginUrl(){
		return "http://" + Settings.server + Settings.loginPath;
	}
	
	public static String getCurrentSelectionUrl(){
		return "http://" + Settings.server + Settings.currentSelectionPath;
	}
	
	public static String getPlacesUrl(){
		return "http://" + Settings.server + Settings.placesPath;
	}
}
