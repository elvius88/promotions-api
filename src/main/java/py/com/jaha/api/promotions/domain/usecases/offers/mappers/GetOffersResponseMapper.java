package py.com.jaha.api.promotions.domain.usecases.offers.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferResponse;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferPageableResponse;
import py.com.jaha.api.promotions.domain.models.offers.Offer;

@Mapper
public interface GetOffersResponseMapper {

  GetOffersResponseMapper INSTANCE = Mappers.getMapper(GetOffersResponseMapper.class);

  @Named(value = "getOfferResponse")
  GetOfferResponse toGetOfferResponse(Offer offer);

  @IterableMapping(qualifiedByName = "getOfferResponse")
  List<GetOfferResponse> toGetOfferResponseList(List<Offer> offers);

  GetOfferPageableResponse toPageableGetOffersResponse(Offer offer);

  default Page<GetOfferPageableResponse> toGetPromotionsPageableResponse(Page<Offer> offerPage) {
    return new PageImpl<>(offerPage.stream()
        .map(GetOffersResponseMapper.INSTANCE::toPageableGetOffersResponse)
        .collect(Collectors.toList()),
        offerPage.getPageable(),
        offerPage.getTotalElements());
  }
}
