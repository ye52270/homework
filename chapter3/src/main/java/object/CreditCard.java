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
public class CreditCard {
  @Column(name = "credit_number", nullable = false)
  private String creditNumber;

  @Column(name = "credit_holder", nullable = false)
  private String creditHolder;

  @Builder
  public CreditCard(String creditNumber, String creditHolder) {
    Assert.hasText(creditHolder, "creditHolder must have....");
    Assert.hasText(creditNumber, "creditNumber must have....");
    this.creditNumber = creditNumber;
    this.creditHolder = creditHolder;
  }
}
