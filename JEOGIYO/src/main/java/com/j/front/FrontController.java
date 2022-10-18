package com.j.front;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.j.service.SearchStore;

@RestController
@RequestMapping("/")
public class FrontController {
	@Autowired
	SearchStore s;
	
	@RequestMapping("/")
	public ModelAndView index(HttpServletRequest rq) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView index2(HttpServletRequest rq)  throws IOException, ParseException {
		ModelAndView mv = new ModelAndView();
		String storeName=rq.getParameter("storeName");
		if(rq.getParameter("storeName")==null) {
			storeName ="강남";
		}
		List<Map<String, String>> lists = s.search(storeName);
		mv.addObject("lists",lists);
		mv.setViewName("index");
		return mv;		
	}	

}
