package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers;

import io.vavr.control.Try;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import py.com.jaha.api.promotions.domain.models.offers.Offer;
import py.com.jaha.api.promotions.domain.ports.out.OffersRepositoryPort;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers.mapper.OffersMapper;

@Service
@Slf4j
@RequiredArgsConstructor
public class OffersRepositoryAdapter implements OffersRepositoryPort {

  private final OffersRepository offersRepository;

  @Override
  public Offer getOffer(String id) {
    return Try.of(() -> offersRepository.findById(id))
        .filter(Optional::isPresent)
        .map(voucher -> OffersMapper.INSTANCE.toDomain(voucher.orElse(null)))
        .get();
  }

  @Override
  public List<Offer> getOffersBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId) {
    return Try.of(() -> offersRepository.findOffersBy(name, description, establishmentId, startDate, endDate))
        .map(OffersMapper.INSTANCE::toDomainList)
        .get();
  }

  @Override
  public Page<Offer> getPageableOffersBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId, Pageable pageable) {
    return Try.of(() -> offersRepository.findPageableOffersBy(name, description, establishmentId, startDate, endDate, pageable))
        .map(OffersMapper.INSTANCE::toOffersPageableResponse)
        .get();
  }
}
