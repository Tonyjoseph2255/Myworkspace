package com.example.itemjson.service;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

@Service
public class ItemjsonApplicationService {
	JSONParser parser = new JSONParser();
	JSONObject jsonObject = new JSONObject();
	JSONArray entityArray = new JSONArray();
	JSONObject jsonprop = new JSONObject();
	JSONObject modify = new JSONObject();

	public String getAllData() {

		try {
			File rep = new File("C:\\folder");
			File[] list = rep.listFiles();
			for (File singleFie : list) {
				FileReader reader = new FileReader(singleFie);
				Object obj = parser.parse(reader);

				for (int i = 0; i <= 4; i++) {
					jsonObject = (JSONObject) obj;
					entityArray = (JSONArray) jsonObject.get("entities");
					for (Object prop : entityArray) {
						jsonprop = (JSONObject) prop;
						modify = (JSONObject) jsonprop.get("properties");
						modify.put("modifiedDate", dateMapper().get(i));// modified the data
						JSONObject dataObject = (JSONObject) jsonprop.get("data");
						JSONObject attrObject = (JSONObject) dataObject.get("attributes");
						JSONObject itemObject = (JSONObject) attrObject.get("itemnumber");
						JSONArray valueArray = (JSONArray) itemObject.get("values");
						//valueArray.toJSONString();
						
						System.out.println(valueArray);
						JSONObject signinObject = (JSONObject) attrObject.get("signing1desc");
						JSONArray signinArray = (JSONArray) signinObject.get("values");
						//signinArray.set(0, itemObject);
						for (Object value : signinArray) {

							JSONObject var = (JSONObject) value;
							//List<JSONObject> varList = new ArrayList<>();
							//varList.add(var);
							// JSONArray arr=(JSONArray) var.get("value");
							// int count=1;
							 //JSONObject valueobject = (JSONObject) value;
							// //JSONObject type=(JSONObject) ((ArrayList) value).get(1);
							//varList.equals(itemObject);
							//varList.add(1,itemObject);
							//JSONArray varArray=(JSONArray) var.get("value");
							var.remove("value");
						   var.put("value", valueArray.get(0));
							//System.out.println(var);
							// count++;
						}

						// System.out.println(signinArray);
						// JSONArray valueArray=(JSONArray) itemObject.get("values");
						// System.out.println(valueArray);

						// System.out.println(modify);

					}
				}

				// System.out.println(jsonObject);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return null;
	}

	private HashMap<Integer, String> dateMapper() {
		HashMap<Integer, String> timeMap = new HashMap<Integer, String>();
		timeMap.put(0, "2021-08-10t08:24:02.589-0500");
		timeMap.put(1, "2021-08-10t08:25:02.589-0500");
		timeMap.put(2, "2021-08-10t08:24:03.589-0500");
		timeMap.put(3, "2021-08-10t08:25:02.589-0500");
		timeMap.put(4, "2021-08-10t08:24:04.589-0500");

		return timeMap;

	}

}
