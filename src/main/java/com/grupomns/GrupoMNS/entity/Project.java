package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "AD_VPRJATV")
public class Project {

  @Id
  @Column(name = "CODPROJ")
  private int code;

  @Column(name = "PROJETO")
  private String name;

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
}
