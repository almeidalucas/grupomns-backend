package com.grupomns.GrupoMNS;

import com.grupomns.GrupoMNS.exception.RestApiBaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ErrorResponse extends RestApiBaseException {

  public ErrorResponse(String message) {
    super(message);
  }

}
