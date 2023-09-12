package py.com.jaha.api.establishments.domain.usecases.promotions;

import static py.com.jaha.api.establishments.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.establishments.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import py.com.jaha.api.establishments.domain.commands.promotions.GetVoucherResponse;
import py.com.jaha.api.establishments.domain.commands.promotions.GetVouchersCommand;
import py.com.jaha.api.establishments.domain.ports.in.GetVoucherPort;
import py.com.jaha.api.establishments.domain.ports.out.VouchersRepositoryPort;
import py.com.jaha.api.establishments.domain.usecases.promotions.mappers.GetVoucherResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetVoucherUseCase implements GetVoucherPort {

  private final VouchersRepositoryPort vouchersRepositoryPort;

  @Override
  public GetVoucherResponse execute(GetVouchersCommand command) {
    return Try.of(() -> vouchersRepositoryPort.getVoucher(command.getId()))
        .filter(Objects::nonNull)
        .map(GetVoucherResponseMapper.INSTANCE::toGetVoucherResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying vouchers data: [{}]", NOT_FOUND))
        .get();
  }
}
