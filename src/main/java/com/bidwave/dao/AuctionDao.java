package com.bidwave.dao;

import com.bidwave.dto.AuctionDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AuctionDao {
    @Select("SELECT * FROM auction WHERE status = 'ACTIVE' ORDER BY end_time ASC LIMIT 5")
    List<AuctionDTO> findFeaturedAuctions();
}
