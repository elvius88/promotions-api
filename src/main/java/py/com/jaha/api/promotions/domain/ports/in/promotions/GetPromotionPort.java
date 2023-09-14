package py.com.jaha.api.promotions.domain.ports.in.promotions;

import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetPromotionPort extends UseCase<GetPromotionResponse, GetPromotionsCommand> {
}
