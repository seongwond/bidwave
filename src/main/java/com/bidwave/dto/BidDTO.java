package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BidDTO {

  private long bidId;
  private long userId;
  private long auctionId;
  private long amount;
  private java.sql.Timestamp bidTime;


}
