package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VGT_TIPONEG_APP")
public class OperationType {

  @Id
  @Column(name = "CODTIPOPER")
  private String codTipOper;

  @Column(name = "DESCRICAO")
  private String descricao;

  public String getCodTipOper() {
    return codTipOper;
  }

  public void setCodTipOper(String codTipOper) {
    this.codTipOper = codTipOper;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
}
