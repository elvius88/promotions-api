package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "vouchers")
@ToString
public class Vouchers implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "description", nullable = false)
  private String description;

  @Column(name = "coupon_image_path", nullable = false)
  private String imagePath;

  @Column(name = "term", nullable = false)
  private String term;

  @Column(name = "start_date", nullable = false, updatable = false)
  private LocalDate startDate;

  @Column(name = "start_hour", nullable = false, updatable = false)
  private LocalTime startHour;

  @Column(name = "end_date", nullable = false, updatable = false)
  private LocalDate endDate;

  @Column(name = "end_hour", nullable = false, updatable = false)
  private LocalTime endHour;

  @Column(name = "created_at", nullable = false, updatable = false)
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", nullable = false)
  private OffsetDateTime updatedAt;
}
