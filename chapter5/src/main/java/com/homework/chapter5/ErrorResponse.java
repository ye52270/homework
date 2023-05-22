package com.homework.chapter5;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ErrorResponse {
  private  String message;
  private  int status;
  private  String code;
  private  LocalDateTime timeStamp;
  private  List<FieldError> errors;

  private ErrorResponse(String message, int status, String code) {
    this.message = message;
    this.status = status;
    this.code = code;
    this.timeStamp = LocalDateTime.now();
    this.errors = new ArrayList<>();
  }

  public ErrorResponse(ErrorCode errorCode, List<FieldError> of) {
    this.message = errorCode.getMessage();
    this.status = errorCode.getStatus();
    this.code = errorCode.getCode();
    this.timeStamp = LocalDateTime.now();
    this.errors = of;
  }

  public static ErrorResponse of(ErrorCode code) {
    return new ErrorResponse(code.getMessage(), code.getStatus(), code.getCode());
  }

  public static ErrorResponse of(Exception e) {
    return new ErrorResponse(e.getMessage(), 500, "C002");
  }

  public static ErrorResponse of(ErrorCode errorCode, BindingResult e) {
    return new ErrorResponse(errorCode, FieldError.of(e));
  }

  @Getter
  @AllArgsConstructor
  public static class FieldError {
    private String field;
    private String value;
    private String reason;

    public static List<FieldError> of(BindingResult bindingResult) {
      return bindingResult.getFieldErrors()
              .stream()
              .map(error -> new FieldError(
                      error.getField(),
                      error.getRejectedValue() == null ? "" : error.getRejectedValue().toString(),
                      error.getDefaultMessage()
              )).collect(Collectors.toList());
    }
  }
}
