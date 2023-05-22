package com.homework.chapter4;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class Exception1 {
  private final MemberRepository memberRepository;

//  예외가 발생했지만 아무 처리도 하지 않고 로직을 진행하는 경우
  public void doxxx1(final Long id) {
    String name = null;
    try{
      final Member member = memberRepository.findById(id).get();
      name = member.getName();
    }catch (Exception e) {
//      추가작업을 진행.....
      log.error(e.getMessage());
    }
    System.out.println("이름은--------------" + name);
  }

//  예외가 발생하면 예외 로그라도 출력한다
  public void doxxx2(final Long id) {
    String name = null;
    try {
      final Member member = memberRepository.findById(id).get();
      name = member.getName();
    }catch (Exception e) {
      e.printStackTrace();
      log.error(e.getMessage());
    }
    System.out.println("이름은--------------" + name);
  }

//  예외가 발생하면 로그를 출력하고 더 구체적인 예외를 발생시킨다
//  예외가 발생해서 더 이상 후속작업이 불가능할 경우 Exception 을 발생시켜 코드를 종료한다

  public void doxxx4(final Long id) {
    String name = null;
    try {
      final Member member = memberRepository.findById(id).get();

    }catch (Exception e){
      e.printStackTrace();
      throw new IllegalArgumentException("해당 id : " + id + " 의 member name 은 null 입니다");
    }
    System.out.println("이름은--------------" + name);
  }

//  예외 처리가 가능하면 Exception 을 발생시키지 않고 로직으로 풀어낸다
  public void doxxx5(final Long id) {
    String name = null;

    final Member member = memberRepository.findById(id).get();

    if(member!=null) {
      name = member.getName();
    }else {
      name = "Default Name";
    }

    System.out.println("이름은--------------" + name);
  }

}
// 1. try catch를 최대한 지양해라.(로직으로 예외 처리가 가능하다면)
// 2. try catch를 하는데 아무런 처리가 없다면 로그라도 추가하자
// 3. try catch를 사용하게 된다면, 더 구체적인 예외를 발생시키는것이 좋다. (Exception 직접 정의 or Error Message를 명확하게)