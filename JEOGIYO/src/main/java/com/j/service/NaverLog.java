package com.j.service;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

@Service
public class NaverLog {

	public String getNaverAcessCode(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String clientId = "fy66_ac237ks_6ar2aWU";// 애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8080/sign/naver", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		return apiURL;
//		HttpSession session = req.getSession();
//		session.setAttribute("state", state);
//		resp.sendRedirect(apiURL);
	}
	
	public String getNaverAcessToken(String _code, String _state) throws UnsupportedEncodingException {
		String clientId = "fy66_ac237ks_6ar2aWU";//애플리케이션 클라이언트 아이디값";
	    String clientSecret = "yvIQMpVxQ2";//애플리케이션 클라이언트 시크릿값";
	    String code = _code;
	    String state = _state;
	    String redirectURI = URLEncoder.encode("http://localhost:8080/sign/naver", "UTF-8");
	    String apiURL;
	    StringBuffer res = new StringBuffer();
	    apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	    apiURL += "client_id=" + clientId;
	    apiURL += "&client_secret=" + clientSecret;
	    apiURL += "&redirect_uri=" + redirectURI;
	    apiURL += "&code=" + code;
	    apiURL += "&state=" + state;
	    String access_token = "";
	    String refresh_token = "";
	    System.out.println("apiURL="+apiURL);
	    try {
	      URL url = new URL(apiURL);
	      HttpURLConnection con = (HttpURLConnection)url.openConnection();
	      con.setRequestMethod("GET");
	      int responseCode = con.getResponseCode();
	      BufferedReader br;
	      System.out.print("responseCode="+responseCode);
	      if(responseCode==200) { // 정상 호출
	        br = new BufferedReader(new InputStreamReader(con.getInputStream()));
	      } else {  // 에러 발생
	        br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
	      }
	      String inputLine;
	      
	      while ((inputLine = br.readLine()) != null) {
	        res.append(inputLine);
	      }
	      br.close();
	      if(responseCode==200) {
	        System.out.println(res.toString());
	      }
	    } catch (Exception e) {
	      System.out.println(e);
	    }
	    JsonElement element = JsonParser.parseString(res.toString()).getAsJsonObject();
	    access_token = element.getAsJsonObject().get("access_token").getAsString();
	    refresh_token = element.getAsJsonObject().get("refresh_token").getAsString();
	    return access_token;
	}
	
	public String getNaveinfo(String accessToken) {
		 String token = accessToken; // 네이버 로그인 접근 토큰;
	     String header = "Bearer " + token; // Bearer 다음에 공백 추가
	     String apiURL = "https://openapi.naver.com/v1/nid/me";

	     Map<String, String> requestHeaders = new HashMap<>();
	     requestHeaders.put("Authorization", header);
	     String responseBody = get(apiURL,requestHeaders);


	     System.out.println(responseBody);
	     return responseBody;
	   
	}
	
	 private static String get(String apiUrl, Map<String, String> requestHeaders){
	        HttpURLConnection con = connect(apiUrl);
	        try {
	            con.setRequestMethod("GET");
	            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
	                con.setRequestProperty(header.getKey(), header.getValue());
	            }


	            int responseCode = con.getResponseCode();
	            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
	                return readBody(con.getInputStream());
	            } else { // 에러 발생
	                return readBody(con.getErrorStream());
	            }
	        } catch (IOException e) {
	            throw new RuntimeException("API 요청과 응답 실패", e);
	        } finally {
	            con.disconnect();
	        }
	    }


	    private static HttpURLConnection connect(String apiUrl){
	        try {
	            URL url = new URL(apiUrl);
	            return (HttpURLConnection)url.openConnection();
	        } catch (MalformedURLException e) {
	            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
	        } catch (IOException e) {
	            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
	        }
	    }


	    private static String readBody(InputStream body){
	        InputStreamReader streamReader = new InputStreamReader(body);


	        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
	            StringBuilder responseBody = new StringBuilder();


	            String line;
	            while ((line = lineReader.readLine()) != null) {
	                responseBody.append(line);
	            }


	            return responseBody.toString();
	        } catch (IOException e) {
	            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
	        }
	    }
}
