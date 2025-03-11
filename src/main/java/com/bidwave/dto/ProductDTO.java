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
  private String description;
  private String productImage;
  private int price;
  private java.sql.Timestamp endTime;


}
