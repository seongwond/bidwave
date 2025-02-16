package com.bidwave.dto;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NotificationDTO {

  private long notificationId;
  private long userId;
  private String content;
  private long isRead;
  private java.sql.Timestamp createdAt;


}
