package part1;

import lombok.Getter;

/*
  행위를 표현하고 있다 -> 클래스명으로 책임이 명확하게 구별할 수 있다
  인터페이스는 다형성을 가지고 있다 -> 책임이 명확하다
  그러면 메서드가 하나여야 하나?
 */

public interface PasswordChangeService {
  void change(Long id, PasswordChangeRequest dto);


}
