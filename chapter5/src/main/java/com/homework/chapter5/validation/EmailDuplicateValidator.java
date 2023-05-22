package com.homework.chapter5.validation;

import com.homework.chapter5.member.MemberRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;

@Component
@RequiredArgsConstructor //생성자 주입
public class EmailDuplicateValidator implements ConstraintValidator<EmailUnique, String> {
  private final MemberRepository memberRepository;

  @Override
  public void initialize(EmailUnique constraintAnnotation) {
    ConstraintValidator.super.initialize(constraintAnnotation);
  }

  @Override
  public boolean isValid(String email, ConstraintValidatorContext context) {
    final boolean isExistEmail = memberRepository.existsByEmail(email);
    if(isExistEmail){
      context.disableDefaultConstraintViolation();
      context.buildConstraintViolationWithTemplate(
              MessageFormat.format("Email : {0} 이미 존재하는 이메일 입니다", email)
      ).addConstraintViolation();

    }
    return !isExistEmail;
  }
}
