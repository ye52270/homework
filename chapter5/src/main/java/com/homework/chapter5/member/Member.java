package com.homework.chapter5.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "member")
@Getter
@ToString
@NoArgsConstructor

public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Email
  @Column(name = "email", nullable = false, updatable = false, unique = true)
  private String email;

  @Builder
  public Member(String email) {
    this.email = email;
  }
}
