package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.offers.entities.Offers;

@Repository
public interface OffersRepository extends CrudRepository<Offers, String> {

  @Query("SELECT o FROM Offers o " +
      "WHERE (:name IS NULL OR o.name LIKE %:name% ) " +
      "AND (:description IS NULL OR o.description LIKE %:description% ) " +
      "AND (:establishmentId IS NULL OR o.establishmentBranchId = :establishmentId)" +
      "AND (:startDate IS NULL OR o.startDate = :startDate ) " +
      "AND (:endDate IS NULL OR o.endDate = :endDate ) ")
  List<Offers> findOffersBy(@Param("name") String name,
                            @Param("description") String description,
                            @Param("establishmentId") String establishmentId,
                            @Param("startDate") LocalDate startDate,
                            @Param("endDate") LocalDate endDate);

  @Query(value = "SELECT o FROM Offers o " +
      "WHERE (:name IS NULL OR o.name LIKE %:name% ) " +
      "AND (:description IS NULL OR o.description LIKE %:description% ) " +
      "AND (:establishmentId IS NULL OR o.establishmentBranchId = :establishmentId)" +
      "AND (:startDate IS NULL OR o.startDate = :startDate ) " +
      "AND (:endDate IS NULL OR o.endDate = :endDate )",
      countQuery = "SELECT COUNT(o.id) FROM Offers o " +
          "WHERE (:name IS NULL OR o.name LIKE %:name% ) " +
          "AND (:description IS NULL OR o.description LIKE %:description% ) " +
          "AND (:establishmentId IS NULL OR o.establishmentBranchId = :establishmentId)" +
          "AND (:startDate IS NULL OR o.startDate = :startDate ) " +
          "AND (:endDate IS NULL OR o.endDate = :endDate )")
  Page<Offers> findPageableOffersBy(@Param("name") String name,
                                    @Param("description") String description,
                                    @Param("establishmentId") String establishmentId,
                                    @Param("startDate") LocalDate startDate,
                                    @Param("endDate") LocalDate endDate,
                                    Pageable pageable);
}

