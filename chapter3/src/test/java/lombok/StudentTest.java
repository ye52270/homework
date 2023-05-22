package lombok;

import org.assertj.core.api.LocalDateAssert;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

// 정상적인 객체를 생성하지 않았는데(notnull 인데도 생성됨) 그 뒤 로직은 정상이 아니다
// 1. 안정성
// 2. 객체 본인의 책임을 표현하지 못한다. Student 객체 자신이 필수 값이라 생각되면 반드시 객체 생성때 받아줘야 한다
class StudentTest {
  @Test
  public void 클래스_상단의_Builder의단점() {
//    final Student student = Student.builder().build();
//    email 등이 필수값이지만 값을 안 넣어도 객체가 생성된다
//    id, createAt, updateAt 등은 자동적으로 넣어야 되는데 객체 생성때 값을 임의로 넣을 수 있게 된다

//    Builder 를 클래스 상단이 아니고 생성자(생성자는 수동으로 생성) 상단에 만든다
    final Student student = Student.builder()
//            id는 생성자에 binding 되지 않았기 때문에 만들 수 없게 된다(해결책)
//            .id(1L)
//            .createAt(LocalDateTime.now().plusDays(1000))
//            .updateAt(LocalDateTime.now().plusDays(1000))
            .email("abc@abc.com")
            .name("park jae young")
            .build();
    System.out.println("스튜던트 객체 ------------> " + student);
  }

}

//  Builder 패턴은 필수 값은 생성자로 받고, optional 값은 static 한 값으로 받는다