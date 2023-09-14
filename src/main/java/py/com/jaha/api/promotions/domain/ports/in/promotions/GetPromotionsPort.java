package py.com.jaha.api.promotions.domain.ports.in.promotions;

import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsResponse;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetPromotionsPort extends UseCase<GetPromotionsResponse, GetPromotionsCommand> {
}
