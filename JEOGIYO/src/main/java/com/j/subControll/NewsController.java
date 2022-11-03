package com.j.subControll;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.j.service.NewsService;

@RestController
public class NewsController {
	
	@Autowired
	NewsService news;
	
	@GetMapping("/news")
	public ModelAndView getNews(@RequestParam(value = "findStr", required = false) String findStr,@RequestParam(value = "display", required = false) String display) {
		String responseBody = news.getNews(findStr,display);
		String str = news.makeHtml(responseBody);
		ModelAndView mv = new ModelAndView();		
		mv.addObject("str",str);
		mv.setViewName("news/news");
		return mv;
	}
	
}
