package py.com.jaha.api.promotions.domain.ports.in.promotions;

import org.springframework.data.domain.Page;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionPageableResponse;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetPromotionsPageablePort extends UseCase<Page<GetPromotionPageableResponse>, GetPromotionsCommand> {
}
