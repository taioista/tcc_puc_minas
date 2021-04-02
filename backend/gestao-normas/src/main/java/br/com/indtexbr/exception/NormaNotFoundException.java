package br.com.indtexbr.exception;

 public class NormaNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -9159251229905519207L;

  public NormaNotFoundException(Long id) {
    super("Could not find norma " + id);
  }
}
