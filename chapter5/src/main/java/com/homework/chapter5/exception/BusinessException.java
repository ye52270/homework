package com.homework.chapter5.exception;

import com.homework.chapter5.ErrorCode;
import lombok.Getter;


public class BusinessException extends RuntimeException {
  // Errorcode 는 final 로 선언(필수값)
  private final ErrorCode errorCode;

  public BusinessException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
  }
}
