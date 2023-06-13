package com.example.itemjson.service;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import com.example.itemjson.entity.ItemEntity;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

@Service
public class ItemService {

	public static String getAllData() {
		// TODO Auto-generated method stub

		JSONParser parser = new JSONParser();
		JSONObject jsonObject = new JSONObject();
		JSONArray entityArray = new JSONArray();
		JSONObject jsonprop = new JSONObject();
		JSONObject modify = new JSONObject();
		String moEntity = "";
		List<Object> uulist = new ArrayList<>();
		String idString1 = "";
		JSONObject idObject = new JSONObject();
		System.out.println(idString1);
		List<ItemEntity> entityList = new ArrayList<>();
		ItemEntity var1 = new ItemEntity();
		// int idArray=(Integer) null;
		List<Object> itemList = new ArrayList<>();
		List<Object> signinList = new ArrayList<>();
		JSONObject var = new JSONObject();
		List<String> modiList = new ArrayList<>();
		

		// idString1=idObject.toString();

		// var1.setId(idString1.);;
		// var1.setItemnumber(moEntity);
		// entityList.add(var1);
		// System.out.println(var1);
		
		// mapper.configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true);

		


		// writer.writeValues(csvOutputFile).writeAll();

		try {
			File rep = new File("C:\\folder");
			File[] list = rep.listFiles();
			for (File singleFie : list) {
				FileReader reader = new FileReader(singleFie);
				Object obj = parser.parse(reader);
				Object val = null;
				// System.out.println(obj.getClass());

				for (int i = 0; i <= 4; i++) {
					jsonObject = (JSONObject) obj;
					entityArray = (JSONArray) jsonObject.get("entities");
					for (Object prop : entityArray) {
						jsonprop = (JSONObject) prop;
						if ("item".equals(jsonprop.get("type"))) {
							UUID uuid = UUID.randomUUID();
							// System.out.println("uuid generate for id value" + uuid);

							jsonprop.put("id", uuid.toString());
							// idString1= (String) jsonprop.get("id");
							// System.out.println(idString1);

							// idArray=idString1.indexOf(0);
							// System.out.println(idArray);
							moEntity = (String) modify.put("modifiedDate", dateMapper().get(i));// modified the data
							// System.out.println("modified data after mapping"+dateMapper().get(i));
							// System.out.println(moEntity);
							JSONObject dataObject = (JSONObject) jsonprop.get("data");
							JSONObject attrObject = (JSONObject) dataObject.get("attributes");
							JSONObject itemObject = (JSONObject) attrObject.get("itemnumber");
							JSONArray valueArray = (JSONArray) itemObject.get("values");
							for (Object value : valueArray) {
								JSONObject valueObject = (JSONObject) value;
								val = valueObject.get("value");
								// System.out.println(val);
							}

							JSONObject signinObject = (JSONObject) attrObject.get("signing1desc");
							JSONArray signinArray = (JSONArray) signinObject.get("values");
							for (Object valueSign : signinArray) {

								var = (JSONObject) valueSign;
								String valueMap = "<" + val.toString() + ">" + "_" + i;
								var.put("value", valueMap);
								// System.out.println("signin value after mapping "+valueMap);

							}

						}
						uulist.add(jsonprop.get("id"));// random uuid
						itemList.add(val);//item number
						signinList.add(var);//signin value after modification
						modiList.add(dateMapper().get(i));//modified date
					}
				}
		//				System.out.println(uulist);
		//				System.out.println(itemList);
		//				System.out.println(signinList);
		//				System.out.println(modiList);
				entityList= (List<ItemEntity>) Stream.of(uulist, itemList, signinList,modiList)
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList()); 
				//System.out.println(entityList);
					var1.setId(uulist);
					var1.setItemnumber(itemList);
					var1.setSigning1desc(signinList);
					var1.setModifiedDate(modiList);
					//System.out.println(var1);
					CsvMapper mapper = new CsvMapper();
					//File csvOutputFile = new File("C:/Users/212018/Desktop/KT-session/modified.csv");
					 
			        FileWriter fileWriter = new FileWriter("C:/Users/212018/Desktop/KT-session/modified.csv");
			        fileWriter.write(var1.toString());
			        fileWriter.close();
				//	fileWriter = new FileWriter(csvOutputFile);
					
					
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;

	}

	private static HashMap<Integer, String> dateMapper() {
		HashMap<Integer, String> timeMap = new HashMap<Integer, String>();
		timeMap.put(0, "2021-08-10t08:24:02.589-0500");
		timeMap.put(1, "2021-08-10t08:25:02.589-0500");
		timeMap.put(2, "2021-08-10t08:24:03.589-0500");
		timeMap.put(3, "2021-08-10t08:25:02.589-0500");
		timeMap.put(4, "2021-08-10t08:24:04.589-0500");

		return timeMap;

	}
}
