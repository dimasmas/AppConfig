package com.opus.gen;

import java.io.IOException;
import java.util.Iterator;

/*
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

*/
import org.json.simple.*;

import com.opus.configurations.e_avaliableClasses;
import com.opus.utilities.JsonReader;
import com.opus.utilities.PropReader;

public class Translator {

	public Translator(e_avaliableClasses worker) {
		// loads the configuration for a logic worker
		PropReader prRd = new PropReader();
		try {
			JsonReader jsRd = new JsonReader(prRd.getLocalValue(worker.getJsonPath()));
			JSONObject baseItem = jsRd.getBaseObj(jsRd.getMainObj());

			JSONObject root = (JSONObject) baseItem.get("appConfig");

			String name = (String) root.get("-name");
			String title = (String) root.get("title");
			if (root.containsValue("baseElements")) {
				JSONObject headerList = (JSONObject) root.get("baseElements");
				getScripts((JSONObject) headerList.get("script"));
				getStyles((JSONObject) headerList.get("styles"));
			} // get("baseElements");
			
			JSONArray pages = (JSONArray)((JSONObject) root.get("pages")).get("page");
			Iterator<JSONObject> elements = pages.iterator();
			while (elements.hasNext()) {
				Object temp=elements.next();
				
				System.out.println("page: "+elements.next());
			}
			System.out.println(name);
			System.out.println(title);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getStyles(JSONObject stylesItem) {
		JSONArray root = (JSONArray) stylesItem.get("css");
		getElementList(root);
		return "";
	}

	

	public String getScripts(JSONObject scriptItem) {
		JSONArray root = (JSONArray) scriptItem.get("js");
		getElementList(root);
		return "";
	}

	public String getElementList(JSONArray objArr) {
		Iterator<String> elements = objArr.iterator();
		while (elements.hasNext()) {

		}
		return "";
	}

	public static void main(String args[]) {
		Translator tran = new Translator(e_avaliableClasses.mitaller);

	}
}
