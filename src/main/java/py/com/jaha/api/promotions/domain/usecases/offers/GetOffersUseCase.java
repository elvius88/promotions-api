package py.com.jaha.api.promotions.domain.usecases.offers;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersResponse;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOffersPort;
import py.com.jaha.api.promotions.domain.ports.out.OffersRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.offers.mappers.GetOffersResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetOffersUseCase implements GetOffersPort {

  private final OffersRepositoryPort offersRepositoryPort;

  @Override
  public GetOffersResponse execute(GetOffersCommand command) {
    return Try.of(() -> offersRepositoryPort.getOffersBy(command.getName(), command.getDescription(), command.getStartDate(),
            command.getEndDate(), command.getEstablishmentId()))
        .filter(offers -> !CollectionUtils.isEmpty(offers))
        .map(GetOffersResponseMapper.INSTANCE::toGetOfferResponseList)
        .map(response -> GetOffersResponse.builder().vouchers(response).build())
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying offers data: [{}]", NOT_FOUND))
        .get();
  }
}
