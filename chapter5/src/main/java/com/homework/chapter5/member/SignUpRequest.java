package com.homework.chapter5.member;

import com.homework.chapter5.validation.EmailUnique;
import jakarta.validation.constraints.Email;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class SignUpRequest {
  @Email
  @EmailUnique
  private String email;
  public SignUpRequest(String email) {
    this.email = email;
  }
}
