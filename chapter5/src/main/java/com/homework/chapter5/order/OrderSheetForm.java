package com.homework.chapter5.order;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = OrderSheetFormValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface OrderSheetForm {
  String message() default  "주문 정보가 옳바르지 않습니다";
  Class<?>[] groups() default {};
  Class<? extends Payload>[] payload() default {};
}
