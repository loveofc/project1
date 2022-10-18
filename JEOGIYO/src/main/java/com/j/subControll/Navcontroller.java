package com.j.subControll;




import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



@RestController
@RequestMapping("nav")
public class Navcontroller {

	
	@RequestMapping("map")
	public ModelAndView index(HttpServletRequest rq, HttpServletResponse resp) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("map/shopslo");

		return mv;
	}
	
	
	@RequestMapping("menu")
	public ModelAndView menu(HttpServletRequest rq, HttpServletResponse resp){
		ModelAndView mv = new ModelAndView();	
		
		mv.setViewName("menu/menu");
		return mv;
	}
}
