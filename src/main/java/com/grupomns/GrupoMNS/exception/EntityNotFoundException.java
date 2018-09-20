package com.grupomns.GrupoMNS.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EntityNotFoundException extends RestApiBaseException {

  public EntityNotFoundException(String message) {
    super(message);
  }

}
