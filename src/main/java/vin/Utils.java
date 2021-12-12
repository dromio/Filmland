package vin;

import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utils {

	public static String JSONObject(HashMap<String, String> map) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(map);
	}

}
