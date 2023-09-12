package py.com.jaha.api.establishments.domain.ports.in;

import py.com.jaha.api.establishments.domain.commands.promotions.GetVoucherResponse;
import py.com.jaha.api.establishments.domain.commands.promotions.GetVouchersCommand;
import py.com.jaha.api.establishments.domain.usecases.UseCase;

public interface GetVoucherPort extends UseCase<GetVoucherResponse, GetVouchersCommand> {
}
