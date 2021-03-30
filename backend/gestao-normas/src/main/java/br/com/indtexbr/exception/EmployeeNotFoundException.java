package br.com.indtexbr.exception;

 public class EmployeeNotFoundException extends RuntimeException {

  private static final long serialVersionUID = -9159251229905519207L;

  public EmployeeNotFoundException(Long id) {
    super("Could not find employee " + id);
  }
}
