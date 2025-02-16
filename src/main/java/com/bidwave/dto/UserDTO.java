package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDTO {

  private long userId;
  private String email;
  private String password;
  private String name;
  private String phone;


}
