package br.com.indtexbr.domain;

public enum IndicadorStatusNorma {
  EM_VIGOR("Em Vigor"),
  CANCELADA("Cancelada");

    private String descricao;

    IndicadorStatusNorma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
