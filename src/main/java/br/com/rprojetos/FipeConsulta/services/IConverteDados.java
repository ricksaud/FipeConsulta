package br.com.rprojetos.FipeConsulta.services;

import tools.jackson.core.type.TypeReference;

public interface IConverteDados {

    <T> T obterDados(String json, Class <T> classe);

    <T> T obterDados(String json, TypeReference<T> tipo);
}
