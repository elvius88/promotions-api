package py.com.jaha.api.establishments.config.exception;

public class ApiTimeoutException extends ApiException {
  public ApiTimeoutException(String code, String message) {
    super(code, message, ApiExceptionType.COMMUNICATION);
  }
}
