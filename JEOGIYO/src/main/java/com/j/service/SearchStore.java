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

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser; // JSON객체 파싱
import org.json.simple.parser.ParseException;



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
	
	public String mainList(String sido) throws IOException, ParseException {
		String str ="";
		Reader reader = new FileReader("src/main/resources/static/js/json/storemap.json");
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		JSONArray arr = (JSONArray)jsonObject.get("main");
		str = arr.toString();
		str = str.replace("[","");
		str = str.replaceAll("]", "");
		String[] arrStr = str.split(",");
		String html = "";
		for(int i = 0; i<arrStr.length;i++) {
			if(arrStr[i].contains(sido)) {
				html += "<option selected='selected' class='"+arrStr[i]+"' >"+arrStr[i].replaceAll("\"","")+"</option>";
			}else {
				html += "<option  class="+arrStr[i]+">"+arrStr[i].replaceAll("\"","")+"</option>";
			}
			
		}
		
		return html;
	}
	
	public String subList(String strs,String sido2_) throws IOException, ParseException {
		String sido =strs;
		String sido2 = sido2_;
		String html = "";
		Reader reader = new FileReader("src/main/resources/static/js/json/city.json");
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = (JSONObject) parser.parse(reader);
		Iterator<String> iter = jsonObject.keySet().iterator();
		while(iter.hasNext()) {
			
			if(iter.next().toString().contains(sido)) {
				JSONArray jsonArr = (JSONArray) jsonObject.get(sido);
				for(int i = 0 ; i<jsonArr.size();i++) {
					if(jsonArr.get(i).toString().equals(sido2_)) {
						html += "<option selected='selected' class="+jsonArr.get(i).toString()+">"+jsonArr.get(i).toString().replaceAll("\"","")+"</option>";
					}else {
						html += "<option class="+jsonArr.get(i).toString()+">"+jsonArr.get(i).toString().replaceAll("\"","")+"</option>";
					}
					
				}
			}
		}			
		return html;
	}
	
	public String searchList(String s) throws IOException, ParseException {
		String str ="";
		File dir = new File("src/main/resources/static/js/json/");
		String[] fileNames = dir.list();
		String storeName = s;
		if(storeName == null || storeName.equals("")) {
			storeName = "강남구";
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
					if(iter.next().toString().equals(storeName)) {
						JSONArray jsonArr = (JSONArray) jsonObject.get(storeName);					
							for (int i = 0; i < jsonArr.size(); i++) {							
								JSONObject jsonObj = (JSONObject) jsonArr.get(i);
								str +="<div class=content onclick='s(this)'>"+
								"<h3>매장명 : "+jsonObj.get("매장명")+"</h3>"+
								"<p>전화번호 : "+jsonObj.get("전화번호")+"</p>"+
								"<p>구주소 : "+jsonObj.get("구주소")+
								"<p>신주소 : "+jsonObj.get("신주소")+
								"<p>영업시간 : "+jsonObj.get("영업시간")+"</p></div>";	
						}
					}					
				}//while
			}//else
		}		
		return str;
	}
	
	

}
