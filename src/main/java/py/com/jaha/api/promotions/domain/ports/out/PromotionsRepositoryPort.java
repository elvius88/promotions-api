package py.com.jaha.api.promotions.domain.ports.out;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import py.com.jaha.api.promotions.domain.models.promotions.Promotion;

public interface PromotionsRepositoryPort {

  Promotion getPromotion(String id);

  List<Promotion> getPromotionsBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId);

  Page<Promotion> getPageablePromotionsBy(String name, String description, LocalDate startDate, LocalDate endDate, String establishmentId, Pageable pageable);
}
