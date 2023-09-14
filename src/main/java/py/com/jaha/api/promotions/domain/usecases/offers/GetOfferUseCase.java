package py.com.jaha.api.promotions.domain.usecases.offers;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferResponse;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOfferPort;
import py.com.jaha.api.promotions.domain.ports.out.OffersRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.offers.mappers.GetOffersResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetOfferUseCase implements GetOfferPort {

  private final OffersRepositoryPort offersRepositoryPort;

  @Override
  public GetOfferResponse execute(GetOffersCommand command) {
    return Try.of(() -> offersRepositoryPort.getOffer(command.getId()))
        .filter(Objects::nonNull)
        .map(GetOffersResponseMapper.INSTANCE::toGetOfferResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying offer data: [{}]", NOT_FOUND))
        .get();
  }
}
