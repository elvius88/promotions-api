package py.com.jaha.api.promotions.domain.usecases.promotions;

import static py.com.jaha.api.promotions.domain.models.commons.enums.ErrorCatalog.NOT_FOUND;
import static py.com.jaha.api.promotions.domain.usecases.utils.LogUtil.logAndThrows;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.util.CollectionUtils;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionPageableResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.ports.in.promotions.GetPromotionsPageablePort;
import py.com.jaha.api.promotions.domain.ports.out.PromotionsRepositoryPort;
import py.com.jaha.api.promotions.domain.usecases.promotions.mappers.GetPromotionsResponseMapper;

@Slf4j
@RequiredArgsConstructor
public class GetPromotionsPageableUseCase implements GetPromotionsPageablePort {

  private final PromotionsRepositoryPort promotionsRepositoryPort;

  @Override
  public Page<GetPromotionPageableResponse> execute(GetPromotionsCommand command) {
    return Try.of(() -> promotionsRepositoryPort.getPageablePromotionsBy(command.getName(), command.getDescription(), command.getStartDate(),
            command.getEndDate(), command.getEstablishmentId(), command.getPageable()))
        .filter(promotions -> !CollectionUtils.isEmpty(promotions.getContent()))
        .map(GetPromotionsResponseMapper.INSTANCE::toGetPromotionsPageableResponse)
        .onSuccess(response -> log.debug("Query has been successful: [{}]", response))
        .onFailure(logAndThrows(log, "Error querying pageable promotions data: [{}]", NOT_FOUND))
        .get();
  }
}
