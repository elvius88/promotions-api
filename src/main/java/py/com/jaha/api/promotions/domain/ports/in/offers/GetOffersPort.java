package py.com.jaha.api.promotions.domain.ports.in.offers;

import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersResponse;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetOffersPort extends UseCase<GetOffersResponse, GetOffersCommand> {
}
