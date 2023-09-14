package py.com.jaha.api.promotions.domain.usecases.offers;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferPageableResponse;
import py.com.jaha.api.promotions.domain.ports.in.offers.GetOffersPageablePort;
import py.com.jaha.api.promotions.domain.ports.out.OffersRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.offers.mappers.GetOffersResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetOffersPageableUseCase implements GetOffersPageablePort {

  private final OffersRepositoryPort offersRepositoryPort;

  @Override
  public Page<GetOfferPageableResponse> execute(GetOffersCommand command) {
    return Try.of(() -> offersRepositoryPort.getPageableOffersBy(command.getName(), command.getDescription(), command.getStartDate(),
            command.getEndDate(), command.getEstablishmentId(), command.getPageable()))
        .filter(offers -> !CollectionUtils.isEmpty(offers.getContent()))
        .map(GetOffersResponseMapper.INSTANCE::toGetPromotionsPageableResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying pageable offers data: [{}]", NOT_FOUND))
        .get();
  }
}
