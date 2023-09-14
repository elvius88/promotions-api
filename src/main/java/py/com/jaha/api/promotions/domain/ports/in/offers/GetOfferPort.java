package py.com.jaha.api.promotions.domain.ports.in.offers;

import py.com.jaha.api.promotions.domain.commands.offers.GetOfferResponse;
import py.com.jaha.api.promotions.domain.commands.offers.GetOffersCommand;
import py.com.jaha.api.promotions.domain.usecases.UseCase;

public interface GetOfferPort extends UseCase<GetOfferResponse, GetOffersCommand> {
}
