package com.j.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Service
public class NewsService {
	
	@Value("#{naver['naver.id']}")
	String clientId ;// 애플리케이션 클라이언트 아이디
	
	@Value("#{naver['naver.pwd']}")
	String clientSecret;// 애플리케이션 클라이언트 시크릿
	
	//String json 변형 및 html 구조 만들기
	public String makeHtml(String responseBody) {
		String result ="";
		JsonObject JsonO = JsonParser.parseString(responseBody).getAsJsonObject();
		JsonArray d =  JsonO.get("items").getAsJsonArray();
		for(JsonElement e : d) {
			result +="<div class=\"itemWrap\">"
					+"<div><h3><a href="
					+e.getAsJsonObject().get("originallink").getAsString()+" target=\"_blank\">"
					+e.getAsJsonObject().get("title").getAsString()+"</a></h3></div>"
					+"<div>"+e.getAsJsonObject().get("description").getAsString()+"</a></div>"
					+"</div>";
		}
		return result ;
	}
	
	
	//네이버 뉴스 api 가져오기
	public String getNews(String _findStr, String _display) {
		String findStr=_findStr;
		String display =_display;
		if(findStr ==null || findStr.equals("")) {
			findStr="교촌치킨";
		}
		if(display ==null || display.equals("")) {
			display="12";
		}
		
		String text = null;
		try {
			text = URLEncoder.encode(findStr, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException("검색어 인코딩 실패", e);
		}

		String apiURL = "https://openapi.naver.com/v1/search/news.json?query=" + text+"&display="+display; // JSON 결과
		// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
		// // XML 결과

		Map<String, String> requestHeaders = new HashMap<>();
		requestHeaders.put("X-Naver-Client-Id", clientId);
		requestHeaders.put("X-Naver-Client-Secret", clientSecret);
		String responseBody = get(apiURL, requestHeaders);

		return responseBody;
	}

	private static String get(String apiUrl, Map<String, String> requestHeaders) {
		HttpURLConnection con = connect(apiUrl);
		try {
			con.setRequestMethod("GET");
			for (Map.Entry<String, String> header : requestHeaders.entrySet()) {
				con.setRequestProperty(header.getKey(), header.getValue());
			}

			int responseCode = con.getResponseCode();
			if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
				return readBody(con.getInputStream());
			} else { // 오류 발생
				return readBody(con.getErrorStream());
			}
		} catch (IOException e) {
			throw new RuntimeException("API 요청과 응답 실패", e);
		} finally {
			con.disconnect();
		}
	}

	private static HttpURLConnection connect(String apiUrl) {
		try {
			URL url = new URL(apiUrl);
			return (HttpURLConnection) url.openConnection();
		} catch (MalformedURLException e) {
			throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
		} catch (IOException e) {
			throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
		}
	}

	private static String readBody(InputStream body) {
		InputStreamReader streamReader = new InputStreamReader(body);

		try (BufferedReader lineReader = new BufferedReader(streamReader)) {
			StringBuilder responseBody = new StringBuilder();

			String line;
			while ((line = lineReader.readLine()) != null) {
				responseBody.append(line);
			}

			return responseBody.toString();
		} catch (IOException e) {
			throw new RuntimeException("API 응답을 읽는 데 실패했습니다.", e);
		}
	}
	//네이버 api 가져오기 끝
}
