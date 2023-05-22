package part1;

/*
  확장되지 않는 서비스는 굳이 인터페이스를 사용하지 말자
 */
public interface MemberService {
//  Member findById(Long id);
//  Member findByEmail(String email);
//  Member create(Member member);
//  password 변경은 sms, email 등 확장 가능. 인터페이스로 남겨 놓는다
  void changePassword(PasswordChangeRequest dto);
  Member updateName(Long id, String name);
}
