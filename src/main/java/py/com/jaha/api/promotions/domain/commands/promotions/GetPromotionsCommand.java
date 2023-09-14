package py.com.jaha.api.promotions.domain.commands.promotions;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetPromotionsCommand {

  private String id;
  private String name;
  private String description;
  private LocalDate startDate;
  private LocalDate endDate;
  private String establishmentId;
  private Pageable pageable;
}
