package br.com.rprojetos.FipeConsulta.principal;

import br.com.rprojetos.FipeConsulta.models.*;
import br.com.rprojetos.FipeConsulta.services.ConsumoApi;
import br.com.rprojetos.FipeConsulta.services.ConverteDados;
import tools.jackson.core.type.TypeReference;
import java.util.List;
import java.util.Scanner;

public class Principal {

    private Scanner leitura = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();
    private ConsumoApi consumo = new ConsumoApi();


    public void exibirMenu(){


        System.out.println("""
        Digite o tipo de veículo:
        1 - Carros
        2 - Motos
        3 - Caminhões        
                """
    );

        int tipodoVeiculo = leitura.nextInt();
        leitura.nextLine();
        String tipoVeiculo;
        String url;

        switch (tipodoVeiculo) {
            case 1:
                url = "https://parallelum.com.br/fipe/api/v1/carros/marcas";
                System.out.println("Você escolheu carros");
                tipoVeiculo = "carros";
                break;

            case 2:
                url = "https://parallelum.com.br/fipe/api/v1/motos/marcas";
                System.out.println("Você escolheu motos");
                tipoVeiculo = "motos";
                break;
            case 3:
                url = "https://parallelum.com.br/fipe/api/v1/caminhoes/marcas";
                System.out.println("Você escolheu caminhões");
                tipoVeiculo= "caminhoes";
                break;
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido");
        }


        String json = consumo.obterDados(url);

        List<Marca> marcas = conversor.obterDados(json, new TypeReference<List<Marca>>() {});


        marcas.forEach(m -> System.out.println(
                "Código: " + m.codigo() + " - " + m.nome()
        ));


        System.out.println("Digite o numero do código ");
        var codigoMarca = leitura.nextLine();


        Marca marcaEscolhida = marcas.stream()
                .filter(m-> m.codigo().equals(codigoMarca))
                .findFirst()
                .orElseThrow();

        String urlModelos = "https://parallelum.com.br/fipe/api/v1/"
                + tipoVeiculo
                + "/marcas/"
                + marcaEscolhida.codigo()
                + "/modelos";


        String jsonModelos = consumo.obterDados(urlModelos);

        DadosModelos dadosModelo = conversor.obterDados(
                jsonModelos, DadosModelos.class
        );

        List<Modelo> modelos = dadosModelo.modelos();

        modelos.forEach(m-> System.out.println("Código: " + m.codigo() +  " - " + m.nome()));


        System.out.println("Digite o código do modelo: ");
        var codigoModelo = leitura.nextLine();

        Modelo modeloEscolhido = modelos.stream()
                .filter(m-> m.codigo().equals(codigoModelo))
                .findFirst()
                .orElseThrow();


        String urlAnos = "https://parallelum.com.br/fipe/api/v1/" +
                tipoVeiculo +
                "/marcas/" +
                marcaEscolhida.codigo() +
                "/modelos/" +
                modeloEscolhido.codigo() +
                "/anos";



        String jsonAnos = consumo.obterDados(urlAnos);
        System.out.println(jsonAnos);

        List<Ano> anos = conversor.obterDados(jsonAnos, new TypeReference<List<Ano>>() {
        });


        anos.forEach(ano -> {

            String urlAno = "https://parallelum.com.br/fipe/api/v1/" +
                    tipoVeiculo +
                    "/marcas/" +
                    marcaEscolhida.codigo() +
                    "/modelos/" +
                    modeloEscolhido.codigo() +
                    "/anos/" +
                    ano.codigo();

            String jsonAno = consumo.obterDados(urlAno);

            Avaliacao avaliacao = conversor.obterDados(jsonAno, Avaliacao.class);
            System.out.println(

                    "Marca: " + avaliacao.marca() +
                            " Modelo: " + avaliacao.modelo() +
                            " Ano: " + avaliacao.anoModelo() +
                            " Combustível: " + avaliacao.combustivel() +
                            " Valor: " + avaliacao.valor() +
                            " Código Fipe: " + avaliacao.codigoFipe()


                    );
        });



    }
}
