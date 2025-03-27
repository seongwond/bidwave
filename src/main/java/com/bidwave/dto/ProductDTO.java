package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductDTO {

  private long productId;
  private long userId;
  private long categoryId;
  private String productName;
  private String priceStr; // 문자열로 받은 가격 (예: "1,000")
  private String endTimeStr; // 문자열로 받은 종료 시간 (예: "2025-03-13T17:56")
  private String description;
  private int price;
  private String productImage;
  private java.sql.Timestamp endTime;


}
