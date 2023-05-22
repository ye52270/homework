package part1;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ByPasswordChangePasswordService implements PasswordChangeService{
  final MemberFindService memberFindService;
  @Override
  public void change(final Long id, PasswordChangeRequest dto){
    if(dto.getPassword().equals("비밀번호가 일치하지 않는지 판단하는 로직....")) {
      final Member member = memberFindService.findById(id);
      final String newPassword = dto.getNewPassword();
      member.changePassword(newPassword);
    }
  }
}
