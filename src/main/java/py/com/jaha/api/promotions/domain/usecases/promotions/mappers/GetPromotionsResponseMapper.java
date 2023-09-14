package py.com.jaha.api.promotions.domain.usecases.promotions.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionPageableResponse;
import py.com.jaha.api.promotions.domain.models.promotions.Promotion;

@Mapper
public interface GetPromotionsResponseMapper {

  GetPromotionsResponseMapper INSTANCE = Mappers.getMapper(GetPromotionsResponseMapper.class);

  @Named(value = "getPromotionResponse")
  GetPromotionResponse toGetPromotionResponse(Promotion promotion);

  @IterableMapping(qualifiedByName = "getPromotionResponse")
  List<GetPromotionResponse> toGetPromotionResponseList(List<Promotion> promotions);

  GetPromotionPageableResponse toPageableGetPromotionResponse(Promotion promotion);

  default Page<GetPromotionPageableResponse> toGetPromotionsPageableResponse(Page<Promotion> promotionPage) {
    return new PageImpl<>(promotionPage.stream()
        .map(GetPromotionsResponseMapper.INSTANCE::toPageableGetPromotionResponse)
        .collect(Collectors.toList()),
        promotionPage.getPageable(),
        promotionPage.getTotalElements());
  }
}
