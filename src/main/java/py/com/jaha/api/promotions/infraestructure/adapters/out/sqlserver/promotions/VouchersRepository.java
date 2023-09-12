package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions.entities.Vouchers;

@Repository
public interface VouchersRepository extends CrudRepository<Vouchers, String> {

  @Query("SELECT v FROM Vouchers v " +
      "JOIN VoucherClients vc ON v.id = vc.voucherId " +
      "JOIN VoucherEstablishmentBranches ve ON v.id = ve.voucherId " +
      "WHERE (:clientId IS NULL OR vc.clientId = :clientId) " +
      "AND (:establishmentId IS NULL OR ve.establishmentBranchId = :establishmentId) " +
      "ORDER BY v.createdAt")
  List<Vouchers> findVouchersBy(@Param("clientId") String clientId,
                                @Param("establishmentId") String establishmentId);
}

