package com.grupomns.GrupoMNS.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity(name = "VGF_CAB_APP")
public class OrderHeader {

  private static final String ddMMyyyy = "dd/MM/yyyy";

  @Id
  @Column(name = "NUNOTA")
  private int nuNota;

  @Column(name = "NUMNOTA")
  private int numNota;

  @Column(name = "CODEMP")
  private int codEmp;

  @Column(name = "NOMEFANTASIA")
  private String nomeEmp;

  @Column(name = "CODPARC")
  private int codParc;

  @Column(name = "NOMEPARC")
  private String nomeParc;

  @Column(name = "CODVEND")
  private int codVend;

  @Column(name = "CODTIPOPER")
  private int codTipOper;

  @Column(name = "CODTIPVENDA")
  private int codTipVenda;

  @Column(name = "DESCRTIPVENDA")
  private String dscTipVenda;

  @Column(name = "DTNEG")
  private Date dtNeg;

  @Column(name = "VLRNOTA")
  private float vlrNota;

  @Column(name = "CODNAT")
  private int codNat;

  @Column(name = "CODCENCUS")
  private int codCencus;

  @Column(name = "CODPROJ")
  private int codProj;

  @Column(name = "OBS")
  private String observacao;

  @Column(name = "STATUSNOTA")
  private String statusNota;

  @Column(name = "NUAPP")
  private int nuApp;

  @Column(name = "CODUSU")
  private int codUsu;

  @Column(name = "NRO_NF")
  private String nroNF;

  @Column(name = "PENDENTE")
  private String pendente;

  @Column(name = "TIP_MOV")
  private String tipMov;

  public int getNuNota() {
    return nuNota;
  }

  public void setNuNota(int nuNota) {
    this.nuNota = nuNota;
  }

  public int getNumNota() {
    return numNota;
  }

  public void setNumNota(int numNota) {
    this.numNota = numNota;
  }

  public int getCodEmp() {
    return codEmp;
  }

  public void setCodEmp(int codEmp) {
    this.codEmp = codEmp;
  }

  public String getNomeEmp() {
    return nomeEmp;
  }

  public void setNomeEmp(String nomeEmp) {
    this.nomeEmp = nomeEmp;
  }

  public int getCodParc() {
    return codParc;
  }

  public void setCodParc(int codParc) {
    this.codParc = codParc;
  }

  public String getNomeParc() {
    return nomeParc;
  }

  public void setNomeParc(String nomeParc) {
    this.nomeParc = nomeParc;
  }

  public int getCodVend() {
    return codVend;
  }

  public void setCodVend(int codVend) {
    this.codVend = codVend;
  }

  public int getCodTipOper() {
    return codTipOper;
  }

  public void setCodTipOper(int codTipOper) {
    this.codTipOper = codTipOper;
  }

  public int getCodTipVenda() {
    return codTipVenda;
  }

  public void setCodTipVenda(int codTipVenda) {
    this.codTipVenda = codTipVenda;
  }

  public String getDscTipVenda() {
    return dscTipVenda;
  }

  public void setDscTipVenda(String dscTipVenda) {
    this.dscTipVenda = dscTipVenda;
  }

  public Date getDtNeg() {
    return dtNeg;
  }

  public void setDtNeg(Date dtNeg) {
    this.dtNeg = dtNeg;
  }

  public float getVlrNota() {
    return vlrNota;
  }

  public void setVlrNota(float vlrNota) {
    this.vlrNota = vlrNota;
  }

  public int getCodNat() {
    return codNat;
  }

  public void setCodNat(int codNat) {
    this.codNat = codNat;
  }

  public int getCodCencus() {
    return codCencus;
  }

  public void setCodCencus(int codCencus) {
    this.codCencus = codCencus;
  }

  public int getCodProj() {
    return codProj;
  }

  public void setCodProj(int codProj) {
    this.codProj = codProj;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public String getStatusNota() {
    return statusNota;
  }

  public void setStatusNota(String statusNota) {
    this.statusNota = statusNota;
  }

  public int getNuApp() {
    return nuApp;
  }

  public void setNuApp(int nuApp) {
    this.nuApp = nuApp;
  }

  public int getCodUsu() {
    return codUsu;
  }

  public void setCodUsu(int codUsu) {
    this.codUsu = codUsu;
  }

  public String getNroNF() {
    return nroNF;
  }

  public void setNroNF(String nroNF) {
    this.nroNF = nroNF;
  }

  public String getPendente() {
    return pendente;
  }

  public void setPendente(String pendente) {
    this.pendente = pendente;
  }

  public String getTipMov() {
    return tipMov;
  }

  public void setTipMov(String tipMov) {
    this.tipMov = tipMov;
  }

  public String getFormattedDateDDMMYYYY() {
    if (this.dtNeg == null)
      return null;

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(ddMMyyyy);

    return simpleDateFormat.format(this.dtNeg);
  }
}
