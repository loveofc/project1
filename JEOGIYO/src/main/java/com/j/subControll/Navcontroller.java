package com.j.subControll;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.j.dto.MenuDTO;
import com.j.service.SearchStore;
import com.j.service.SearchSub;
import com.j.service.menuService;

@RestController
@RequestMapping("nav")
@PropertySource(value="classpath:application.properties",encoding="UTF-8")
public class Navcontroller {
	@Autowired
	SearchStore s;

	@Autowired
	SearchSub sub;
	
	@Autowired
	menuService menu;


	@RequestMapping("map")
	public ModelAndView drawSubs(@RequestParam(value = "sub1", required = false) String sub1,
			@RequestParam(value = "sub2", required = false) String sub2,
			@RequestParam(value = "storename", required = false) String storename) {
		ModelAndView mv = new ModelAndView();
		
		String _sub1 = sub1;
		String _sub2 = sub2;
		String option2 = "";
		String strLists = "";
		if (sub1 != null) {
			_sub2 = sub2;
			option2 = sub.selectSub2(_sub2, _sub1);
		}
		if (sub1 != null && sub2 != null) {

			strLists = sub.storeList(sub1, sub2);
			if ( sub1.equals("시/도") && sub2.equals("시/구/군")) {
				String str = sub.findBystorename(storename, sub1, sub2);
				strLists = str;
				mv.addObject("storename", storename);
				
			}
			
			if(storename!=null && !storename.equals("")){
				String str = sub.findBystorename(storename, sub1, sub2);
				strLists = str;
				System.out.println(strLists);
				mv.addObject("storename", storename);
			}			
			mv.addObject("strLists", strLists);
		}
		
	

		String option1 = sub.selectSub1(_sub1);
		mv.addObject("option1", option1);
		mv.addObject("option2", option2);
		mv.setViewName("map/shopslo2");
		return mv;
	}

//	@RequestMapping("map")
//	public ModelAndView index(HttpServletRequest rq, HttpServletResponse resp) throws IOException, ParseException {
//		ModelAndView mv = new ModelAndView();
//		String sido = rq.getParameter("sido");
//		String sido2 = rq.getParameter("sido2");
//		String subList ="";
//		String searchList ="";
//		if(sido!=null && !sido.equals("")) {
//			subList = s.subList(sido,sido2);;
//			mv.addObject("subList",subList);
//		}else {
//			sido = "시-도";
//		}
//		searchList = s.searchList(sido,sido2);
//		mv.addObject("searchList",searchList);		
//		String mainList = s.mainList(sido);
//		mv.addObject("mainList",mainList);
//		mv.setViewName("map/shopslo2");
//		return mv;
//	}

	@RequestMapping("menu")
	public ModelAndView menu(@RequestParam(value = "series", required = false)String series) {
		ModelAndView mv = new ModelAndView();	
		String menuType = menu.menuType();
		System.out.println(series);
		List<MenuDTO> lists = menu.selectSeries(series);
		mv.addObject("lists",lists);
		mv.addObject("menuType",menuType);
		mv.setViewName("menu/menu");
		return mv;
	}
	@RequestMapping("menu/**")
	public ModelAndView selectSeries(@RequestParam(value = "series", required = false)String series) {
		ModelAndView mv = new ModelAndView();	
		System.out.println(series);
		List<MenuDTO> lists = menu.selectSeries(series);
		mv.addObject("lists",lists);
		mv.setViewName("menu/menu");
		return mv;
	}
}
