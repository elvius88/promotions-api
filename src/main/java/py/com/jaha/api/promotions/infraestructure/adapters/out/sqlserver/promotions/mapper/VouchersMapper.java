package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.establishments.domain.models.promotions.Voucher;
import py.com.jaha.api.establishments.infraestructure.adapters.out.commons.IMapper;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions.entities.Vouchers;

@Mapper
public interface VouchersMapper extends IMapper<Voucher, Vouchers> {

  VouchersMapper INSTANCE = Mappers.getMapper(VouchersMapper.class);
}
