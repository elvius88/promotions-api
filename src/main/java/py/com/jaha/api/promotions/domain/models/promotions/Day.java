package py.com.jaha.api.establishments.domain.models.promotions;

import java.io.Serializable;
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
public class Day implements Serializable {

  private String id;
  private String name;
  private Integer order;
  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
