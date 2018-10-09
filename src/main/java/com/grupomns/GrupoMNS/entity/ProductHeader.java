package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name = "VGF_ITE_APP")
@IdClass(ProductHeaderId.class)
public class ProductHeader {

  @Id
  @Column(name = "CODPROD")
  private int cod;

  @Id
  @Column(name = "NUNOTA")
  private int nuNota;

  @Column(name = "DESCRPROD")
  private String descricao;

  @Column(name = "QTDNEG")
  private float qtdItens;

  @Column(name = "CODVOL")
  private String codVol;

  @Column(name = "CONTROLE")
  private String controle;

  @Column(name = "VLRUNIT")
  private float vlrUnit;

  @Column(name = "VLRTOTAL")
  private float vlrTotal;

  @Column(name = "AD_CODPROJ")
  private int adCodProj;

  @Column(name = "PROJETO")
  private String project;

  @Column(name = "CODVEND")
  private int codVend;

  public int getNuNota() {
    return nuNota;
  }

  public void setNuNota(int nuNota) {
    this.nuNota = nuNota;
  }

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

  public float getQtdItens() {
    return qtdItens;
  }

  public void setQtdItens(float qtdItens) {
    this.qtdItens = qtdItens;
  }

  public String getCodVol() {
    return codVol;
  }

  public void setCodVol(String codVol) {
    this.codVol = codVol;
  }

  public String getControle() {
    return controle;
  }

  public void setControle(String controle) {
    this.controle = controle;
  }

  public float getVlrUnit() {
    return vlrUnit;
  }

  public void setVlrUnit(float vlrUnit) {
    this.vlrUnit = vlrUnit;
  }

  public float getVlrTotal() {
    return vlrTotal;
  }

  public void setVlrTotal(float vlrTotal) {
    this.vlrTotal = vlrTotal;
  }

  public int getAdCodProj() {
    return adCodProj;
  }

  public void setAdCodProj(int adCodProj) {
    this.adCodProj = adCodProj;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }

  public int getCodVend() {
    return codVend;
  }

  public void setCodVend(int codVend) {
    this.codVend = codVend;
  }
}
