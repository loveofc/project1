package com.j.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.j.dto.SearchSubDTO;
import com.j.dto.StoreDTO;

@Repository
@Qualifier("SearchSubmapper")
@Mapper
public interface SearchSubMapper {
	public List<SearchSubDTO> selectSub1();
	public List<SearchSubDTO> selectSub2(String sub1);
	public List<StoreDTO> findBystorename(String storename);
	public List<StoreDTO> storeList(SearchSubDTO dto);
}
