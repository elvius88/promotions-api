package py.com.jaha.api.establishments.domain.commands.promotions;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetVoucherResponse {

  private String name;

  private String description;

  @Schema(name = "voucher_image_path")
  private String imagePath;

  private String terms;

  @Schema(name = "voucher_images")
  private List<VoucherImage> imagesPath;
}
