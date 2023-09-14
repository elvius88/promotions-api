package py.com.jaha.api.promotions.domain.ports.out;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.jaha.api.promotions.domain.models.offers.Offer;

public interface OffersRepositoryPort {

  Offer getOffer(String id);

  List<Offer> getOffersBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId);

  Page<Offer> getPageableOffersBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId, Pageable pageable);
}
