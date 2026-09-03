package br.com.rprojetos.FipeConsulta.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.crypto.Data;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Avaliacao(@JsonProperty("Valor") String valor,@JsonProperty("Marca") String marca,@JsonProperty("Modelo") String modelo,@JsonProperty("AnoModelo") String anoModelo, @JsonProperty("Combustivel")String combustivel, @JsonProperty("CodigoFipe")String codigoFipe ) {
}
