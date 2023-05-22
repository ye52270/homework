package com.homework.chapter4;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
  private final MemberRepository memberRepository;

  public Member createUncheckedException() {
    final Member member = memberRepository.save(new Member("Yun"));
    if(true) {
      throw new RuntimeException();
    }
    return member;
  }

  public Member createCheckedException() throws IOException {
    final Member member = memberRepository.save(new Member("Park"));
    if(true) {
      throw new IOException();
    }
    return member;
  }

  public Member findById(final Long id) {
    return memberRepository.findById(id).get();
  }

  public void createBasic() {
     memberRepository.save(new Member("Park Jae young"));
  }
}
