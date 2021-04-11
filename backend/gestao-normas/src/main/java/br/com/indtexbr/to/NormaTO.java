package br.com.indtexbr.to;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.indtexbr.domain.IndicadorStatusNorma;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NormaTO {
  private String codigo;
  private String descricao;
  private IndicadorStatusNorma status;
  public NormaTO() {
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
  @Override
  public String toString() {
    return "NormaTO [codigo=" + codigo + ", descricao=" + descricao + ", status=" + status + "]";
  } 
}
