package py.com.jaha.api.promotions.domain.models.offers;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import py.com.jaha.api.promotions.domain.models.promotions.PromotionImage;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Promotion implements Serializable {

  private String name;
  private String description;
  private String terms;
  private LocalDate startDate;
  private LocalDate endDate;
  private List<PromotionImage> promotionImages;
}
