package py.com.jaha.api.promotions.domain.commands.offers;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class GetOfferPageableResponse {

  private String name;

  private String description;

  @Schema(name = "voucher_image_path")
  private String imagePath;

  private String terms;
}
