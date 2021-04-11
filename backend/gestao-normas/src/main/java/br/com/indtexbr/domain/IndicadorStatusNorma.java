package br.com.indtexbr.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum IndicadorStatusNorma {
    @JsonProperty("Em Vigor")
    EM_VIGOR("Em Vigor"),
    
    @JsonProperty("Cancelada")
    CANCELADA("Cancelada");

    private String descricao;

    IndicadorStatusNorma(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
