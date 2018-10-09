package com.grupomns.GrupoMNS.entity;

import java.io.Serializable;
import java.util.Objects;

public class ProductHeaderId implements Serializable {

  private int cod;
  private int nuNota;

  public ProductHeaderId() {
  }

  public ProductHeaderId(int cod, int nuNota) {
    this.cod = cod;
    this.nuNota = nuNota;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProductHeaderId taskId1 = (ProductHeaderId) o;
    if (cod != taskId1.cod) return false;
    return nuNota == taskId1.nuNota;
  }

  @Override
  public int hashCode() {
    return Objects.hash(cod, nuNota);
  }
}
