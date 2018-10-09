package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VGF_EMP_APP")
public class Company {

  @Id
  @Column(name = "CODEMP")
  private int code;

  @Column(name = "NOMEFANTASIA")
  private String fantasyName;

  @Column(name = "CPF_CNPJ")
  private String cpfCNPJ;

  @Column(name = "CIDADE")
  private String city;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getFantasyName() {
    return fantasyName;
  }

  public void setFantasyName(String fantasyName) {
    this.fantasyName = fantasyName;
  }

  public String getCpfCNPJ() {
    return cpfCNPJ;
  }

  public void setCpfCNPJ(String cpfCNPJ) {
    this.cpfCNPJ = cpfCNPJ;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }
}
