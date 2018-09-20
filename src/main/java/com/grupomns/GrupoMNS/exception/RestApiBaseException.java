package com.grupomns.GrupoMNS.exception;

public abstract class RestApiBaseException extends Exception {

  public RestApiBaseException() {

  }

  public RestApiBaseException(String message) {
    super(message);
  }

  public RestApiBaseException(String message, Throwable cause) {
    super(message, cause);
  }

  public RestApiBaseException(Throwable cause) {
    super(cause);
  }

}
