package py.com.jaha.api.promotions.domain.ports.in.offers;

import org.springframework.data.domain.Page;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferPageableResponse;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetOffersPageablePort extends UseCase<Page<GetOfferPageableResponse>, GetOffersCommand> {
}
