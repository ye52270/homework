package com.homework.chapter5;

import com.homework.chapter5.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

  //  Business 요구사항에 맞지 않을 때 발생하는 예외를 핸들링한다
  @ExceptionHandler(BusinessException.class)
  protected ResponseEntity<ErrorResponse> handlerBusinessException(
          BusinessException e) {
    log.error("BusinessException ------- ", e);
    final ErrorCode errorCode = e.getErrorCode();
    final ErrorResponse response = ErrorResponse.of(errorCode);

    return new ResponseEntity<>(response,
            HttpStatus.valueOf(errorCode.getStatus()));
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<ErrorResponse> handlerMethodArgumentNotValidException(
          MethodArgumentNotValidException e
  ){
    final ErrorCode errorCode = ErrorCode.INVALID_INPUT_VALUE;
    final ErrorResponse response = ErrorResponse.of(errorCode, e.getBindingResult());

    return new ResponseEntity<>(response,HttpStatus.valueOf(errorCode.getStatus()));
  }



  /**
   * 모든 예외를 잡을 수 있는 핸들러
   //   */
//  @ExceptionHandler(Exception.class)
//  protected ResponseEntity<ErrorResponse> handlerException(Exception e) {
//    log.error("handlerException --- INTERNAL_SERVER_ERROR", e);
//    final ErrorResponse response = ErrorResponse.of(ErrorCode.INTERNAL_SERVER_ERROR);
//
//    return new ResponseEntity<>(response,
//            HttpStatus.valueOf( ErrorCode.INTERNAL_SERVER_ERROR.getStatus()));
//  }
//
//  @ExceptionHandler({IllegalArgumentException.class, IllegalStateException.class})
//  protected ResponseEntity<ErrorResponse> handlerIllegalArgumentExceptionException(Exception e) {
//    log.error("handlerException --- INVALID_INPUT_VALUE", e);
//    final ErrorResponse response = ErrorResponse.of(e);
//
//    return new ResponseEntity<>(response,
//            HttpStatus.valueOf( ErrorCode.INVALID_INPUT_VALUE.getStatus()));
//  }
}
