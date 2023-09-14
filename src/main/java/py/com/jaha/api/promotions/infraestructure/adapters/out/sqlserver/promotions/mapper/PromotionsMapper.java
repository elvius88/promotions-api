package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions.mapper;

import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.models.promotions.Promotion;
import py.com.jaha.api.promotions.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions.entities.Promotions;

@Mapper
public interface PromotionsMapper extends IMapper<Promotion, Promotions> {

  PromotionsMapper INSTANCE = Mappers.getMapper(PromotionsMapper.class);

  default Page<Promotion> toPromotionPageableResponse(Page<Promotions> promotionsPage) {
    return new PageImpl<>(promotionsPage.stream()
        .map(PromotionsMapper.INSTANCE::toDomain)
        .collect(Collectors.toList()),
        promotionsPage.getPageable(),
        promotionsPage.getTotalElements());
  }
}
