package py.com.jaha.api.establishments.domain.ports.out;

import java.util.List;
import py.com.jaha.api.establishments.domain.models.promotions.Voucher;

public interface VouchersRepositoryPort {

  Voucher getVoucher(String id);

  List<Voucher> getVouchersBy(String clientId, String establishmentId);
}
