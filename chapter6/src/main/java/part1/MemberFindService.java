package part1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberFindService {

  private final MemberRepository memberRepository;

  public Member findById(final Long id) {
    return memberRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("id : " + id +
                    " not found"));
  }

  public Member findByEmail(final String email) {
    final Member member =  memberRepository.findByEmail(email);
    if(member == null) {
      throw new IllegalArgumentException("email : " + email +
              " not found");
    }
    return member;
  }

}
