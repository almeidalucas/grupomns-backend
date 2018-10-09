package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VGF_PARC_APP")
public class Partner {

  @Id
  @Column(name = "CODPARC")
  private int code;

  @Column(name = "NOMEPARC")
  private String name;

  @Column(name = "CPF_CNPJ")
  private String cpfCNPJ;

  @Column(name = "CODTIPVENDA")
  private int sellTypeCode;

  @Column(name = "DESCRTIPVENDA")
  private String sellDescType;

  @Column(name = "CIDADE")
  private String city;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCpfCNPJ() {
    return cpfCNPJ;
  }

  public void setCpfCNPJ(String cpfCNPJ) {
    this.cpfCNPJ = cpfCNPJ;
  }

  public int getSellTypeCode() {
    return sellTypeCode;
  }

  public void setSellTypeCode(int sellTypeCode) {
    this.sellTypeCode = sellTypeCode;
  }

  public String getSellDescType() {
    return sellDescType;
  }

  public void setSellDescType(String sellDescType) {
    this.sellDescType = sellDescType;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
