package com.j.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.j.service.SearchStore;
import com.j.service.SearchSub;

@RestController
@RequestMapping("/")
public class FrontController {
	
	@Value("#{menu['resource.path']}")
	private String resourcePath;
	
	@Value("#{menu['upload.path']}")
	private String imgPath;
//	@Autowired
//	SearchStore s;
	
	//매장찾기 서비스
	@Autowired
	SearchSub sub;
	
	//메인리턴
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest rq) {
		ModelAndView mv = new ModelAndView();
		String storename = "신림";
		String str = sub.findBystorename(storename,null,null);
		mv.addObject("resourcePath",resourcePath);
		mv.addObject("imgPath",imgPath);
		mv.addObject("str",str);
		mv.setViewName("index");
		return mv;
	}
	
	//홈페이지 매장명 찾기
	@RequestMapping("findstore")
	public ModelAndView findstore(@RequestParam(value="sub1",required=false) String sub1, @RequestParam(value="sub2",required=false) String sub2,@RequestParam(value="storename",required=false) String storename) {
		ModelAndView mv = new ModelAndView();
		if(storename ==null || storename.equals("")) {
			storename="강남역";
		}
		String str = sub.findBystorename(storename,null,null);
		
		mv.addObject("str",str);
		mv.setViewName("index");	
		return mv;
	}
	
	
	
	
	
	
	
	
	/*
	 * 이전 '마리아디비' 이용전 파일에 저장된 매장정보 ajax로 읽어와 매장찾기 버전
	 * @RequestMapping("/index") public ModelAndView index2(HttpServletRequest rq)
	 * throws IOException, ParseException { ModelAndView mv = new ModelAndView();
	 * String storeName=rq.getParameter("storeName");
	 * if(rq.getParameter("storeName")==null) { storeName ="강남"; } List<Map<String,
	 * String>> lists = s.search(storeName); mv.addObject("lists",lists);
	 * mv.setViewName("index"); return mv; }
	 */
	


}
