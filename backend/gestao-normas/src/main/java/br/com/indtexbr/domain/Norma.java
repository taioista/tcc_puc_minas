package br.com.indtexbr.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Norma implements Serializable{
  private static final long serialVersionUID = -4916121264127313472L;
  private @Id @GeneratedValue Long id;
  private String codigo;
  private String descricao;
  private IndicadorStatusNorma status;
  
public Norma() {}

  public Norma(Long id, String codigo, String descricao, IndicadorStatusNorma status) {
    this.id = id;
    this.codigo = codigo;
    this.descricao = descricao;
    this.status = status;
  }
  
  public Long getId() {
    return id;
  }
  public void setId(Long id) {
    this.id = id;
  }
  public String getCodigo() {
    return codigo;
  }
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public IndicadorStatusNorma getStatus() {
    return status;
  }
  public void setStatus(IndicadorStatusNorma status) {
    this.status = status;
  }
}
