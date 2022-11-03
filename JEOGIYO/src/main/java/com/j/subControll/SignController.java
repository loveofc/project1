package com.j.subControll;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.j.service.NaverLog;
import com.j.service.kakaoLog;

@RestController
@RequestMapping("sign")
public class SignController {
	
	@Autowired
	kakaoLog kakao;
	@Autowired
	NaverLog naver;
	
	
	@GetMapping("/login")
	public void login(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String select = req.getParameter("selectSite");
		if(select.equals("kakao")) {
			resp.sendRedirect("https://kauth.kakao.com/oauth/authorize?client_id=bea37e417de549bae1e0bbe43597eadb&redirect_uri=http://localhost:8080/sign/kakao&response_type=code");	
		}else if(select.equals("naver")) {
			 resp.sendRedirect(naver.getNaverAcessCode(req, resp));
		}
		
	   
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest req,HttpServletResponse resp) throws IOException {
		String select = req.getParameter("selectSite");
		if(select.equals("kakao")) {
			resp.sendRedirect("https://kauth.kakao.com/oauth/authorize?client_id=bea37e417de549bae1e0bbe43597eadb&redirect_uri=http://localhost:8080/sign/kakao&response_type=code");	
		}else if(select.equals("naver")) {
			 resp.sendRedirect("https://nid.naver.com/oauth2.0/token?grant_type=delete&client_id=jyvqXeaVOVmV\r\n"
			 		+ "&client_secret=527300A0_COq1_XV33cf\r\n"
			 		+ "&access_token=c8ceMEJisO4Se7uGCEYKK1p52L93bHXLnaoETis9YzjfnorlQwEisqemfpKHUq2gY\r\n"
			 		+ "&service_provider=NAVER");
		}
		
	   
	}
	
	@GetMapping("/kakao")
	public void kakaoLogin(@RequestParam(value = "code", required = false) String code) {
		System.out.println("code"+code);	

		String token = kakao.getKakaoAccessToken(code);
		String email = kakao.getEmail(token);	
		
	    
		
	}
	@GetMapping("/naver")
	public void naverLogin(@RequestParam(value = "code", required = false) String code, @RequestParam(value = "token", required = false) String token) throws IOException {
		System.out.println("code"+code);	

		String naverToken = naver.getNaverAcessToken(code, token);
		String memberInfo = naver.getNaveinfo(naverToken);
	    
	}
}
