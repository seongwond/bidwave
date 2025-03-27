package com.bidwave.dao;

import com.bidwave.dto.CategoryDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CategoryDao {

    @Select("SELECT * FROM category")
    List<CategoryDTO> fetchAllCategories(); // 모든 카테고리 조회
}
