package br.com.rprojetos.FipeConsulta.services;

import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados{

private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> classe) {
        return mapper.readValue(json, classe);
    }

    @Override
    public <T> T obterDados(String json, TypeReference<T> tipo) {
        return mapper.readValue(json, tipo);
    }
}
