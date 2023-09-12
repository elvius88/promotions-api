package py.com.jaha.api.establishments.domain.models.promotions;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Voucher implements Serializable {

  private String id;
  private String name;
  private String description;
  private String imagePath;
  private String term;
  private LocalDate startDate;
  private LocalTime startHour;
  private LocalDate endDate;
  private LocalTime endHour;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
