package py.com.jaha.api.promotions.domain.commands.promotions;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import py.com.jaha.api.promotions.config.DtoMeta;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@DtoMeta
public class GetPromotionResponse {

  @Schema(name = "id")
  private String id;

  @Schema(name = "name")
  private String name;

  @Schema(name = "description")
  private String description;

  @Schema(name = "image_path")
  private String imagePath;

  @Schema(name = "terms")
  private String terms;

  @Schema(name = "start_date")
  private LocalDate startDate;

  @Schema(name = "end_date")
  private LocalDate endDate;
}
