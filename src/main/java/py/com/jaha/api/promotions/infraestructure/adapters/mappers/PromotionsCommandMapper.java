package py.com.jaha.api.promotions.infraestructure.adapters.mappers;

import java.time.LocalDate;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Pageable;
import py.com.jaha.api.promotions.domain.commands.promotions.GetPromotionsCommand;

@Mapper
public interface PromotionsCommandMapper {

  PromotionsCommandMapper INSTANCE = Mappers.getMapper(PromotionsCommandMapper.class);

  default GetPromotionsCommand toCommand(String id,
                                         String name,
                                         String description,
                                         LocalDate startDate,
                                         LocalDate endDate,
                                         String establishmentId,
                                         Pageable pageable) {
    return GetPromotionsCommand.builder()
        .id(id).name(name).description(description).startDate(startDate).endDate(endDate)
        .establishmentId(establishmentId).pageable(pageable).build();
  }
}
