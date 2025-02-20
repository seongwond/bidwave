package com.bidwave.service;

import com.bidwave.dto.AuctionDTO;
import com.bidwave.dao.AuctionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeService {
    private final AuctionDao auctionDao;

    @Autowired
    public HomeService(AuctionDao auctionDao) {
        this.auctionDao = auctionDao;
    }

    public List<AuctionDTO> getFeaturedAuctions() {
        return auctionDao.findFeaturedAuctions();
    }
}
