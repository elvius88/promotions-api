package py.com.jaha.api.promotions.domain.usecases.promotions;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsResponse;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPort;
import py.com.jaha.api.promotions.domain.ports.out.PromotionsRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.promotions.mappers.GetPromotionsResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetPromotionsUseCase implements GetPromotionsPort {

  private final PromotionsRepositoryPort promotionsRepositoryPort;

  @Override
  public GetPromotionsResponse execute(GetPromotionsCommand command) {
    return Try.of(() -> promotionsRepositoryPort.getPromotionsBy(command.getName(), command.getDescription(), command.getStartDate(),
            command.getEndDate(), command.getEstablishmentId()))
        .filter(promotions -> !CollectionUtils.isEmpty(promotions))
        .map(GetPromotionsResponseMapper.INSTANCE::toGetPromotionResponseList)
        .map(response -> GetPromotionsResponse.builder().vouchers(response).build())
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying promotions data: [{}]", NOT_FOUND))
        .get();
  }
}
