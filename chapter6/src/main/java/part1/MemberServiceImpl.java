package part1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MemberServiceImpl implements MemberService {

  public Member findById(Long id) {
    return null;
  }

  public Member findByEmail(String email) {
    return null;
  }
  @Override
  public Member create(Member member) {
    return null;
  }
  @Override
  public void changePassword(PasswordChangeRequest dto) {

  }
  @Override
  public Member updateName(Long id, String name) {
    return null;
  }
}
