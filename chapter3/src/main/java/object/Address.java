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
public class Address {
  @Column(name = "address1", nullable = false)
  private String address1;

  @Column(name = "address2", nullable = false)
  private String address2;

  @Column(name = "zip", nullable = false)
  private String zip;

  @Builder
  public Address(String address1, String address2, String zip) {
    Assert.hasText(address1, "address1 must have.....");
    Assert.hasText(address2, "address2 must have.....");
    Assert.hasText(zip, "zip must have.....");

    this.address1 = address1;
    this.address2 = address2;
    this.zip = zip;
  }
}
