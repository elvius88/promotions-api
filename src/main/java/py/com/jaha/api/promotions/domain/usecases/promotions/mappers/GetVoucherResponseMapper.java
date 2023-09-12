package py.com.jaha.api.establishments.domain.usecases.promotions.mappers;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import py.com.jaha.api.establishments.domain.commands.promotions.GetVoucherResponse;
import py.com.jaha.api.establishments.domain.models.promotions.Voucher;

@Mapper
public interface GetVoucherResponseMapper {

  GetVoucherResponseMapper INSTANCE = Mappers.getMapper(GetVoucherResponseMapper.class);

  GetVoucherResponse toGetVoucherResponse(Voucher voucher);
  List<GetVoucherResponse> toGetVoucherResponseList(List<Voucher> vouchers);
}
