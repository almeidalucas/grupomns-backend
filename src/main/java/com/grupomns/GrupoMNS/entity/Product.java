package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VGF_PROD_APP")
public class Product {

  @Id
  @Column(name = "CODPROD")
  private int cod;

  @Column(name = "DESCRPROD")
  private String descricao;

  @Column(name = "DESCRPRODNFE")
  private String descrNFE;

  @Column(name = "EMBALAGEM")
  private String embalagem;

  @Column(name = "CODVOL")
  private String codVol;

  public int getCod() {
    return cod;
  }

  public void setCod(int cod) {
    this.cod = cod;
  }

  public String getDescricao() {
    return descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getDescrNFE() {
    return descrNFE;
  }

  public void setDescrNFE(String descrNFE) {
    this.descrNFE = descrNFE;
  }

  public String getEmbalagem() {
    return embalagem;
  }

  public void setEmbalagem(String embalagem) {
    this.embalagem = embalagem;
  }

  public String getCodVol() {
    return codVol;
  }

  public void setCodVol(String codVol) {
    this.codVol = codVol;
  }
}
