package py.com.jaha.api.establishments.domain.usecases.utils;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static io.vavr.API.Match;
import static io.vavr.Predicates.instanceOf;
import static py.com.jaha.api.establishments.config.exception.ErrorHandler.internalError;
import static py.com.jaha.api.establishments.config.exception.ErrorHandler.notFound;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import py.com.jaha.api.establishments.config.exception.ApiException;
import py.com.jaha.api.establishments.domain.models.commons.enums.ErrorCatalog;

@UtilityClass
public class LogUtil {

  /**
   * Logger utility class.
   *
   * @param log  sl4f implementor
   * @param message message to display
   * @param errorCatalog errorCatalog code and description
   * @return Throwable
   */
  public static Consumer<Throwable> logAndThrows(Logger log, String message, ErrorCatalog errorCatalog) {
    return error -> Match(error).of(
        Case($(instanceOf(ApiException.class)), ae -> {
          log.error(message, ae.getMessage(), ae);
          throw ae;
        }),
        Case($(instanceOf(NoSuchElementException.class)), ae -> {
          log.error(message, ae.getMessage(), ae);
          throw notFound(errorCatalog.getCode(), errorCatalog.getDescription());
        }),
        Case($(), t -> {
          log.error(message, t.getMessage(), t);
          throw internalError(errorCatalog.getCode(), errorCatalog.getDescription());
        }));
  }
}
