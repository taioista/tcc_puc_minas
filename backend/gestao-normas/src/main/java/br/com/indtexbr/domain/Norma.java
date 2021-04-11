package br.com.indtexbr.domain;

import java.io.Serializable;
import java.util.Date;

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
  private Date ultimaAtualizacao;
  
  public Norma() {}

  public Norma(Long id, String codigo, String descricao, IndicadorStatusNorma status, Date ultimaAtualizacao) {
    this.id = id;
    this.codigo = codigo;
    this.descricao = descricao;
    this.status = status;
    this.ultimaAtualizacao = ultimaAtualizacao;
  }
  
  
  /** 
   * @return Long
   */
  public Long getId() {
    return id;
  }
  
  /** 
   * @param id
   */
  public void setId(Long id) {
    this.id = id;
  }
  
  /** 
   * @return String
   */
  public String getCodigo() {
    return codigo;
  }
  
  /** 
   * @param codigo
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }
  
  /** 
   * @return String
   */
  public String getDescricao() {
    return descricao;
  }
  
  /** 
   * @param descricao
   */
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
  /** 
   * @return IndicadorStatusNorma
   */
  public IndicadorStatusNorma getStatus() {
    return status;
  }
  
  /** 
   * @param status
   */
  public void setStatus(IndicadorStatusNorma status) {
    this.status = status;
  }

  
  /** 
   * @return Date
   */
  public Date getUltimaAtualizacao() {
    return ultimaAtualizacao;
  }

  
  /** 
   * @param ultimaAtualizacao
   */
  public void setUltimaAtualizacao(Date ultimaAtualizacao) {
    this.ultimaAtualizacao = ultimaAtualizacao;
  }
}
