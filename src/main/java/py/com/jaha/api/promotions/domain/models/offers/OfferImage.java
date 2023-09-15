package py.com.jaha.api.promotions.domain.models.offers;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class OfferImage implements Serializable {

  private String id;
  private String imagePath;
  private Boolean active;
}
