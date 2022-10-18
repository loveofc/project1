package com.j.subControll;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.j.service.SearchStore;



@RestController
@RequestMapping("nav")
public class Navcontroller {
	@Autowired
	SearchStore s;
	
	@RequestMapping("map")
	public ModelAndView index(HttpServletRequest rq, HttpServletResponse resp) throws IOException, ParseException {
		ModelAndView mv = new ModelAndView();
		String sido = rq.getParameter("sido");
		String sido2 = rq.getParameter("sido2");
		String subList ="";
		String searchList ="";
		if(sido!=null && !sido.equals("")) {
			subList = s.subList(sido,sido2);;
			mv.addObject("subList",subList);
		}else {
			sido = "시-도";
		}
		searchList = s.searchList(sido2);
		mv.addObject("searchList",searchList);		
		String mainList = s.mainList(sido);
		mv.addObject("mainList",mainList);
		mv.setViewName("map/shopslo2");
		return mv;
	}
	
	
	@RequestMapping("menu")
	public ModelAndView menu(HttpServletRequest rq, HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();	
		
		mv.setViewName("menu/menu");
		return mv;
	}
}
