package py.com.jaha.api.establishments.domain.commands.promotions;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GetVouchersResponse {

  private List<GetVoucherResponse> vouchers;
}
