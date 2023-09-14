package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers.mapper;

import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import py.com.jaha.api.promotions.domain.models.offers.Offer;
import py.com.jaha.api.promotions.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers.entities.Offers;

@Mapper
public interface OffersMapper extends IMapper<Offer, Offers> {

  OffersMapper INSTANCE = Mappers.getMapper(OffersMapper.class);

  default Page<Offer> toOffersPageableResponse(Page<Offers> offersPage) {
    return new PageImpl<>(offersPage.stream()
        .map(OffersMapper.INSTANCE::toDomain)
        .collect(Collectors.toList()),
        offersPage.getPageable(),
        offersPage.getTotalElements());
  }
}
