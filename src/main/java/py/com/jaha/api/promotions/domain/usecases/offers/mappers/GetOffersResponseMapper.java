package py.com.jaha.api.promotions.domain.usecases.offers.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferPageableResponse;
import py.com.jaha.api.promotions.domain.commands.offers.GetOfferResponse;
import py.com.jaha.api.promotions.domain.models.offers.Offer;
import py.com.jaha.api.promotions.domain.models.offers.OfferImage;

@Mapper
public interface GetOffersResponseMapper {

  GetOffersResponseMapper INSTANCE = Mappers.getMapper(GetOffersResponseMapper.class);

  @Mapping(source = "offerImages", target = "imagePath", qualifiedByName = "imagePathMapping")
  @Named(value = "getOfferResponse")
  GetOfferResponse toGetOfferResponse(Offer offer);

  @IterableMapping(qualifiedByName = "getOfferResponse")
  List<GetOfferResponse> toGetOfferResponseList(List<Offer> offers);

  @Mapping(source = "offerImages", target = "imagePath", qualifiedByName = "imagePathMapping")
  GetOfferPageableResponse toPageableGetOffersResponse(Offer offer);

  default Page<GetOfferPageableResponse> toGetPromotionsPageableResponse(Page<Offer> offerPage) {
    return new PageImpl<>(offerPage.stream()
        .map(GetOffersResponseMapper.INSTANCE::toPageableGetOffersResponse)
        .collect(Collectors.toList()),
        offerPage.getPageable(),
        offerPage.getTotalElements());
  }

  @Named(value = "imagePathMapping")
  static String toImagePathMapping(List<OfferImage> offerImages) {
    return offerImages.stream()
        .filter(offerImage -> Boolean.TRUE.equals(offerImage.getActive()))
        .findFirst().orElse(new OfferImage()).getImagePath();
  }
}
