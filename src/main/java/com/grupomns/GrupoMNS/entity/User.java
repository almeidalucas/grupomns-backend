package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "VGF_VENDUSU_APP")
public class User {

  @Id
  @Column(name = "CODUSU")
  private String code;

  @Column(name = "NOMEUSU")
  private String name;

  @Column(name = "APELIDO")
  private String nickname;

  @Column(name = "CODVEND")
  private String sellerCode;

  @Column(name = "SENHA")
  private String password;

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getSellerCode() {
    return sellerCode;
  }

  public void setSellerCode(String sellerCode) {
    this.sellerCode = sellerCode;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
