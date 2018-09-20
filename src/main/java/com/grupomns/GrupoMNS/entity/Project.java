package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "AD_VPRJATV")
public class Project {

  @Id
  @Column(name = "CODPROJ")
  private int projectCode;

  @Column(name = "PROJETO")
  private String project;

  public int getProjectCode() {
    return projectCode;
  }

  public void setProjectCode(int projectCode) {
    this.projectCode = projectCode;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }
}
