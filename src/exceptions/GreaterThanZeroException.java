package exceptions;

public class GreaterThanZeroException extends RuntimeException {
  public GreaterThanZeroException(
    String message
  ) {
    super(message);
  }
}