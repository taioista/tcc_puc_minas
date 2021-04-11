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
  
  public Norma(String codigo, String descricao, IndicadorStatusNorma status) {
    this.codigo = codigo;
    this.descricao = descricao;
    this.status = status;
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

  
  /** 
   * @return int
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
    result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
    result = prime * result + ((status == null) ? 0 : status.hashCode());
    return result;
  }

  /** 
   * @param obj
   * @return boolean
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Norma other = (Norma) obj;
    if (codigo == null) {
      if (other.codigo != null)
        return false;
    } else if (!codigo.equals(other.codigo))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    } else if (!descricao.equals(other.descricao))
      return false;
    if (status != other.status)
      return false;
    return true;
  }
}
