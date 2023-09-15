package py.com.jaha.api.promotions.domain.models.offers;

import java.io.Serializable;
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
public class Offer implements Serializable {

  private String id;
  private String name;
  private String description;
  private String terms;
  private String startDate;
  private String endDate;
  private String startHour;
  private String endHour;
  private List<OfferImage> offerImages;
}
