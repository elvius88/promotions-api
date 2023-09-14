package py.com.jaha.api.promotions.domain.usecases.promotions;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionPort;
import py.com.jaha.api.promotions.domain.ports.out.PromotionsRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.promotions.mappers.GetPromotionsResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetPromotionUseCase implements GetPromotionPort {

  private final PromotionsRepositoryPort promotionsRepositoryPort;

  @Override
  public GetPromotionResponse execute(GetPromotionsCommand command) {
    return Try.of(() -> promotionsRepositoryPort.getPromotion(command.getId()))
        .filter(Objects::nonNull)
        .map(GetPromotionsResponseMapper.INSTANCE::toGetPromotionResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying promotion data: [{}]", NOT_FOUND))
        .get();
  }
}
