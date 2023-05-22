package part1;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

@Entity
@Table
@Getter
@ToString
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, updatable = false, unique = true)
  private String email;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String password;

  public void changePassword(String newPassword) {
    this.password = newPassword;
  }
}
