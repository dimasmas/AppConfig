package com.opus.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {

	private static JSONObject mainObj;
	
	public JsonReader(String filePath) {
		try {
			JSONParser parser = new JSONParser();
			Object obj=parser.parse(new FileReader(filePath));
			
			mainObj =(JSONObject)obj;
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public JSONObject getBaseObj(Object base){
		if(base!=null){
			
			JSONObject jsonChild=(JSONObject)base;
			return jsonChild;
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}

	public  JSONObject getMainObj() {
		return mainObj;
	}

	
}
