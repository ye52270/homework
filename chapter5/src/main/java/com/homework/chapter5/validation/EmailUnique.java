package com.homework.chapter5.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EmailDuplicateValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EmailUnique {
  String message() default "이메일 중복이다";
  Class<?>[] groups () default {};
  Class<?  extends Payload>[] payload() default  {};
}

