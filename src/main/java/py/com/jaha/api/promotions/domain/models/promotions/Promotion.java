package py.com.jaha.api.promotions.domain.models.promotions;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
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
public class Promotion implements Serializable {

  private String id;
  private String name;
  private String description;
  private String terms;
  private LocalDate startDate;
  private LocalDate endDate;
  private List<PromotionImage> promotionImages;
}
