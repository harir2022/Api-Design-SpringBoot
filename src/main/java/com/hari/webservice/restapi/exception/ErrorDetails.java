package com.hari.webservice.restapi.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
     String message ;
     String detail;
     LocalDateTime timestamp;
     long id ;
     
     public long getId() {
		return id;
	}
     public void setId(long id) {
		this.id = id;
	}
     public ErrorDetails(String message, String detail, LocalDateTime timestamp) {
          this.message = message;
          this.detail = detail;
          this.timestamp = timestamp;
     }
     public String getMessage() {
          return message;
     }
     public void setMessage(String message) {
          this.message = message;
     }
     public String getDetail() {
          return detail;
     }
     public void setDetail(String detail) {
          this.detail = detail;
     }
     public LocalDateTime getTimestamp() {
          return timestamp;
     }
     public void setTimestamp(LocalDateTime timestamp) {
          this.timestamp = timestamp;
     }
     
}
