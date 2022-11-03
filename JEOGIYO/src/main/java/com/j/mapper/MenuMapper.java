package com.j.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.j.dto.MenuDTO;

@Repository
@Qualifier("MenuMapper")
@Mapper
public interface MenuMapper {
	public List<MenuDTO> selectSeries(String series);
}
