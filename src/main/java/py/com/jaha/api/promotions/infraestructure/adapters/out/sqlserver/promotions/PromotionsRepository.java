package py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.promotions.infraestructure.adapters.out.sqlserver.promotions.entities.Promotions;

@Repository
public interface PromotionsRepository extends CrudRepository<Promotions, String> {

  @Query(value = "SELECT p FROM Promotions p " +
      "WHERE (:name IS NULL OR p.name LIKE %:name% ) " +
      "AND (:description IS NULL OR p.description LIKE %:description% ) " +
      "AND (:establishmentId IS NULL OR p.establishmentBranchId = :establishmentId) " +
      "AND (:startDate IS NULL OR p.startDate = :startDate ) " +
      "AND (:endDate IS NULL OR p.endDate = :endDate )")
  List<Promotions> findPromotionsBy(@Param("name") String name,
                                    @Param("description") String description,
                                    @Param("establishmentId") String establishmentId,
                                    @Param("startDate") LocalDate startDate,
                                    @Param("endDate") LocalDate endDate);

  @Query(value = "SELECT p FROM Promotions p " +
      "WHERE (:name IS NULL OR p.name LIKE %:name% ) " +
      "AND (:description IS NULL OR p.description LIKE %:description% ) " +
      "AND (:establishmentId IS NULL OR p.establishmentBranchId = :establishmentId) " +
      "AND (:startDate IS NULL OR p.startDate = :startDate ) " +
      "AND (:endDate IS NULL OR p.endDate = :endDate )",
      countQuery = "SELECT COUNT(p.id) FROM Promotions p " +
          "WHERE (:name IS NULL OR p.name LIKE %:name% ) " +
          "AND (:description IS NULL OR p.description LIKE %:description% ) " +
          "AND (:establishmentId IS NULL OR p.establishmentBranchId = :establishmentId) " +
          "AND (:startDate IS NULL OR p.startDate = :startDate ) " +
          "AND (:endDate IS NULL OR p.endDate = :endDate )")
  Page<Promotions> findPageablePromotionsBy(@Param("name") String name,
                                            @Param("description") String description,
                                            @Param("establishmentId") String establishmentId,
                                            @Param("startDate") LocalDate startDate,
                                            @Param("endDate") LocalDate endDate,
                                            Pageable pageable);
}

