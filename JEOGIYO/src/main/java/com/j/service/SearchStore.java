package com.j.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; // JSON객체 파싱
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;


@Service
public class SearchStore {
	
	public SearchStore() {}

	public List<Map<String, String>> search(String s) throws IOException, ParseException {
		List<Map<String, String>> lists = new ArrayList<>();
		
		File dir = new File("src/main/resources/static/js/json/");
		String[] fileNames = dir.list();
		String storeName = s;
		if(storeName == null || storeName.equals("")) {
			storeName = "강남";
		}
		JSONParser parser = new JSONParser();
		for (String f : fileNames) {
			// JSON 파일 읽기
			if (f.equals("storemap.json") || f.equals("city.json")) {
				continue;
			} else {
				Reader reader = new FileReader("src/main/resources/static/js/json/" + f);
				JSONObject jsonObject = (JSONObject) parser.parse(reader);
				Iterator<String> iter = jsonObject.keySet().iterator();
				while (iter.hasNext()) {
					JSONArray jsonArr = (JSONArray) jsonObject.get(iter.next().toString());
					if (jsonArr.size() > 0) {
						
						for (int i = 0; i < jsonArr.size(); i++) {
							
							JSONObject jsonObj = (JSONObject) jsonArr.get(i);
							
							if (jsonObj.get("매장명").toString().matches(".*"+storeName+".*")){
								
								Map<String, String> map = new HashMap<>();
								map.put("storeName", jsonObj.get("매장명").toString());
								map.put("addr", jsonObj.get("신주소").toString());
								map.put("phone", jsonObj.get("전화번호").toString());
								map.put("time", jsonObj.get("영업시간").toString());
								lists.add(map);
							
							}						
							
						}						
					}
				
				}//while
			}//else
		}
		
		return lists;
	}
/*
	public static void main(String[] args) throws IOException, ParseException {

		File dir = new File("src/main/resources/static/js/json/");
		String[] fileNames = dir.list();
		String storeName = "명지신도시";

		JSONParser parser = new JSONParser();
		for (String f : fileNames) {
			// JSON 파일 읽기
			if (f.equals("storemap.json") || f.equals("city.json")) {
				continue;
			} else {
				Reader reader = new FileReader("src/main/resources/static/js/json/" + f);
				JSONObject jsonObject = (JSONObject) parser.parse(reader);
				Iterator<String> iter = jsonObject.keySet().iterator();
				while (iter.hasNext()) {
					JSONArray jsonArr = (JSONArray) jsonObject.get(iter.next().toString());
					if (jsonArr.size() > 0) {
						for (int i = 0; i < jsonArr.size(); i++) {
							JSONObject jsonObj = (JSONObject) jsonArr.get(i);
							if (jsonObj.get("매장명").toString().equals(storeName)) {
								System.out.println((String) jsonObj.get("매장명"));
								System.out.println((String) jsonObj.get("전화번호"));
								System.out.println((String) jsonObj.get("신주소"));
								System.out.println((String) jsonObj.get("영업시간"));
								return;
							}
						}
					}
				}//while
			}//else

		}
	}
	*/
}
