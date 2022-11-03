package com.j.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.j.dto.MenuDTO;
import com.j.mapper.MenuMapper;


@Service
public class menuService {
	
	@Autowired
	@Qualifier("MenuMapper")
	MenuMapper mm;
	
	@Value("#{menu['menu.list']}")
	String menuList;

	public String menuType() {
		String[] temps= menuList.split(",");
		String str ="";
		for(String m : temps) {
			str +="<li><a href=\"/nav/menu?series="+m.trim()+"\">"+m+"</a></li>";
		}
		
		return str;
	}
	
	public List<MenuDTO> selectSeries(String series){
		 List<MenuDTO> lists = new ArrayList<>();
		 String str = series;
		 if(series ==null ||series.equals("전체메뉴")) {
			 str = null;
		 }
		 lists = mm.selectSeries(str);
		 System.out.println(lists);
		return lists;
	}
}
