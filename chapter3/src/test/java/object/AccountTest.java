package object;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

class AccountTest {

//  AccountHolder 가 비어있어도 성공한다(문제점)
//  빈 값이 넘어왔을때 검증하는 로직이 없다
//  해당 객체가 본인의 책임을 다하지 않고 있다(본인의 책임을 다하고 있다면 불완전한 객체를 생성하지 못하게 막아야 한다)
//  객체가 본인의 책임을 다하지 않으면 그 책임은 다른 객체로 넘어가게 된다
  @Test
  public void Account_accountHolder_비어있으면_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder("")
            .bankName("KB")
            .accountNumber("1111")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }

  @Test
  public void Account_accountHolder_null_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder(null)
            .bankName("KB")
            .accountNumber("1111")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }

  @Test
  public void Account_bankName_비어있으면_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder("Park")
            .bankName("")
            .accountNumber("1111")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }
  @Test
  public void Account_bankName_null_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder("Park")
            .bankName(null)
            .accountNumber("1111")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }


  @Test
  public void Account_accountNumber_비어있으면_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder("Park")
            .bankName("KB")
            .accountNumber("")
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }



  @Test
  public void Account_accountNumber_null_exception() {
//    final Account account = Account.builder()
//            .bankName("KB")
//            .accountHolder("")
//            .accountNumber("1111")
//            .build();

    thenThrownBy(() -> Account.builder()
            .accountHolder("Park")
            .bankName("KB")
            .accountNumber(null)
            .build())
            .isInstanceOf(IllegalArgumentException.class);
//    then(account.getAccountHolder()).isEqualTo("");
//    then(account.getBankName()).isEqualTo("KB");
//    then(account.getAccountNumber()).isEqualTo("1111");
  }


  @Test
  public void Account_모든필수값을_입력하면_성공() {
    final Account account = Account.builder()
            .bankName("KB")
            .accountHolder("park")
            .accountNumber("1111")
            .build();

    then(account.getAccountHolder()).isEqualTo("park");
    then(account.getBankName()).isEqualTo("KB");
    then(account.getAccountNumber()).isEqualTo("1111");
  }
}