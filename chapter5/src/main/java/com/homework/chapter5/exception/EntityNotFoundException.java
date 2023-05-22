package com.homework.chapter5.exception;

import com.homework.chapter5.ErrorCode;

public class EntityNotFoundException extends BusinessException{
  public EntityNotFoundException(ErrorCode errorCode) {
    super(errorCode);
  }
}
