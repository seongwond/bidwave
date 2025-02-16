package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AuctionDTO {

  private long auctionId;
  private long productId;
  private long startPrice;
  private long currentPrice;
  private java.sql.Timestamp startTime;
  private java.sql.Timestamp endTime;
  private String status;


}
