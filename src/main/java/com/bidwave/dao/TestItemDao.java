package com.bidwave.dao;

import com.bidwave.dto.TestItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface TestItemDao {
    @Select("SELECT * FROM test_items")
    List<TestItem> getAllItems();
}
