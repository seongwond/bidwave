package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReviewDTO {

  private long reviewId;
  private long reviewViewer;
  private long reviewEd;
  private long auctionId;
  private String content;
  private long rating;
  private java.sql.Timestamp createdAt;
  private java.sql.Timestamp updatedAt;


}
