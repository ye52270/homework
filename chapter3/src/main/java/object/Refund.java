package object;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.util.Assert;

@Entity
@Table(name = "refund")
@Getter
@NoArgsConstructor


public class Refund {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @Embedded
  private Account account;

  @Embedded
  private CreditCard creditCard;

  @OneToOne
  @JoinColumn(name = "order_id", nullable = false)
  private Order order;

//    account 가 없으면(null) creditCard 가 있어야(notnull) 한다
//    account 가 있으면(notnull) creditCard 가 없어야(null) 한다
//    account, creditCard 는 둘 다 없으면 (null)안된다
//    account, creditCard 는 둘 다 있을 수 없다(notnull)

  @Builder(builderClassName = "ByAccountBuilder", builderMethodName ="ByAccountBuilder" )

  public Refund(Account account,  Order order) {
    Assert.notNull(account, "account must.......");
    Assert.notNull(order, "order must........");

    this.account = account;
    this.order = order;
  }

  @Builder(builderClassName = "ByCreditCardBuilder", builderMethodName = "ByCreditCardBuilder")
  public Refund(CreditCard creditCard,  Order order) {

    Assert.notNull(creditCard, "creditcard must ......");
    Assert.notNull(order, "order must ......");
    this.creditCard = creditCard;
    this.order = order;
  }

}
