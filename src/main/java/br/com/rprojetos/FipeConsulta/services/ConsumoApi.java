package br.com.rprojetos.FipeConsulta.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {

public String obterDados(String endereco){

    // Criando o cliente HTTP
    HttpClient client = HttpClient.newHttpClient();

    // Criando a requisição
    HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();

    // Enviando a requisição e retornando o JSON
    try {
        HttpResponse<String> response = client.send(
                request,
                HttpResponse.BodyHandlers.ofString()
        );

        return response.body();

    } catch (IOException | InterruptedException e) {
        throw new RuntimeException(e);
    }

}

}
