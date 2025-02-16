package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CategoryDTO {

  private long categoryId;
  private String categoryName;
  private long superCategoryId;


}
