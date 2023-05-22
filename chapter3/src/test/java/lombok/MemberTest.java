package lombok;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberTest {
  @Test
  public void setter_남용의_문제() {
//    회원에 대한 email 변경을 제공하지 않는다
    final Member member = new Member();

//    Bean 방식(기본 생성자를 만들고 필요한 값을 채워넣는 방식. 좋은 방식이 아니다)
    member.setEmail("abc@abc.com");
    member.setName("Park Jae Young");

//  email 은 수정할 수 없지만 @Data 에 포함된 Setter 를 사용해 수정이 가능해지는 문제가 발생한다

    member.setEmail("def@abc.com");

    System.out.println(member);

  }

  @Test
  public void toString_양방향_순환_참조문제(){
    final Member member = new Member();
    member.setEmail("abc@abc.com");
    member.setName("Park Jae Young");

    final Coupon coupon = new Coupon();
    coupon.setMember(member);

    final List<Coupon> coupons = new ArrayList<>();
    coupons.add(coupon);
    member.setCoupons(coupons);
//    toString() 순환 참조 발생
    System.out.println(member);
   }

   @Test
  public void equalsHashCode_문제() {

   }

}