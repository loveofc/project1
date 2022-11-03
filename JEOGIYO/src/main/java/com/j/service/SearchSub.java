package com.j.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.j.dto.SearchSubDTO;
import com.j.dto.StoreDTO;
import com.j.mapper.SearchSubMapper;

@Service
public class SearchSub {

	//시,도,구,군 지역 리스트 찾기 mapper
	@Autowired
	@Qualifier("SearchSubmapper")
	SearchSubMapper sub;

	//시,도 단위 선택지 출력
	public String selectSub1(String sub1) {
		List<SearchSubDTO> lists = new ArrayList<>();
		String str = "";
		lists = sub.selectSub1();
		for (SearchSubDTO sub : lists) {
			if (sub.getSub1().equals(sub1)) {
				str += "<option selected='selected'>" + sub.getSub1() + "</option>";
			} else {
				str += "<option>" + sub.getSub1() + "</option>";
			}

		}

		return str;
	}
	
	//시,구,군 단위 선택지 출력
	public String selectSub2(String sub2, String sub1) {
		List<SearchSubDTO> lists = new ArrayList<>();
		lists = sub.selectSub2(sub1);
		String str = "";
		for (SearchSubDTO sub : lists) {
			if (sub.getSub2().equals(sub2)) {
				str += "<option selected='selected'>" + sub.getSub2() + "</option>";
			} else {
				str += "<option>" + sub.getSub2() + "</option>";
			}

		}
		return str;
	}

	//매장이름으로 정보 검색
	public String findBystorename(String storename, String sub1, String sub2) {
		String str = "";
		String storename_="";
		if(storename!=null) {
			storename_=storename;
		}
		List<StoreDTO> lists = new ArrayList<>();		
		lists = sub.findBystorename(storename_);
		System.out.println(lists.size());
		//lists 배열이 0일때, 매장이없다고 알림.
		if(lists.size()==0) {
			str ="없는 매장이름입니다.";
			return str;
		}
		//지역1, 지역2가 정보가 담겨있을때 그 지역의 매장만 찾음
		if (sub1 != null && !sub1.equals("") && sub2 != null && !sub2.equals("") ) {
			for (StoreDTO s : lists) {
				//지역1과 지역2가 같을때 매장이름 출력, 지역1, 지역2 둘중 하나가 그지역에 없으면 현재 지역에 매장이름 없다고 출력
				if (s.getSub1().equals(sub1) && s.getSub2().equals(sub2)) {

					str += "<div class=content onclick='s(this)'>" + "<h3>매장명 : " + s.getStorename() + "</h3>"
							+ "<p>전화번호 : " + s.getPhone() + "</p>" + "<p>구주소 : " + s.getOldaddr() + "</p>" + "<p>신주소 : "
							+ s.getNewaddr() + "</p>" + "<p>영업시간 : " + s.getRuntime() + "</p></div>";
				}else {
					str ="현재 지역에 없는 매장이름입니다.";
				}
			}	
		//지역 상관없이 모든 매장 출력, 처음 매장찾기 페이지 들어갔을때만 작동
		}else if(sub1 ==null && sub2 ==null) {
			int i = 0;
			for (StoreDTO s : lists) {					
				str += "<div class=content onclick='s(this)'>" + "<h3>매장명 : " + s.getStorename() + "</h3>"
						+ "<p>전화번호 : " + s.getPhone() + "</p>" + "<p>구주소 : " + s.getOldaddr() + "</p>" + "<p>신주소 : "
						+ s.getNewaddr() + "</p>" + "<p>영업시간 : " + s.getRuntime() + "</p></div>";	
				i++;
				//우선 5개매장만 출력
				if(i>10) {
					str+="<div class=content style=\"background:red;\">자세한 사항은 지역을 선택해주세요.</div>";
					break;
				}
			}
		}
		//지역1, 지역2가 null이 아니면서 기본 시/도/군으로 선택시 매장명을 검색할때
		if((sub1!=null&&sub2!=null) && ( sub1.equals("시/도") && sub2.equals("시/구/군"))) {
			str="";
			int i = 0;
			for (StoreDTO s : lists) {	
				
				str+= "<div class=content onclick='s(this)'>" + "<h3>매장명 : " + s.getStorename() + "</h3>"
						+ "<p>전화번호 : " + s.getPhone() + "</p>" + "<p>구주소 : " + s.getOldaddr() + "</p>" + "<p>신주소 : "
						+ s.getNewaddr() + "</p>" + "<p>영업시간 : " + s.getRuntime() + "</p></div>";	
				i++;
				//우선 5개매장만 출력
				if(i>10) {
					str+="<div class=content style=\"background:red;\">자세한 사항은 지역을 선택해주세요.</div>";
					break;
				}
			}
		}
		return str;
	}

	public String storeList(String sub1, String sub2) {

		SearchSubDTO subDto = new SearchSubDTO(sub1, sub2);
		String str = "";
		List<StoreDTO> lists = new ArrayList<>();
		lists = sub.storeList(subDto);
		for (StoreDTO s : lists) {
			str += "<div class=content onclick='s(this)'>" + "<h3>매장명 : " + s.getStorename() + "</h3>" + "<p>전화번호 : "
					+ s.getPhone() + "</p>" + "<p>구주소 : " + s.getOldaddr() + "</p>" + "<p>신주소 : " + s.getNewaddr()
					+ "</p>" + "<p>영업시간 : " + s.getRuntime() + "</p></div>";
		}
		return str;
	}

}
