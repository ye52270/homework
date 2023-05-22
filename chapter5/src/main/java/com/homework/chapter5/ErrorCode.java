package com.homework.chapter5;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

  INVALID_INPUT_VALUE(400, "C001", "Invalid Input Value"),
  INTERNAL_SERVER_ERROR(500, "C002", "Internal Server Error");

  private final int status;
  private final String code; // HTTP Status Code
  private final String message;

}
// 컨트롤러의 중요한 책임 중 하나는 요청에 대한 값 검증을 하고, 이상이 없을 경우 서비스 레이어를 호출해야 한다.
// 컨트롤러의 중요한 책임 중 하나는 요청에 대한 값 검증이다.
// 스프링은 Bean Validator 검증을 쉽고 일관성 있게 처리할 수 있게 도와주며 모든 예외는 @ControllerAdvice 로 선언된 객채에서 핸들링 된다