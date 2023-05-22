package com.homework.chapter5.order;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OrderSheetFormValidator
        implements ConstraintValidator<OrderSheetForm, OrderSheetRequest> {

  @Override
  public void initialize(OrderSheetForm constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(OrderSheetRequest value, ConstraintValidatorContext context) {
    int invalidCount = 0;
    if (value.getPayment().getAccount() == null && value.getPayment().getCard() == null) {
      addConstraintViolation(context, "카드정보 혹은 계좌정보는 필수입니다",
              "payment오류");
      invalidCount += 1;
    }
    return invalidCount == 0;
  }

  private void addConstraintViolation(
          final ConstraintValidatorContext context,
          final String errorMessage,
          final String firstNode) {
    context.disableDefaultConstraintViolation();
    context.buildConstraintViolationWithTemplate(errorMessage)
            .addPropertyNode(firstNode)
            .addConstraintViolation();
  }
}
