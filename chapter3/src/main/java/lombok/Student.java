package lombok;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

//lobom.config 설정을 통해 제한할 필요가 있다
@Entity
@Table(name = "student")
//class 상단의 builder 의 문제
//@Builder
@ToString
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "email",nullable = false, updatable = false, unique = true)
  private String email;

  @Column(name = "name", nullable = false)
  private String name;

  @CreationTimestamp
  @Column(name = "create_at", nullable = false, updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  @Column(name = "update_at", nullable = false)
  private LocalDateTime updateAt;

//  Builder 는 class 상단에 만들지 말고 필요로 하는 생성자 위에 만든다
  @Builder
  public Student(final String email, final String name) {
    this.email = email;
    this.name = name;
  }
}
