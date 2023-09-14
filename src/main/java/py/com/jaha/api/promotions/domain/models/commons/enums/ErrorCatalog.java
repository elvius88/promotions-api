package py.com.jaha.api.promotions.domain.models.commons.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCatalog {
  GLOBAL_GENERAL_DATABASE_ERROR_CODE("PRO0001", "Error de conexión con la base de datos", null),
  GLOBAL_VALIDATION_ERROR_CODE("PRO0002", "Datos de búsqueda incorrectos", null),
  NOT_FOUND("PRO0003", "Datos no encontrados", null),
  ERROR_GETTING_EXTERNAL_CODE("PRO0004", "Error de BanTotal no configurado", null),
  INVALID_JSON_DATA_SERIALIZE("PRO0005", "Ocurrió un error al serializar la información", null),
  INVALID_JSON_DATA_PARAM("PRO0006", "Ocurrió un error al deserializar la información", null);

  private final String code;
  private final String description;
  private final Long externalCode;
}
