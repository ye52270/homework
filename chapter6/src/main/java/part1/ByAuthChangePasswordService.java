package part1;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ByAuthChangePasswordService implements PasswordChangeService{
  private final MemberFindService memberFindService;

  @Override
  public void change(Long id, PasswordChangeRequest dto) {
    final Member member = memberFindService.findById(id);
    final String newPassword = dto.getNewPassword();
    member.changePassword(newPassword);
  }

}
