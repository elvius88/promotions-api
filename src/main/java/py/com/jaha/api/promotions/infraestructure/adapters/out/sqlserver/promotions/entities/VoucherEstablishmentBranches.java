package py.com.jaha.api.establishments.infraestructure.adapters.out.sqlserver.promotions.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "voucher_establishment_branches")
@ToString
public class VoucherEstablishmentBranches implements Serializable {

  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  @Column(nullable = false, updatable = false)
  private String id;

  @Column(name = "voucher_id", nullable = false)
  private String voucherId;

  @Column(name = "establishment_branch_id", nullable = false)
  private String establishmentBranchId;
}
