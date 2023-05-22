package com.homework.chapter5.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
@RequiredArgsConstructor

public class MemberApi {
  private final MemberRepository memberRepository;

  @GetMapping
  public List<Member> getAllMembers(){
    return memberRepository
            .findAll();
  }

  @PostMapping
  public Member create(@RequestBody @Valid SignUpRequest dto) {
    return memberRepository
            .save(Member.builder()
                    .email(dto.getEmail())
                    .build());
  }
}
