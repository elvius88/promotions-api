package py.com.jaha.api.establishments.domain.commands.promotions;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetVouchersCommand {

  private String id;
  private String clientId;
  private String establishmentId;
}
