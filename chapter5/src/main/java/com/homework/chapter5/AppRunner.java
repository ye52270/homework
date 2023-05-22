package com.homework.chapter5;

import com.homework.chapter5.member.Member;
import com.homework.chapter5.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class AppRunner implements ApplicationRunner {
  private final MemberRepository memberRepository;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    memberRepository.save(new Member("abc@abc.com"));
    memberRepository.save(new Member("def@abc.com"));
  }
}
