package py.com.jaha.api.promotions.domain.usecases.promotions.mappers;

import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionResponse;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionPageableResponse;
import py.com.jaha.api.promotions.domain.models.promotions.Promotion;
import py.com.jaha.api.promotions.domain.models.promotions.PromotionImage;

@Mapper
public interface GetPromotionsResponseMapper {

  GetPromotionsResponseMapper INSTANCE = Mappers.getMapper(GetPromotionsResponseMapper.class);

  @Mapping(source = "promotionImages", target = "imagePath", qualifiedByName = "imagePathMapping")
  @Named(value = "getPromotionResponse")
  GetPromotionResponse toGetPromotionResponse(Promotion promotion);

  @IterableMapping(qualifiedByName = "getPromotionResponse")
  List<GetPromotionResponse> toGetPromotionResponseList(List<Promotion> promotions);

  @Mapping(source = "promotionImages", target = "imagePath", qualifiedByName = "imagePathMapping")
  GetPromotionPageableResponse toPageableGetPromotionResponse(Promotion promotion);

  default Page<GetPromotionPageableResponse> toGetPromotionsPageableResponse(Page<Promotion> promotionPage) {
    return new PageImpl<>(promotionPage.stream()
        .map(GetPromotionsResponseMapper.INSTANCE::toPageableGetPromotionResponse)
        .collect(Collectors.toList()),
        promotionPage.getPageable(),
        promotionPage.getTotalElements());
  }

  @Named(value = "imagePathMapping")
  static String toImagePathMapping(List<PromotionImage> promotionImages) {
    return promotionImages.stream()
        .filter(promotionImage -> Boolean.TRUE.equals(promotionImage.getActive()))
        .findFirst().orElse(new PromotionImage()).getImagePath();
  }
}
