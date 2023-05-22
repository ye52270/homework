package object;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.filter;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.BDDAssertions.then;
import static org.assertj.core.api.BDDAssertions.thenThrownBy;

class RefundTest {

  private Order order;
  private Account account;
  private CreditCard creditCard;

//  BeforeEach 는 테스트코드가 실행되기 전에 먼저 실행된다
  @BeforeEach
  public void setUp() {
    final Address address = Address
            .builder()
            .address1("서울시")
            .address2("송파구")
            .zip("12345")
            .build();
    account = Account
            .builder()
            .accountHolder("Park Jae Young")
            .accountNumber("111-123-123")
            .bankName("국민은행")
            .build();

    creditCard = CreditCard
            .builder()
            .creditNumber("11-11-22")
            .creditHolder("Kim Ji Seon")
            .build();

    order = Order
            .builder()
            .address(address)
            .build();

  }

  @Test
  public void refund_계좌번호_환불() {
    final Refund refund = Refund.ByAccountBuilder()
            .account(account)
            .order(order)
            .build();

    then(refund.getAccount()).isEqualTo(account);
    then(refund.getOrder()).isEqualTo(order);

  }
  @Test
  public void refund_계좌번호_환불_account_is_null_exception발생() {
//    final Refund refund = Refund.ByAccountBuilder()
//            .account(null)
//            .order(order)
//            .build();
//
//    then(refund.getAccount()).isEqualTo(null);
//    then(refund.getOrder()).isEqualTo(order);

    thenThrownBy(() ->
            Refund.ByAccountBuilder()
                    .account(null)
                    .order(order)
                    .build()
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void refund_creditCard_환불() {
    final Refund refund = Refund.ByCreditCardBuilder()
            .creditCard(creditCard)
            .order(order)
            .build();

    then(refund.getAccount()).isNull();
    then(refund.getCreditCard()).isEqualTo(creditCard);
    then(refund.getOrder()).isEqualTo(order);


  }
  @Test
  public void refund_creditCard_환불_creditCard_is_null_exception발생() {
//    final Refund refund = Refund.ByAccountBuilder()
//            .account(null)
//            .order(order)
//            .build();
//
//    then(refund.getAccount()).isEqualTo(null);
//    then(refund.getOrder()).isEqualTo(order);

    thenThrownBy(() ->
             Refund.ByCreditCardBuilder()
                     .creditCard(null)
                     .order(order)
                     .build()
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void refund_creditCard_환불_order_is_null_exception발생() {
//    final Refund refund = Refund.ByAccountBuilder()
//            .account(null)
//            .order(order)
//            .build();
//
//    then(refund.getAccount()).isEqualTo(null);
//    then(refund.getOrder()).isEqualTo(order);

    thenThrownBy(() ->
            Refund.ByCreditCardBuilder()
                    .creditCard(creditCard)
                    .order(null)
                    .build()
    ).isInstanceOf(IllegalArgumentException.class);
  }

}