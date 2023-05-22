package object;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Account {
  @Column(name = "bank_name", nullable = false)
  private String bankName;

  @Column(name = "account_number", nullable = false)
  private String accountNumber;

  @Column(name = "account_holder", nullable = false)
  private String accountHolder;

//  불안전한 객체 생성 패턴
//  그냥 단순하게 검증만 하는 것이 아니고 객체 본인의 책임을 다하는 코드로 변경했음(필수값 체크)
//  생성자 코드에서 이런 책임에 대한 부분을 체크해주면 된다

  @Builder
  public Account(String bankName, String accountNumber, String accountHolder) {

    Assert.hasText(bankName, "bankName must have");
    Assert.hasText(accountNumber, "accountNumber must have");
    Assert.hasText(accountHolder, "accountHolder must have");

    this.bankName = bankName;
    this.accountNumber = accountNumber;
    this.accountHolder = accountHolder;
  }
}
