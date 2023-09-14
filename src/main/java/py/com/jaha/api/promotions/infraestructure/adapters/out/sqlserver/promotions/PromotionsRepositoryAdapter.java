package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions;

import io.vavr.control.Try;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import py.com.jaha.api.promotions.domain.models.promotions.Promotion;
import py.com.jaha.api.promotions.domain.ports.out.PromotionsRepositoryPort;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions.mapper.PromotionsMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class PromotionsRepositoryAdapter implements PromotionsRepositoryPort {

  private final PromotionsRepository promotionsRepository;

  @Override
  public Promotion getPromotion(String id) {
    return Try.of(() -> promotionsRepository.findById(id))
        .filter(Optional::isPresent)
        .map(voucher -> PromotionsMapper.INSTANCE.toDomain(voucher.orElse(null)))
        .get();
  }

  @Override
  public List<Promotion> getPromotionsBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId) {
    return Try.of(() -> promotionsRepository.findPromotionsBy(name, description, establishmentId, startDate, endDate))
        .map(PromotionsMapper.INSTANCE::toDomainList)
        .get();
  }

  @Override
  public Page<Promotion> getPageablePromotionsBy(String name, String description, LocalDate startDate, LocalDate endDate,
                                                 String establishmentId, Pageable pageable) {
    return Try.of(() -> promotionsRepository.findPageablePromotionsBy(name, description, establishmentId, startDate, endDate, pageable))
        .map(PromotionsMapper.INSTANCE::toPromotionPageableResponse)
        .get();
  }
}
