package lombok;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//1. @Data 는 @Setter 가 무조건 포함되기 때문에 Setter 가 필요없는 필드에도 적용이 되는 문제점이 있다
@Entity
@Table(name = "member")
@Data
//Data 를 사용하면 전체 필드의 hashcode 를 작성해주게 된다
public class Member {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
//  비영속 상태일 때는 null
  private Long id;

//  객체 생성할 때 필수로 받으면 not null
  @Column(name = "email", nullable = false, updatable = false,unique = true)
  private String email;

  @Column(name = "name", nullable = false)
  private String name;

//  순환 참조되는 부분을 @Exclude 로 제외를 시켜야 순환참조 오류가 발생하지 않는다
  @OneToMany
  @JoinColumn(name = "coupon_id")
  @ToString.Exclude
  private List<Coupon> coupons = new ArrayList<>();

  @CreationTimestamp
  @Column(name = "create_at", nullable = false, updatable = false)
  private LocalDateTime createAt;

  @UpdateTimestamp
  @Column(name = "update_at", nullable = false)
  private LocalDateTime updateAt;

}
